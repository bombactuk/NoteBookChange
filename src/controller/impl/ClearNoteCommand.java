package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class ClearNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();

        try {
            logic.clear();

            response.append("List cleared.");

        } catch (LogicException e) {
            response.append("The list has not been cleared.");
        }

        return response;
    }

}
