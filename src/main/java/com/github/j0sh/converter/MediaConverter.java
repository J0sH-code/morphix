package com.github.j0sh.converter;

import java.io.File;
import java.nio.file.Path;

import ws.schild.jave.Encoder;
import com.github.j0sh.util.FileUtils;

public class MediaConverter implements Converter{
    Encoder encoder = new Encoder();
    @Override
    public void convert(Path filePath, String outputType, String outputName, Path outputPath) {
        audioHandler(filePath);
        videoHandler(filePath);
    }

    private void audioHandler(Path filePath){
        if (FileUtils.isAudio(filePath)) {
            File sourceFile = filePath.toFile();
        }
    }

    private void videoHandler(Path filePath){
        if (FileUtils.isVideo(filePath)) {
            
        }
    }

}
