package com.github.dpalmasan.metrics;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class TextStatResponse {
    private List<ReadabilityMetric> metrics;
    private List<Sentence> sentences;

    TextStatResponse(List<ReadabilityMetric> metrics, List<Sentence> sentences) {
        this.metrics = metrics;
        this.sentences = sentences;
    }

    public List<ReadabilityMetric> getMetrics() {
        return this.metrics;
    }

    public List<Sentence> getSentences() {
        return this.sentences;
    }
}
