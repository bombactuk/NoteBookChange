package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class FindNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;

        params = request.split("\n");
        params = params[1].split("=");

        switch (params[0]) {

            case "id", "title" -> {

                try {
                    logic.find(params[0], params[1]);

                    response.append("Found strings are printed.");

                } catch (LogicException e) {
                    response.append("Сouldn't find.");
                }

            }

            default -> response.append("Field not found.");

        }

        return response;

    }

}
