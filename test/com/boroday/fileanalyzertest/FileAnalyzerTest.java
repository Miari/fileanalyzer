package com.boroday.fileanalyzertest;

import com.boroday.fileanalyzer.FileAnalyzer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileAnalyzerTest {

    private FileAnalyzer fileAnalyzer = new FileAnalyzer();
    private static List<String> sentencesForTest = new ArrayList<>();

    @BeforeClass
    public static void prepareTestData() {
        sentencesForTest.add("The best kinds");
        sentencesForTest.add(" of people are warm");
        sentencesForTest.add(" and kind, They are always there and");
        sentencesForTest.add(" and they never mind");
    }

    @Test
    public void testReadText() throws IOException {
        assertEquals("The best kinds of people\nare warm and kind,\nThey are always there\nand they never mind.\n", fileAnalyzer.readText("testResources/smalltext.txt"));
    }

    @Test
    public void testSplitSentences() {
        assertEquals(sentencesForTest.get(0), fileAnalyzer.splitSentences("The best kinds? of people are warm! and kind, They are always there and. and they never mind.").get(0));
        assertEquals(sentencesForTest.get(1), fileAnalyzer.splitSentences("The best kinds? of people are warm! and kind, They are always there and. and they never mind.").get(1));
        assertEquals(sentencesForTest.get(2), fileAnalyzer.splitSentences("The best kinds? of people are warm! and kind, They are always there and. and they never mind.").get(2));
        assertEquals(sentencesForTest.get(3), fileAnalyzer.splitSentences("The best kinds? of people are warm! and kind, They are always there and. and they never mind.").get(3));
    }

    @Test
    public void testFilterByWord() {
        assertEquals(2, fileAnalyzer.filterByWord(sentencesForTest, "are").size());
        assertEquals(" of people are warm", fileAnalyzer.filterByWord(sentencesForTest, "are").get(0));
        assertEquals(" and kind, They are always there and", fileAnalyzer.filterByWord(sentencesForTest, "are").get(1));
    }

    @Test
    public void testCountWordInSentences() {
        assertEquals(3, fileAnalyzer.countWordInSentences(sentencesForTest, "and"));
    }
}
