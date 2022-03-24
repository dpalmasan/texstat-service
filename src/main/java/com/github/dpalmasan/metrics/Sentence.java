package com.github.dpalmasan.metrics;

import javax.persistence.Entity;

@Entity
public class Sentence {
    private String tree;
    private String sentiment;

    public Sentence(String tree, String sentiment) {
        this.tree = tree;
        this.sentiment = sentiment;
    }

    public String getSentiment() {
        return this.sentiment;
    }

    public String getTree() {
        return this.tree;
    }
}
