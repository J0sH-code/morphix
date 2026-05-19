package com.github.j0sh.converter;

import java.io.File;
import java.nio.file.Path;

import com.github.j0sh.util.FileUtils;

import ws.schild.jave.Encoder;

public class MediaConverter implements Converter{
    Encoder encoder = new Encoder();
    @Override
    public void convert(Path filePath, String outputType, String outputName, Path outputPath) {

        audioHandler(filePath, outputType, outputName, outputPath);
        videoHandler(filePath, outputType, outputName, outputPath);
    }

    private void audioHandler(Path filePath, String outputType, String outputName, Path outputPath){
        if (!FileUtils.isAudio(filePath)) {
            return;
        }
        File target = filePath.getParent().resolve(outputName + "." + outputType).toFile();
        File source = filePath.toFile();
    }

    private void videoHandler(Path filePath, String outputType, String outputName, Path outputPath){
        if (!FileUtils.isVideo(filePath)) {
            return;
        }
        File target = filePath.getParent().resolve(outputName + "." + outputType).toFile();
        File source = filePath.toFile();
    }

}
