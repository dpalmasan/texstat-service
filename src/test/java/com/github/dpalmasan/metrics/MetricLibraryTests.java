package com.github.dpalmasan.metrics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.apache.commons.io.IOUtils;

public class MetricLibraryTests {
    @Test
    void testTokenize() {
        String text = "This is,a bad. Sentence";
        List<String> expected = Arrays.asList(new String[] { "this", "is", "a", "bad", "sentence" });
        assertTrue(MetricLibrary.tokenize(text).equals(expected));
    }

    @Test
    void testTypeTokenRatio() {
        List<String> tokens = Arrays.asList(new String[] { "hello", "world", "world", "hello" });
        assertTrue(Math.abs(MetricLibrary.typeTokenRatio(tokens) - 0.5) < 0.0001);
    }

    @Test
    public void testDEstimate() throws Exception {
        String text = IOUtils.toString(
                this.getClass().getResourceAsStream("text-test.txt"),
                "UTF-8");

        // Validated with online tool
        // https://www.lognostics.co.uk/tools/D_Tools/D_Tools.cgi
        double expected = 26.0;
        double result = MetricLibrary.diversityEstimate(text, 35, 50, 5);
        assertTrue(Math.abs(expected - result) < 2);
    }
}
