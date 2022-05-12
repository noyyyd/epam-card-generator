package com.epam.gitexercise;

import com.epam.gitexercise.controller.Controller;

public class Runner {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start(args);
    }
}
