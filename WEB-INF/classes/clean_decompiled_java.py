import os
import re

def clean_java_file(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        content = f.read()

    # Corriger le package
    content = re.sub(
        r'package\s+WEB-INF\.classes\.ma\.sofisoft\.cam2020ws',
        'package ma.sofisoft.cam2020ws',
        content
    )

    # Supprimer les blocs de commentaires autour des imports et annotations
    # 1. Décommenter les imports
    content = re.sub(r'/\*\s*\n(import [\s\S]+?;)\s*\n\*/', r'\1', content)
    # 2. Décommenter les annotations (ex: @Entity, @Table, @Transient, etc.)
    content = re.sub(r'/\*\s*\n(@[A-Za-z0-9_()., =\"]+)\s*\n\*/', r'\1', content)

    # Supprimer les blocs de commentaires vides ou inutiles
    content = re.sub(r'/\*\s*\.\.\.\s*\*/', '', content)
    content = re.sub(r'/\*\s*\*/', '', content)

    # Nettoyer les lignes vides multiples
    content = re.sub(r'\n{3,}', '\n\n', content)

    with open(filepath, 'w', encoding='utf-8') as f:
        f.write(content)

def clean_all_java_files(root_dir):
    for subdir, _, files in os.walk(root_dir):
        for file in files:
            if file.endswith('.java'):
                filepath = os.path.join(subdir, file)
                clean_java_file(filepath)
                print(f"Nettoyé : {filepath}")

if __name__ == "__main__":
    dossier = input("Chemin du dossier contenant les fichiers .java à nettoyer : ").strip()
    clean_all_java_files(dossier)
    print("Nettoyage terminé !") 