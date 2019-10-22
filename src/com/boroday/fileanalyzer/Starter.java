package com.boroday.fileanalyzer;

import java.io.File;
import java.io.IOException;

public class Starter {
    public static void main(String[] args) throws IOException {

        if (args.length < 2) {
            System.out.println("Usage java ClassFile <pathToFile> <searchedWord>");
            return;
        }

        String pathToFile = args[0];
        String wordToSearch = args[1];

        File pathToTheFile = new File(pathToFile);
        if (!pathToTheFile.exists() || pathToTheFile.isDirectory()) {
            System.out.println("'" + pathToFile + "' file does not exist or is a directory");
            return;
        }

        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        fileAnalyzer.analyze(pathToFile, wordToSearch);
    }
}
