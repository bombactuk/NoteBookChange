package logic.impl;

import dao.DaoException;
import dao.DaoProvider;
import dao.NoteBookDao;
import entity.Note;
import logic.LogicException;
import logic.NotebookLogic;

import java.util.ArrayList;

public class NotebookLogicImpl implements NotebookLogic {

    private final DaoProvider provider = DaoProvider.getInstance();
    private final NoteBookDao dao = provider.getNoteBookDao();

    @Override
    public void add(Note n) throws LogicException {
        try {
            dao.save(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void update(Note n) throws LogicException {
        try {
            dao.update(n);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteList(String deleteByValue, int deleteNumberValue) throws LogicException {
        try {
            dao.deleteList(deleteByValue, deleteNumberValue);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }


    @Override
    public void clear() throws LogicException {
        try {
            dao.clear();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void find(String field, String meaning) throws LogicException {
        try {
            dao.find(field, meaning);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void sortList(String sortField) throws LogicException {
        try {
            dao.sortList(sortField);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }


}
