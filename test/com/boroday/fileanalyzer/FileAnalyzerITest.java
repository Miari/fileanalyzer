package com.boroday.fileanalyzer;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileAnalyzerITest {
    private FileAnalyzer fileAnalyzer = new FileAnalyzer();

    @Test
    public void testAnalyze() throws IOException {
        Result result = fileAnalyzer.analyze("testResources/text.txt", "star");
        assertEquals(5, result.getCount());
        assertEquals("Every person had a star, every star had a friend, and for every person carrying a star there was someone else who reflected it.", result.getSentences().get(0));
        assertEquals("Just where that star aboveShines with a cold, dispassionate smile.", result.getSentences().get(1));
        assertEquals("Time could not count its markless flightBeyond that star, beyond!", result.getSentences().get(2));
    }
}
