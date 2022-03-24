package com.github.dpalmasan.metrics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.math3.stat.regression.SimpleRegression;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;

public class MetricLibrary {
    public static int charCount(String text) {
        return text.length();
    }

    public static double diversityEstimate(String text, int minRange, int maxRange, int trials) {
        int n = maxRange - minRange + 1;
        double data[][] = new double[n][2];

        int currN;
        List<String> tokens = tokenize(text);
        for (int t = 0; t < trials; ++t) {
            currN = minRange;
            for (int i = 0; i < n; ++i) {
                List<String> sampledTokens = sampleTokens(tokens, currN);
                double ttr = typeTokenRatio(sampledTokens);
                data[i][0] += ttr;

                if (t == trials - 1) {
                    data[i][0] /= trials;
                }
                currN++;
            }
        }

        currN = minRange;
        for (int i = 0; i < n; ++i) {
            double ttr = data[i][0];
            data[i][0] = 2 * (1 - ttr);
            data[i][1] = ttr * ttr * currN;
            currN++;
        }

        SimpleRegression simpleRegression = new SimpleRegression(false);
        simpleRegression.addData(data);

        return simpleRegression.getSlope();
    }

    protected static List<String> sampleTokens(List<String> tokens, int n) {
        Collections.shuffle(tokens);

        // adding defined amount of numbers to target list
        List<String> targetList = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            targetList.add(tokens.get(j));
        }

        return targetList;
    }

    protected static List<String> tokenize(String text) {
        return Arrays.asList(text.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+"));
    }

    public static double typeTokenRatio(List<String> tokens) {
        HashSet<String> uniqueTokens = new HashSet<String>(tokens);
        return (double) uniqueTokens.size() / tokens.size();
    }

    public static double averageConcreteness(CoreDocument document, HashMap<String, Double> lexicon) {
        double avgConcreteness = 0;
        int wordCount = 0;
        for (CoreLabel token : document.tokens()) {
            double concreteness = lexicon.getOrDefault(token.lemma(), -1.0);
            if (concreteness > -1) {
                avgConcreteness += concreteness;
                wordCount++;
            }
        }
        return avgConcreteness / wordCount;
    }

    public static double pronounNounRatio(CoreDocument document) {
        double nounCount = 0;
        double pronounCount = 0;
        for (CoreLabel token : document.tokens()) {
            if (token.tag().startsWith("PRP") || token.tag().startsWith("WP")) {
                pronounCount++;

            } else if (token.tag().startsWith("NN")) {
                nounCount++;
            }
        }
        return pronounCount / nounCount;
    }
}
