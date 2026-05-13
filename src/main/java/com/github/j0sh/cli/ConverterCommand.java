package com.github.j0sh.cli;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import com.github.j0sh.dispatcher.ConverterDispatcher;
import com.github.j0sh.util.FileType;
import com.github.j0sh.util.FileUtils;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "morphinx", 
        mixinStandardHelpOptions = true,
        optionListHeading = "%nOptions are:%n",
        commandListHeading = "%nSubCommands are:%n",
        subcommandsRepeatable = true, 
        subcommands = {
            inputCommand.class
        })
public class ConverterCommand implements Callable<Integer>{
    final Integer SUCCESS = 0;
    final Integer FAILURE = 1;

    @Override
    public Integer call() throws Exception {
        return SUCCESS;
    }
}

@Command(name = "input",
        aliases = {"convert"},
        mixinStandardHelpOptions = true, 
        description = "Used to input the file that will be converted",
        requiredOptionMarker = '*')
class inputCommand implements Callable<Integer> {

    @Option(names = {"-p", "--path"}, description = "Used to input item path to convert", required = true)
    String inputFileString;
    
    @Option(names = {"-out", "--output"}, description = "Used select output type", required = true)
    String outputType;

    @Option(names = {"-n", "--name"}, description = "Used to name converted file")
    String fileName;

    @Option(names = {"-op", "--outputPath"}, description = "Used to specify location of converted file")
    Path outPutFilePath;

    
    @Override
    public Integer call() throws Exception {
        Path inputFilePath = Path.of(inputFileString);
        FileType inputType = checkFileType(inputFilePath);
        System.out.println("[INPUT] input path string: " + inputFilePath);
        System.out.println("[INPUT] detected file type: " + inputType);
        System.out.println("[INPUT] desired output type: " + outputType);
        System.out.println("[INPUT] name: " + fileName);
        System.out.println("[INPUT] output path: " + outPutFilePath);

        ConverterDispatcher.execute(inputFilePath.normalize(), outputType, fileName, outPutFilePath);
        return 0;
    }
    
    private FileType checkFileType(Path filePath) {
        return FileUtils.getFileType(filePath);
    }
}
