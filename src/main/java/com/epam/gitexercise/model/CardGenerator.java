package com.epam.gitexercise.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardGenerator {
    private static final int ALGORITHM_THRESHOLD = 9;
    private static final int NUMBER_FOR_PARITY = 2;
    private static final int SPACE_FOR_LUNH_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 10;
    private static final int NUMBER_FOR_SELECTION = 10;
    private static final int DECREASE = 10;
    private static final int NUMBER_TO_GET_LUNH_NUMBER = 10;
    private final SecureRandom secureRandom = new SecureRandom();

    public List<Integer> generateCardNumber(CardType cardType) {
        List<Integer> cardNumber = new ArrayList<>();

        int lengthCardNumber = generateLengthCardNumber(
                cardType.getLengthCardNumbers());

        cardNumber.addAll(generateIIN(cardType.getIins()));
        cardNumber.addAll(generateAccountID(cardNumber.size(),
                lengthCardNumber));
        cardNumber.add(calculateLuhnNumber(cardNumber));

        return cardNumber;
    }

    private List<Integer> generateAccountID(int lengthCardNumber,
                                           int fullLengthCardNumber) {
        List<Integer> accountID = new ArrayList<>();
        int lengthAccountID = fullLengthCardNumber - lengthCardNumber
                - SPACE_FOR_LUNH_NUMBER;

        for (int i = 0; i < lengthAccountID; i++) {
            int randomNumber = secureRandom.nextInt(MAX_RANDOM_NUMBER);

            accountID.add(randomNumber);
        }

        return accountID;
    }

    private List<Integer> generateIIN(List<Range> iins) {
        Range range = iins.get(secureRandom.nextInt(iins.size()));

        return splitIin(generateRandomNumberInRange(range));
    }

    private List<Integer> splitIin(int iin) {
        LinkedList<Integer> handledIin = new LinkedList<>();

        while (iin > 1) {
            handledIin.addFirst(iin % NUMBER_FOR_SELECTION);
            iin /= DECREASE;
        }

        return handledIin;
    }

    private int generateLengthCardNumber(List<Range> lengthCardNumbers) {
        Range range = lengthCardNumbers.get(
                secureRandom.nextInt(lengthCardNumbers.size()));

        return generateRandomNumberInRange(range);
    }

    private int generateRandomNumberInRange(Range range) {
        return secureRandom
                .nextInt(range.getUpperLimit() - range.getLowerLimit() + 1)
                + range.getLowerLimit();
    }

    private int calculateLuhnNumber(List<Integer> cardNumber) {
        int sumOfElements = 0;

        for (int i = 0; i < cardNumber.size(); i++) {
            int element = cardNumber.get(i);

            if (i % NUMBER_FOR_PARITY == 0) {
                element += element;

                if (element > ALGORITHM_THRESHOLD) {
                    element = element - ALGORITHM_THRESHOLD;
                }
            }

            sumOfElements += element;
        }

        int luhnNumber = sumOfElements % NUMBER_FOR_SELECTION;

        if (luhnNumber != 0) {
            luhnNumber = NUMBER_TO_GET_LUNH_NUMBER - luhnNumber;
        }

        return luhnNumber;
    }
}
