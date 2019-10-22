package com.boroday.fileanalyzer;

import java.io.*;
import java.util.*;

public class FileAnalyzer {

    public Set analyze(String pathToFile, String wordToSearch) throws IOException {
        String text = readText(pathToFile);
        List<String> sentences = splitSentences(text);
        List<String> sentencesWithWord = filterByWord(sentences, wordToSearch);
        printSentences(sentencesWithWord);
        int count = countWordInSentences(sentencesWithWord, wordToSearch);
        System.out.println("Word \"" + wordToSearch + "\" is present " + count + " time(s)");

        Set resultOfAnalysis = new HashSet(); //дженериков нет, так как мне нужно добавить данные с разным типом для теста FileAnalyserITest
        resultOfAnalysis.add(count);
        resultOfAnalysis.addAll(sentencesWithWord);
        return resultOfAnalysis;
    }

    public String readText(String pathToFile) throws IOException {
        StringBuilder text = new StringBuilder();
        String stringFromTheFile;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(pathToFile))) {
            while ((stringFromTheFile = fileReader.readLine()) != null) {
                text.append(stringFromTheFile);
                text.append("\n");
            }
        }
        return text.toString();
    }

    public List<String> splitSentences(String textToBeSplited) {
        String[] strings = textToBeSplited.split("[.!?]");
        return Arrays.asList(strings);
    }

    public List<String> filterByWord(List<String> sentences, String wordToSearch) {
        List<String> filteredSentences = new ArrayList<>();
        for (String sentence : sentences) {
            if (sentence.contains(wordToSearch)) {
                filteredSentences.add(sentence);
            }
        }
        return filteredSentences;
    }

    public int countWordInSentences(List<String> sentences, String wordToCount) {
        int count = 0;
        for (String sentence : sentences) {
            int index = sentence.indexOf(wordToCount);
            while (index != -1) {
                count++;
                index = sentence.indexOf(wordToCount, index + 1);
            }
        }
        return count;
    }

    private void printSentences(List<String> sentences) {
        for (String sentence : sentences) {
            System.out.println(sentence);
        }
    }
}

