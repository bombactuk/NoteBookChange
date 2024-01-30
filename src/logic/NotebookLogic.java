package logic;

import entity.Note;

public interface NotebookLogic {

    void add(Note n) throws LogicException;

    void update(Note n) throws LogicException;

    void deleteNumberList(int numberInTheListDelete) throws LogicException;

    void deleteIdList(int idListDelete) throws LogicException;

    void clear() throws LogicException;

    void find(int idFind) throws LogicException;

    void find(String title) throws LogicException;

}
