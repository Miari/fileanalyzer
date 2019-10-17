package com.boroday.fileanalyzer;

import java.io.*;
import java.util.ArrayList;

public class FileAnalyzer {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Two arguments should be defined");
        } else {
            File pathToTheFile = new File(args[0]);
            if (!pathToTheFile.exists() || pathToTheFile.isDirectory()) {
                System.out.println("'" + args[0] + "' file does not exist or is a directory");
            } else {
                System.out.println(countNumberOfSubstring(args[0], args[1]));
                ArrayList<String> selectedStrings = getListOfSelectedStrings(args[0], args[1]);
                for (String selectedString : selectedStrings) {
                    System.out.println(selectedString);
                }
            }
        }
    }

    private static ArrayList<String> getListOfSelectedStrings(String pathToFile, String word) throws IOException {
        ArrayList<String> listOfSelectedStrings = new ArrayList<>();
        String stringFromTheFile;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))) {
            while ((stringFromTheFile = fileReader.readLine()) != null) {
                if (stringFromTheFile.contains(word) && (stringFromTheFile.endsWith(".") || (stringFromTheFile.endsWith("!") || (stringFromTheFile.endsWith("?"))))) {
                    listOfSelectedStrings.add(stringFromTheFile);
                }
            }
            return listOfSelectedStrings;
        }
    }

    private static int countNumberOfSubstring(String pathToFile, String word) throws IOException {
        int count = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))) {
            String stringFromTheFile;
            while ((stringFromTheFile = fileReader.readLine()) != null) {
                int index = stringFromTheFile.indexOf(word);
                while (index != -1) {
                    count++;
                    index = stringFromTheFile.indexOf(word, index + 1);
                }
            }
            return count;
        }
    }
}

