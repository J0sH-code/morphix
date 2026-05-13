package com.github.j0sh.converter;

import java.nio.file.Path;

public interface Converter {
    public void convert(Path filePath, String outputType, String outputName, Path outputPath);
}
