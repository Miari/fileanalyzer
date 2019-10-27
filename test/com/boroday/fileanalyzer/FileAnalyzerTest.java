package com.boroday.fileanalyzer;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FileAnalyzerTest {

    private FileAnalyzer fileAnalyzer = new FileAnalyzer();
    private static final List<String> EXPECTED_LINES = new ArrayList<>(4);

    @BeforeClass
    public static void prepareTestData() {
        EXPECTED_LINES.add("The best kinds?");
        EXPECTED_LINES.add(" of people are warm!");
        EXPECTED_LINES.add(" and kind, They are always there and.");
        EXPECTED_LINES.add(" and they never mind.");
    }

    @Test
    public void testReadText() throws IOException {
        assertEquals("The best kinds of people are warm and kind,They are always there and they never mind.", fileAnalyzer.readText("testResources/smalltext.txt"));
    }

    @Test
    public void testSplitSentences() {
        List<String> sentences = fileAnalyzer.splitSentences("The best kinds? of people are warm! and kind, They are always there and. and they never mind.");
        assertEquals(EXPECTED_LINES.get(0), sentences.get(0));
        assertEquals(EXPECTED_LINES.get(1), sentences.get(1));
        assertEquals(EXPECTED_LINES.get(2), sentences.get(2));
        assertEquals(EXPECTED_LINES.get(3), sentences.get(3));
    }

    @Test
    public void testFilterByWord() {
        assertEquals(2, fileAnalyzer.filterByWord(EXPECTED_LINES, "are").size());
        assertEquals(" of people are warm!", fileAnalyzer.filterByWord(EXPECTED_LINES, "are").get(0));
        assertEquals(" and kind, They are always there and.", fileAnalyzer.filterByWord(EXPECTED_LINES, "are").get(1));
    }

    @Test
    public void testCountWordInSentences() {
        assertEquals(3, fileAnalyzer.countWordInSentences(EXPECTED_LINES, "and"));
    }
}
