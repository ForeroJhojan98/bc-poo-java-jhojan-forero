import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Clase ClienteMejorado - Encapsulación completa con validaciones
 * Representa un cliente de la librería "Mundo del Libro"
 */
public class ClienteMejorado {

    // ========== ATRIBUTOS PRIVADOS ==========
    private String documentoIdentidad;
    private String nombreCompleto;
    private String email;
    private String telefono;
    private String direccion;
    private int puntosFidelidad;
    private String tipoCliente; // REGULAR, ESTUDIANTE, DOCENTE

    // ========== CONSTANTES ==========
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    private static final String[] TIPOS_VALIDOS =
            {"REGULAR", "ESTUDIANTE", "DOCENTE", "PREMIUM"};

    // ========== CONSTRUCTORES (3 TOTAL) ==========

    /**
     * Constructor 1: Completo
     */
    public ClienteMejorado(String documentoIdentidad, String nombreCompleto,
                           String email, String telefono, String direccion,
                           String tipoCliente) {
        setDocumentoIdentidad(documentoIdentidad);
        setNombreCompleto(nombreCompleto);
        setEmail(email);
        setTelefono(telefono);
        setDireccion(direccion);
        setTipoCliente(tipoCliente);
        this.puntosFidelidad = 0;
    }

    /**
     * Constructor 2: Sin teléfono ni dirección
     */
    public ClienteMejorado(String documentoIdentidad, String nombreCompleto,
                           String email, String tipoCliente) {
        this(documentoIdentidad, nombreCompleto, email,
                "Sin teléfono registrado", "Sin dirección registrada", tipoCliente);
    }

    /**
     * Constructor 3: Mínimo (cliente regular)
     */
    public ClienteMejorado(String documentoIdentidad, String nombreCompleto,
                           String email) {
        this(documentoIdentidad, nombreCompleto, email, "REGULAR");
    }

    // ========== GETTERS (TODOS LOS ATRIBUTOS) ==========

    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public int getPuntosFidelidad() { return puntosFidelidad; }
    public String getTipoCliente() { return tipoCliente; }

    // ========== SETTERS CON VALIDACIONES ==========

    public void setDocumentoIdentidad(String documentoIdentidad) {
        Objects.requireNonNull(documentoIdentidad, "Documento no puede ser nulo");
        if (documentoIdentidad.trim().isEmpty()) {
            throw new IllegalArgumentException("Documento no puede estar vacío");
        }
        if (!validarDocumento(documentoIdentidad)) {
            throw new IllegalArgumentException("Formato de documento inválido");
        }
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setNombreCompleto(String nombreCompleto) {
        Objects.requireNonNull(nombreCompleto, "Nombre no puede ser nulo");
        if (nombreCompleto.trim().length() < 5) {
            throw new IllegalArgumentException("Nombre muy corto (mínimo 5 caracteres)");
        }
        if (nombreCompleto.trim().length() > 100) {
            throw new IllegalArgumentException("Nombre muy largo (máximo 100 caracteres)");
        }
        this.nombreCompleto = nombreCompleto;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email, "Email no puede ser nulo");
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty() && !validarTelefono(telefono)) {
            throw new IllegalArgumentException("Teléfono inválido");
        }
        this.telefono = (telefono == null || telefono.trim().isEmpty())
                ? "Sin teléfono registrado" : telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = (direccion == null || direccion.trim().isEmpty())
                ? "Sin dirección registrada" : direccion;
    }

    public void setTipoCliente(String tipoCliente) {
        Objects.requireNonNull(tipoCliente, "Tipo de cliente no puede ser nulo");
        tipoCliente = tipoCliente.toUpperCase();

        if (!esTipoClienteValido(tipoCliente)) {
            throw new IllegalArgumentException("Tipo de cliente inválido. Use: "
                    + String.join(", ", TIPOS_VALIDOS));
        }
        this.tipoCliente = tipoCliente;
    }

    // ========== MÉTODOS PÚBLICOS ==========

    public void acumularPuntos(int puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("Puntos no pueden ser negativos");
        }
        this.puntosFidelidad += puntos;
        System.out.println(nombreCompleto + " ganó " + puntos + " puntos. Total: " + puntosFidelidad);
    }

    public boolean canjearPuntos(int puntos) {
        if (puntos <= 0) {
            throw new IllegalArgumentException("Puntos a canjear deben ser positivos");
        }
        if (puntosFidelidad >= puntos) {
            puntosFidelidad -= puntos;
            System.out.println(nombreCompleto + " canjeó " + puntos + " puntos. Restantes: " + puntosFidelidad);
            return true;
        }
        System.out.println("Puntos insuficientes. Tienes: " + puntosFidelidad);
        return false;
    }

    public double aplicarDescuentoTipoCliente(double monto) {
        double descuento = 0;
        switch (tipoCliente) {
            case "ESTUDIANTE": descuento = 0.10; break; // 10%
            case "DOCENTE": descuento = 0.15; break;    // 15%
            case "PREMIUM": descuento = 0.20; break;    // 20%
            default: descuento = 0.05; break;           // 5% regular
        }
        return monto * (1 - descuento);
    }

    public void mostrarInformacion() {
        System.out.println("\n=== INFORMACIÓN DEL CLIENTE ===");
        System.out.println("Documento: " + documentoIdentidad);
        System.out.println("Nombre: " + nombreCompleto);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("Tipo: " + tipoCliente);
        System.out.println("Puntos Fidelidad: " + puntosFidelidad);
    }

    // ========== MÉTODOS PRIVADOS AUXILIARES ==========

    private boolean validarDocumento(String documento) {
        // Validación básica: solo números y longitud razonable
        return documento.matches("\\d{8,15}");
    }

    private boolean validarEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    private boolean validarTelefono(String telefono) {
        // Validación para teléfonos colombianos
        return telefono.matches("\\d{10}|\\d{7}");
    }

    private boolean esTipoClienteValido(String tipo) {
        for (String valido : TIPOS_VALIDOS) {
            if (valido.equals(tipo)) {
                return true;
            }
        }
        return false;
    }
}