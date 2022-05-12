package com.epam.gitexercise.controller;

import com.epam.gitexercise.model.CardGenerator;
import com.epam.gitexercise.model.CardType;
import com.epam.gitexercise.view.ConsoleView;
import org.apache.log4j.Logger;

public class Controller {
    private static final Logger LOGGER = Logger.getLogger(Controller.class);
    private static final String ERROR_MESSAGE = "Unknown card type";
    private final CardGenerator cardGenerator;
    private final ConsoleView view;

    public Controller() {
        cardGenerator = new CardGenerator();
        view = new ConsoleView();
    }

    public void start(String[] inputCardTypes) {
        for (String inputCardType : inputCardTypes) {
            try {
                CardType cardType = convertToCardType(inputCardType);

                view.printCardNumber(
                        cardGenerator.generateCardNumber(cardType));
            } catch (IllegalArgumentException e) {
                view.printError(ERROR_MESSAGE);
                LOGGER.error(ERROR_MESSAGE, e);
            }
        }
    }

    private CardType convertToCardType(String cardType) {
        return CardType.valueOf(cardType.toUpperCase());
    }
}
