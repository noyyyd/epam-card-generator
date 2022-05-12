package com.epam.gitexercise.model;

public class Range {
    private final int upperLimit;
    private final int lowerLimit;

    public Range(int lowerLimit, int upperLimit) {
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }

    public Range(int limit) {
        this.upperLimit = limit;
        this.lowerLimit = limit;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }
}
