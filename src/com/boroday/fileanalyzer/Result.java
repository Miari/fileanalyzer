package com.boroday.fileanalyzer;

import java.util.List;

public class Result {
    private int count;
    private List<String> sentences;

    Result(int count, List<String> sentences) {
        this.count = count;
        this.sentences = sentences;
    }

    public int getCount() {
        return count;
    }

    public List<String> getSentences() {
        return sentences;
    }
}
