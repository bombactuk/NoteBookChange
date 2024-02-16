package task.test.controller.impl;

import task.test.controller.Command;
import task.test.logic.LogicException;
import task.test.logic.LogicProvider;
import task.test.logic.NotebookLogic;

public class SortNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;

        params = request.split("\n");
        params = params[1].split("=");

        switch (params[0]) {

            case "id", "title", "content", "date" -> {

                try {

                    logic.sortList(params[0]);

                    response.append("Sorting was successful.");

                } catch (LogicException | NumberFormatException e) {
                    response.append("\n" + "Sorting was not successful.");
                }

            }

            default -> response.append("\n" + "Sort by field not found.");

        }

        return response;

    }

}
