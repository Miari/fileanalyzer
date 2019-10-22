package com.boroday.fileanalyzertest;

import com.boroday.fileanalyzer.FileAnalyzer;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class FileAnalyzerITest {
    FileAnalyzer fileAnalyzer = new FileAnalyzer();

    @Test
    public void testAnalyze() throws IOException {
        Set resultOfAnalysis = fileAnalyzer.analyze("testResources/text.txt", "star");
        assertTrue(resultOfAnalysis.remove(5));
        assertTrue(resultOfAnalysis.remove("Every person had a star, every star had a friend, and for every person carrying a star there was someone else who reflected it"));
        assertTrue(resultOfAnalysis.remove("\nJust where that star above\nShines with a cold, dispassionate smile"));
        assertTrue(resultOfAnalysis.remove("\nTime could not count its markless flight\nBeyond that star, beyond"));
        assertTrue(resultOfAnalysis.isEmpty());
    }
}
