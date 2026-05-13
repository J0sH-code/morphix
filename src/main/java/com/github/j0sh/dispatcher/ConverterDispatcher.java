package com.github.j0sh.dispatcher;

import java.nio.file.Path;

import com.github.j0sh.converter.Converter;
import com.github.j0sh.converter.ImageConverter;
import com.github.j0sh.util.FileType;
import com.github.j0sh.util.FileUtils;

public class ConverterDispatcher {
    
    public static void execute(Path input, String outputType, String outputName, Path outputPath){
        Converter converter;
        FileType inputType = FileUtils.getFileType(input);
        switch (inputType) {
            case IMAGE -> {
                converter = new ImageConverter();
                converter.convert(input, outputType, outputName, outputPath);
            }
            case VIDEO -> {

            }
            case AUDIO -> {

            }
            case DOCUMENT -> {

            }
            case ARCHIVE -> {

            }
        
            default -> {
            }
        }
    }
    
}
