package task.test.logic;

import task.test.entity.Note;

public interface NotebookLogic {

    void add(Note n) throws LogicException;

    void update(Note n) throws LogicException;

    void deleteList(String deleteByValue, int deleteNumberValue) throws LogicException;

    void clear() throws LogicException;

    void find(String field, String meaning) throws LogicException;

    void sortList(String sortField) throws LogicException;

}
