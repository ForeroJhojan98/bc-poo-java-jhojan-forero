#!/bin/bash

# Ruta al repositorio (sube un nivel desde /scripts)
REPO_DIR="$(cd "$(dirname "$0")/.." && pwd)"

# Configuración de Git
BRANCH="main"
GIT_USER="$GIT_USER"
GIT_EMAIL="$GIT_EMAIL"

# Entrar a la raíz del repositorio
cd "$REPO_DIR" || exit

# Configurar usuario de Git
git config user.name "$GIT_USER"
git config user.email "$GIT_EMAIL"

echo "=== Iniciando auto-commit ==="

CHANGES=$(git status --porcelain)

if [ -z "$CHANGES" ]; then
    echo "No hay cambios para commitear 😴"
else
    git add -A

    ADDED=$(echo "$CHANGES" | grep '^A' | wc -l)
    MODIFIED=$(echo "$CHANGES" | grep '^ M' | wc -l)
    DELETED=$(echo "$CHANGES" | grep '^ D' | wc -l)

    SUMMARY=""
    [ "$ADDED" -gt 0 ] && SUMMARY+="➕ Agregados: $ADDED. "
    [ "$MODIFIED" -gt 0 ] && SUMMARY+="✏️ Modificados: $MODIFIED. "
    [ "$DELETED" -gt 0 ] && SUMMARY+="❌ Borrados: $DELETED. "

    COMMIT_MSG="Auto-commit $(date '+%Y-%m-%d %H:%M:%S') | $SUMMARY
What? Archivos modificados
For? Mantener el repositorio actualizado
Impact? Evita perder cambios y mantiene historial
Auto-committed by script"

    if git commit -m "$COMMIT_MSG"; then
        echo "✅ Commit realizado: $SUMMARY"

        if git push origin "$BRANCH"; then
            echo "✅ Push exitoso 👍"
        else
            echo "⚠️ Push fallido, se intentará la próxima vez"
        fi
    else
        echo "❌ Commit fallido ⚠️"
    fi
fi

echo "=== Auto-commit finalizado ==="
