package com.github.dpalmasan.metrics;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class TextStatResponse {
    private List<ReadabilityMetric> metrics;
    private List<String> words;
    private List<String> labels;
    private List<String> sentenceTrees;
    private List<String> sentenceSentiments;

    TextStatResponse(List<ReadabilityMetric> metrics, List<String> words, List<String> labels,
            List<String> sentenceTrees, List<String> sentenceSentiments) {
        this.metrics = metrics;
        this.words = words;
        this.labels = labels;
        this.sentenceTrees = sentenceTrees;
        this.sentenceSentiments = sentenceSentiments;
    }

    public List<ReadabilityMetric> getMetrics() {
        return this.metrics;
    }

    public List<String> getWords() {
        return this.words;
    }

    public List<String> getLabels() {
        return this.labels;
    }

    public List<String> getSentenceTrees() {
        return this.sentenceTrees;
    }

    public List<String> getSentenceSentiments() {
        return this.sentenceSentiments;
    }
}
