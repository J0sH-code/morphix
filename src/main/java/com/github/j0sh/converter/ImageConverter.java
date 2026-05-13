package com.github.j0sh.converter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.apache.commons.math3.exception.NullArgumentException;

public class ImageConverter implements Converter{

    @Override
    public void convert(Path filePath, String outputType, String outputName, Path outputPath) {
        try {

            File fileInput = filePath.toFile();
            var imageData = ImageIO.read(fileInput);

            if (imageData == null) {
                System.out.println("Failed to read image data from file: " + fileInput);
                return;
            }

            File outputData = filePath.getParent().resolve(outputName + "." + outputType).toFile();

            System.out.println();
            System.out.println("---Image converter debugger---");
            System.out.println("File input: " + fileInput);
            System.out.println("Input image data: " + imageData);
            System.out.println("OutputData: " + outputData);
            System.out.println("Output type: " + outputType);

            // Check if the output format is supported
            String[] supportedFormats = ImageIO.getWriterFormatNames();
            boolean formatSupported = false;
            for (String format : supportedFormats) {
                if (format.equalsIgnoreCase(outputType)) {
                    formatSupported = true;
                    break;
                }
            }

            if (!formatSupported) {
                System.out.println("Unsupported output format: " + outputType);
                System.out.println("Supported formats: " + String.join(", ", supportedFormats));
                return;
            }

            boolean result = ImageIO.write(imageData, outputType, outputData);

            if (result) {
                System.out.println("Image saved successfully!");
            } else {
                System.out.println("Failed to write image - no appropriate writer found for the format.");
            }
        } catch (IOException e) {
            System.out.println("File does not exist");
        } catch (NullArgumentException e) {
            System.out.println("Input cannot be read, may be null or corrupted");
        }
    }

    private Path getOutputPath(Path inputPath) {
        String inputString = inputPath.toString();
        int lastSlashPoint = inputString.lastIndexOf("\\");
        Path outputPath = Path.of(inputString.replace(inputString.substring(lastSlashPoint),""));

        return outputPath;
    }

}
