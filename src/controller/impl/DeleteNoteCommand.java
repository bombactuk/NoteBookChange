package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class DeleteNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();


    @Override
    public String execute(String request) {

        String response = null;
        String[] params;

        params = request.split("\n");
        params = params[1].split("=");

        switch (params[0]) {

            case "number": {

                try {

                    logic.deleteNumberList(Integer.parseInt(params[1]) - 1);

                    response = "Запись удалена успешно.";

                } catch (LogicException | NumberFormatException e) {
                    response = "Запись не удалена.";
                }

                break;

            }

            case "id": {
                try {

                    logic.deleteIdList(Integer.parseInt(params[1]));

                    response = "Запись удалена успешно.";

                } catch (LogicException | NumberFormatException e) {
                    response = "Запись не удалена.";
                }

                break;
            }

            default: {
                response = "Удаление по полю не найдено";
            }

        }

        return response;

    }

}
