package logic;

import entity.Note;

import java.util.ArrayList;

public interface NotebookLogic {

    void add(Note n) throws LogicException;

    void update(Note n) throws LogicException;

    void deleteNumberList(int numberInTheListDelete) throws LogicException;

    void deleteIdList(int idListDelete) throws LogicException;

    void clear() throws LogicException;

    void find(int idFind);

    void find(String title);

}
