package com.github.j0sh.ui;

public class BannerPrinter {
 
    private static final String RESET  = "\u001B[0m";
    private static final String PURPLE = "\u001B[38;2;167;139;250m";
    private static final String VIOLET = "\u001B[38;2;124;58;237m";
    private static final String GRAY   = "\u001B[38;2;107;114;128m";
    private static final String LIGHT  = "\u001B[38;2;209;213;219m";
    private static final String GREEN  = "\u001B[38;2;52;211;153m";
 
    private static final String[] ASCII_ART = {
        " ███╗   ███╗ ██████╗ ██████╗ ██████╗ ██╗  ██╗██╗██╗  ██╗",
        " ████╗ ████║██╔═══██╗██╔══██╗██╔══██╗██║  ██║██║╚██╗██╔╝",
        " ██╔████╔██║██║   ██║██████╔╝██████╔╝███████║██║ ╚███╔╝ ",
        " ██║╚██╔╝██║██║   ██║██╔══██╗██╔═══╝ ██╔══██║██║ ██╔██╗ ",
        " ██║ ╚═╝ ██║╚██████╔╝██║  ██║██║     ██║  ██║██║██╔╝ ██╗",
        " ╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝╚═╝  ╚═╝"
    };
 
    public static void print() {
        System.out.println();
 
        for (String line : ASCII_ART) {
            System.out.println(PURPLE + line + RESET);
        }
 
        System.out.println();
        System.out.println(GRAY + "  A modular CLI file converter  ·  " + VIOLET + "v0.1.0-dev" + RESET);
        System.out.println(GRAY + "  ─────────────────────────────────────────────────────────" + RESET);
        System.out.println(GRAY + "  author  " + LIGHT + "Josh Ryle R. Santeno" + RESET);
        System.out.println(GRAY + "  runtime " + PURPLE + "Java + Maven" + RESET);
        System.out.println(GRAY + "  status  " + GREEN + "● scaffolding" + RESET);
        System.out.println();
    }
}
