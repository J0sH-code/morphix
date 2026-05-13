package com.github.j0sh;

import com.github.j0sh.cli.ConverterCommand;
import com.github.j0sh.ui.BannerPrinter;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        BannerPrinter.print();
        new CommandLine(new ConverterCommand()).execute(
        args);
    }
}


