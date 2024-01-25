package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class SortNotesCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();

    @Override
    public String execute(String request) {

        String response = null;
        String[] params;

        params = request.split("\n");

        switch (params[1]) {

            case "title": {

                try {
                    logic.sortNotesTitle();
                    response = "Записи отсортированы по Title.";

                } catch (LogicException e) {
                    response = "Записи не отсортированы";
                }
                break;

            }

            case "content": {

                try {
                    logic.sortNotesContent();
                    response = "Записи отсортированы по Content.";

                } catch (LogicException e) {
                    response = "Записи не отсортированы";
                }
                break;

            }
            default: {
                response = "Сортировка по полю не найдено";
                break;
            }

        }

        return response;

    }

}
