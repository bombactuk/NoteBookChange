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
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        Note newNote;

        try {

            params = request.split("\n");
            newNote = new Note();

            newNote.setTitle(params[1].split("=")[1]);
            newNote.setContent(params[2].split("=")[1]);

            logic.add(newNote);

            response.append("Recording continues successfully.");

        } catch (LogicException e) {
            response.append("Entry not saved.");
        }

        return response;

    }

}
