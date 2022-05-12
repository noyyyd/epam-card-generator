package com.epam.gitexercise.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum CardType {
    MIR_CLASSIC(
            Arrays.asList(new Range(2200, 2201)),
            Arrays.asList(new Range(16))),
    MIR_PREMIUM(
            Arrays.asList(new Range(2202, 2203)),
            Arrays.asList(new Range(16))),
    MIR_DEBIT(
            Arrays.asList(new Range(2204)),
            Arrays.asList(new Range(16))),
    VISA_CLASSIC(
            Arrays.asList(new Range(4165)),
            Arrays.asList(new Range(13), new Range(16))),
    VISA_GOLD(
            Arrays.asList(new Range(4321)),
            Arrays.asList(new Range(13), new Range(16))),
    VISA_ELECTRON(
            Arrays.asList(new Range(4026),
                    new Range(417_500),
                    new Range(4508),
                    new Range(4844),
                    new Range(4913),
                    new Range(4917)),
            Arrays.asList(new Range(16))),
    MASTERCARD_MASTERCARD(
            Arrays.asList(new Range(50, 55)),
            Arrays.asList(new Range(16))),
    MASTERCARD_MAESTRO(
            Arrays.asList(new Range(2221, 2720)),
            Arrays.asList(new Range(13, 19))),
    MASTERCARD_ELECTRONIC(
            Arrays.asList(new Range(5018),
                    new Range(5020),
                    new Range(5038),
                    new Range(5893),
                    new Range(6304),
                    new Range(6759, 6763)),
            Arrays.asList(new Range(16)));

    private final List<Range> iins;
    private final List<Range> lengthCardNumbers;

    CardType(List<Range> iins, List<Range> lengthCardNumber) {
        this.iins = iins;
        this.lengthCardNumbers = lengthCardNumber;
    }

    public List<Range> getIins() {
        return new ArrayList<>(iins);
    }

    public List<Range> getLengthCardNumbers() {
        return new ArrayList<>(lengthCardNumbers);
    }
}
