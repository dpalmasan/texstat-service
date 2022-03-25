package com.github.dpalmasan.metrics;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class ParseTree {
    private String name;
    private List<ParseTree> children;

    public ParseTree(String name, List<ParseTree> children) {
        this.name = name;
        this.children = children;
    }

    public ParseTree(String name) {
        this.name = name;
        this.children = null;
    }

    public String getName() {
        return this.name;
    }

    public List<ParseTree> getChildren() {
        return this.children;
    }

    protected void addChildren(ParseTree t) {
        if (this.children == null) {
            this.children = new ArrayList<>();

        }
        this.children.add(t);
    }
}
