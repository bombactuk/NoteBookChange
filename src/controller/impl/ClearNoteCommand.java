package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class ClearNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {

        String response = null;

        try {
            logic.clear();

            response = "Список очищен";

        } catch (LogicException e) {
            response = "Список не очищен";
        }

        return response;
    }

}
