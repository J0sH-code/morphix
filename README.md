# Morphix

A modular, command-line file conversion tool built in Java. Morphix is designed to convert files across documents, images, and media formats through a clean and extensible CLI interface.

---

## Overview

Morphix is structured around a dispatcher pattern — a central router reads the input/output format pair and delegates to the appropriate converter module. Each module is independently responsible for its category of conversions, keeping the codebase clean and easy to extend.

---

## Planned Modules

| Module | Formats |
|---|---|
| Document Converter | PDF, DOCX |
| Image Converter | PNG, JPG, BMP, and more |
| Media Converter | Audio and video formats via FFmpeg |

---

## Tech Stack

- **Java** — core language
- **Maven** — build and dependency management
- **Picocli** — CLI argument parsing
- **Apache PDFBox** — PDF handling
- **Apache POI** — DOCX handling
- **TwelveMonkeys ImageIO** — extended image format support
- **FFmpeg** — audio/video conversion (must be installed separately)

---

## Project Status

🚧 **In Development** — architecture and scaffolding stage.

---

## Author

Josh Ryle R. Santeno
[github.com/yourusername](https://github.com/yourusername)
