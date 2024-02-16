package task.test.controller;

import task.test.controller.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        repository.put(CommandName.ADD, new AddNoteCommand());
        repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        repository.put(CommandName.DELETE, new DeleteNoteCommand());
        repository.put(CommandName.CLEAR, new ClearNoteCommand());
        repository.put(CommandName.UPDATE, new UpdateNoteCommand());
        repository.put(CommandName.FIND, new FindNoteCommand());
        repository.put(CommandName.SORT, new SortNoteCommand());

    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {

            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);

        } catch (IllegalArgumentException | NullPointerException e) {

            command = repository.get(CommandName.WRONG_REQUEST);

        }

        return command;

    }

}
