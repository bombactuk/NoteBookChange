package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class FindNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {

        String response = null;
        String[] params;

        params = request.split("\n");
        params = params[1].split("=");

        switch (params[0]) {

            case "title": {

                try {

                    logic.find(params[1]);

                    response = "Found strings are printed.";

                } catch (LogicException | NumberFormatException e) {
                    response = "Found lines are not displayed.";
                }

                break;

            }

            case "id": {
                try {

                    logic.find(Integer.parseInt(params[1]));

                    response = "Found strings are printed.";

                } catch (LogicException | NumberFormatException e) {
                    response = "Found lines are not displayed.";
                }

                break;
            }

            default: {
                response = "Field not found.";
            }

        }

        return response;

    }

}
