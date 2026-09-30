#!/bin/bash

# Path ke direktori target
TARGET_DIR="/workspaces/website/src/assets"

# Cek apakah direktori ada
if [ ! -d "$TARGET_DIR" ]; then
    echo "Error: Direktori $TARGET_DIR tidak ditemukan."
    exit 1
fi

echo "Memulai konversi gambar di $TARGET_DIR..."

# Cari file dengan ekstensi png, jpg, jpeg (case-insensitive) dan konversi
find "$TARGET_DIR" -type f \( -iname "*.png" -o -iname "*.jpg" -o -iname "*.jpeg" \) | while read -r FILE; do
    # Tentukan nama file output (.webp)
    OUTPUT_FILE="${FILE%.*}.webp"
    
    echo "Mengonversi: $FILE -> $OUTPUT_FILE"
    
    # Jalankan cwebp dengan kualitas default 80
    /workspaces/website/libwebp/bin/cwebp -q 80 "$FILE" -o "$OUTPUT_FILE"
done

echo "Selesai! Semua gambar berhasil dikonversi ke .webp."