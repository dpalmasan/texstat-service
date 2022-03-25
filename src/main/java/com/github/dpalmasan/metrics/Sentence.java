package com.github.dpalmasan.metrics;

import javax.persistence.Entity;

@Entity
public class Sentence {
    private ParseTree tree;
    private String sentiment;

    public Sentence(ParseTree tree, String sentiment) {
        this.tree = tree;
        this.sentiment = sentiment;
    }

    public String getSentiment() {
        return this.sentiment;
    }

    public ParseTree getTree() {
        return this.tree;
    }
}
