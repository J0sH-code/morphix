package com.github.j0sh.converter;

import java.nio.file.Path;

import ws.schild.jave.Encoder;
import com.github.j0sh.util.FileUtils;

public class MediaConverter implements Converter{

    @Override
    public void convert(Path filePath, String outputType, String outputName, Path outputPath) {
        Encoder encoder = new Encoder();
    }

    private void audioHandler(Path filePath){
        if (FileUtils.isAudio(filePath)) {
            
        }
    }

    private void videoHandler(Path filePath){
        if (FileUtils.isVideo(filePath)) {
            
        }
    }

}
