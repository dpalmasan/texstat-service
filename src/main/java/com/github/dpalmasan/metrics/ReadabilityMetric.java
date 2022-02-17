package com.github.dpalmasan.metrics;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class ReadabilityMetric {
    private String textId;
    private String name;
    private Double value;

    ReadabilityMetric(String textId, String name, Double value) {
        this.textId = textId;
        this.name = name;
        this.value = value;
    }

    public String getTextId() {
        return this.textId;
    }

    public String getName() {
        return this.name;
    }

    public Double getValue() {
        return this.value;
    }

    public void setTextId(String id) {
        this.textId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof ReadabilityMetric))
            return false;
        ReadabilityMetric other = (ReadabilityMetric) o;
        return Objects.equals(this.textId, other.textId) && Objects.equals(this.name, other.name)
                && Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.value, this.textId);
    }

    @Override
    public String toString() {
        return "ReadabilityMetric{" + ", name='" + this.name + '\'' + ", value='" + this.value + '\''
                + '}';
    }
}
