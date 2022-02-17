package com.github.dpalmasan.texts;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class TextEntity {
    private String id;
    private String text;

    TextEntity() {

    }

    public String getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.text);
    }

    @Override
    public String toString() {
        return "ReadabilityMetric{" + "id=" + this.id + ", text='" + this.text + '\''
                + '}';
    }
}
