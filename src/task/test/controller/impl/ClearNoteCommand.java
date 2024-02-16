package task.test.controller.impl;

import task.test.controller.Command;
import task.test.logic.LogicException;
import task.test.logic.LogicProvider;
import task.test.logic.NotebookLogic;

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
