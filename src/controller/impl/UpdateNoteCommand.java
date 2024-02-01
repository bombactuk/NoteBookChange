package controller.impl;

import controller.Command;
import entity.Note;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;
        Note newNote;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            params = request.split("\n");
            newNote = new Note();

            newNote.setId(Integer.parseInt(params[1].split("=")[1]));
            newNote.setTitle(params[2].split("=")[1]);
            newNote.setContent(params[3].split("=")[1]);
            newNote.setDate(formatter.parse(params[4].split("=")[1]));

            logic.update(newNote);

            response.append("Запись обновлена успешно.");

        } catch (LogicException | ParseException e) {
            response.append("Запись необновлена.");
        }

        return response;

    }

}