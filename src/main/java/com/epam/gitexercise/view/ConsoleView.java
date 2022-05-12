package com.epam.gitexercise.view;

public class ConsoleView {
    private static final String CARD_NUMBER = "Card number: %s%n";

    public void printCardNumber(Iterable<Integer> cardNumber) {
        StringBuilder handledCardNumber = new StringBuilder();

        for (Integer number : cardNumber) {
            handledCardNumber.append(number);
        }

        System.out.printf(CARD_NUMBER, handledCardNumber);
    }

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
