package controller.impl;

import controller.Command;

public class NoSuchCommand implements Command {

    @Override
    public String execute(String request) {
        return "The request failed.";
    }

}