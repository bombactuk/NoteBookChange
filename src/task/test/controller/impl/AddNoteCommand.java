package task.test.controller.impl;

import task.test.controller.Command;
import task.test.entity.Note;
import task.test.logic.LogicException;
import task.test.logic.LogicProvider;
import task.test.logic.NotebookLogic;

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
