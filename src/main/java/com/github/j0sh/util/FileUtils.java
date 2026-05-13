package com.github.j0sh.util;

import java.nio.file.Path;
import java.util.Locale;
import java.util.Set;

public final class FileUtils {
    private static final Set<String> IMAGE_EXTENSIONS = Set.of(
        "jpg", "jpeg", "png", "bmp", "gif", "tiff", "tif", "webp", "svg"
    );

    private static final Set<String> VIDEO_EXTENSIONS = Set.of(
        "mp4", "mov", "avi", "mkv", "webm", "flv", "wmv", "mpeg", "mpg"
    );

    private static final Set<String> AUDIO_EXTENSIONS = Set.of(
        "mp3", "wav", "ogg", "flac", "aac", "m4a", "wma"
    );

    private static final Set<String> DOCUMENT_EXTENSIONS = Set.of(
        "pdf", "doc", "docx", "xls", "xlsx", "ppt", "pptx", "txt", "rtf",
        "odt", "ods", "odp", "html", "htm", "xml", "csv"
    );

    private static final Set<String> ARCHIVE_EXTENSIONS = Set.of(
        "zip", "rar", "7z", "tar", "gz", "bz2", "xz"
    );

    private FileUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static FileType getFileType(Path filePath) {
        if (filePath == null) {
            return FileType.UNKNOWN;
        }
        return getFileType(filePath.getFileName() == null ? "" : filePath.getFileName().toString());
    }

    public static FileType getFileType(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return FileType.UNKNOWN;
        }

        String extension = getFileExtension(fileName);
        if (extension.isBlank()) {
            return FileType.UNKNOWN;
        }

        if (IMAGE_EXTENSIONS.contains(extension)) {
            return FileType.IMAGE;
        }
        if (VIDEO_EXTENSIONS.contains(extension)) {
            return FileType.VIDEO;
        }
        if (AUDIO_EXTENSIONS.contains(extension)) {
            return FileType.AUDIO;
        }
        if (DOCUMENT_EXTENSIONS.contains(extension)) {
            return FileType.DOCUMENT;
        }
        if (ARCHIVE_EXTENSIONS.contains(extension)) {
            return FileType.ARCHIVE;
        }

        return FileType.UNKNOWN;
    }

    public static String getFileExtension(Path filePath) {
        if (filePath == null) {
            return "";
        }
        return getFileExtension(filePath.getFileName() == null ? "" : filePath.getFileName().toString());
    }

    public static String getFileExtension(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return "";
        }

        String normalized = fileName.toLowerCase(Locale.ROOT);
        int lastDot = normalized.lastIndexOf('.');
        if (lastDot < 0 || lastDot == normalized.length() - 1) {
            return "";
        }
        return normalized.substring(lastDot + 1);
    }

    public static boolean isImage(Path filePath) {
        return getFileType(filePath) == FileType.IMAGE;
    }

    public static boolean isVideo(Path filePath) {
        return getFileType(filePath) == FileType.VIDEO;
    }

    public static boolean isAudio(Path filePath) {
        return getFileType(filePath) == FileType.AUDIO;
    }

    public static boolean isDocument(Path filePath) {
        return getFileType(filePath) == FileType.DOCUMENT;
    }

    public static boolean isArchive(Path filePath) {
        return getFileType(filePath) == FileType.ARCHIVE;
    }

    public static boolean isKnownType(Path filePath) {
        return getFileType(filePath) != FileType.UNKNOWN;
    }

    public static Path checkAbPath() {
        return null;
    }
}

