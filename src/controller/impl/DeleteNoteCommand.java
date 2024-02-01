package controller.impl;

import controller.Command;
import logic.LogicException;
import logic.LogicProvider;
import logic.NotebookLogic;

public class DeleteNoteCommand implements Command {

    private final LogicProvider logicProvider = LogicProvider.getInstance();
    private final NotebookLogic logic = logicProvider.getNotebookLogic();


    @Override
    public StringBuilder execute(String request) {

        StringBuilder response = new StringBuilder();
        String[] params;

        params = request.split("\n");
        params = params[1].split("=");

        switch (params[0]) {

            case "number" -> {
                try {

                    logic.deleteNumberList(Integer.parseInt(params[1]) - 1);

                    response.append("The entry was deleted successfully.");

                } catch (LogicException | NumberFormatException e) {
                    response.append("The entry has not been deleted.");
                }
            }

            case "id" -> {
                try {

                    logic.deleteIdList(Integer.parseInt(params[1]));

                    response.append("The entry was deleted successfully.");

                } catch (LogicException | NumberFormatException e) {
                    response.append("The entry has not been deleted.");
                }
            }

            default -> response.append("Field deletion not found.");

        }

        return response;

    }

}
