package controller;

public class Controller {
    private final char paramDelimeter = '\n';

    private final CommandProvider provider = new CommandProvider();

    public String doAction(String request) {


        String commandName;
        Command executionCommand;
        String response;

        try {
            commandName = request.substring(0, request.indexOf(paramDelimeter));
            executionCommand = provider.getCommand(commandName.toUpperCase());

            response = executionCommand.execute(request);
        } catch (Exception e) {
            response = "Technical problems.";
        }

        return response;

    }

}
