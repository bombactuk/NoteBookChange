package task.test.controller.impl;

import task.test.controller.Command;

public class NoSuchCommand implements Command {

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();

        return response.append("The request failed.");

    }

}