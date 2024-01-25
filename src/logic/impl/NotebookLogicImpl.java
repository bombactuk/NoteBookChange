package logic.impl;

import dao.DaoException;
import dao.DaoProvider;
import dao.NoteBookDao;
import entity.Note;
import logic.LogicException;
import logic.NotebookLogic;

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
    public void deleteNumberList(int numberInTheListDelete) throws LogicException {
        try {
            dao.deleteNumberList(numberInTheListDelete);
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void deleteIdList(int idListDelete) throws LogicException {
        try {
            dao.deleteIdList(idListDelete);
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
    public void sortNotesTitle() throws LogicException {
        try {
            dao.sortNotesTitle();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

    @Override
    public void sortNotesContent() throws LogicException {
        try {
            dao.sortNotesContent();
        } catch (DaoException e) {
            throw new LogicException(e);
        }
    }

}
