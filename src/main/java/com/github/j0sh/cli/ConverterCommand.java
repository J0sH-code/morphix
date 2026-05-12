package com.github.j0sh.cli;

import java.nio.file.Path;
import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "morphinx", 
        mixinStandardHelpOptions = true,
        optionListHeading = "%nOptions are:%n",
        commandListHeading = "%nSubCommands are:%n", 
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
    Path inputFilePath;

    @Option(names = {"-out, --output"}, description = "Used select output type", required = true)
    String outputType;

    @Option(names = {"-n", "--name"}, description = "Used to name converted file")
    String fileName;

    @Option(names = {"-op", "--outputPath"}, description = "Used to specify location of converted file")
    Path outPutFilePath;
    
    @Override
    public Integer call() throws Exception {
        System.out.println("[INPUT] input path: " + inputFilePath);
        System.out.println("[INPUT] type: " + outputType);
        System.out.println("[INPUT] name: " + fileName);
        System.out.println("[INPUT] output path: " + outPutFilePath);
        return 0;
    }
    
}
