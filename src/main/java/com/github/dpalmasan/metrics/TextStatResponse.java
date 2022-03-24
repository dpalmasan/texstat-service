package com.github.dpalmasan.metrics;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class TextStatResponse {
    private List<ReadabilityMetric> metrics;
    private List<String> words;
    private List<String> labels;
    private List<Sentence> sentences;

    TextStatResponse(List<ReadabilityMetric> metrics, List<String> words, List<String> labels,
            List<Sentence> sentences) {
        this.metrics = metrics;
        this.words = words;
        this.labels = labels;
        this.sentences = sentences;
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

    public List<Sentence> getSentences() {
        return this.sentences;
    }
}
