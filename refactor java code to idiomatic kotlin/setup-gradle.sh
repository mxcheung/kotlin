#!/usr/bin/env bash
set -euo pipefail

GRADLE_VERSION="9.5.1"
DIST_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
HASH_DIR="iq79hdu3mqx29lgffhp8bfmx"
GRADLE_HOME="$HOME/gradle9.5"
DEST="$GRADLE_HOME/wrapper/dists/gradle-${GRADLE_VERSION}-bin/${HASH_DIR}"
ZIP="$DEST/gradle-${GRADLE_VERSION}-bin.zip"

export GRADLE_USER_HOME="$GRADLE_HOME"

# Install Gradle distribution
if [ -f "$DEST/gradle-${GRADLE_VERSION}-bin.zip.ok" ]; then
    echo "Gradle ${GRADLE_VERSION} already installed in $GRADLE_HOME."
else
    echo "Installing Gradle ${GRADLE_VERSION} into $GRADLE_HOME..."
    mkdir -p "$DEST"
    curl -L --fail --progress-bar -o "$ZIP" "$DIST_URL"
    (cd "$DEST" && unzip -q "$ZIP")
    touch "$DEST/gradle-${GRADLE_VERSION}-bin.zip.ok"
    echo "Gradle installed."
fi

# Pre-download all dependencies while internet is available
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

echo "Warming dependency cache for application..."
(cd "$SCRIPT_DIR/application" && ./gradlew resolveAllDependencies compileKotlin --quiet)

echo "Warming dependency cache for final..."
(cd "$SCRIPT_DIR/final" && ./gradlew resolveAllDependencies compileKotlin --quiet)

echo ""
echo "Setup complete. Add this to ~/.zshrc:"
echo "  export GRADLE_USER_HOME=\$HOME/gradle9.5"
