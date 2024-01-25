package logic;

import entity.Note;

public interface NotebookLogic {

    void add(Note n) throws LogicException;

    void deleteNumberList(int numberInTheListDelete) throws LogicException;

    void deleteIdList(int idListDelete) throws LogicException;

    void clear() throws LogicException;

    void sortNotesTitle() throws LogicException;

    void sortNotesContent() throws LogicException;

}
