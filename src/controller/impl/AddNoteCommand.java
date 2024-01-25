package controller.impl;

import controller.Command;
import entity.Note;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class AddNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {

        String response = null;
        String[] params;
        Note newNote;

        try {

            params = request.split("\n");
            newNote = new Note();

            newNote.setTitle(params[1].split("=")[1]);
            newNote.setContent(params[2].split("=")[1]);

            logic.add(newNote);

            response = "Запись сохранена успешно.";

        } catch (LogicException e) {
            response = "Запись не сохранена.";
        }

        return response;

    }

}
