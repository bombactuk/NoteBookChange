package dao.impl;

import dao.DaoException;
import dao.NoteBookDao;
import entity.Note;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class FileNoteBookDao implements NoteBookDao {

    private final MockSource mockSource = new MockSource();
    private final FileSave fileSave = new FileSave();

    @Override
    public synchronized void save(Note n) throws DaoException {

        try {
            if (n.getId() == 0) {
                n.setId(mockSource.countOfNotes() + 1);
            }

            if (n.getDate() == null) {
                n.setDate(new Date());
            }

            mockSource.add(n);

            fileSave.dataStorage(mockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public synchronized void update(Note n) throws DaoException {

        try {

            mockSource.update(n);

            fileSave.dataStorage(mockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public synchronized void deleteNumberList(int numberInTheListDelete) throws DaoException {

        try {
            mockSource.deleteNumberList(numberInTheListDelete);

            fileSave.dataStorage(mockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public synchronized void deleteIdList(int idListDelete) throws DaoException {
        try {
            mockSource.deleteIdList(idListDelete);

            fileSave.dataStorage(mockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public synchronized void clear() throws DaoException {

        try {
            mockSource.clear();

            fileSave.dataStorage(mockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void find(int idFind) throws DaoException {

        try {
            mockSource.find(idFind);

            fileSave.findStorage(mockSource.find(idFind));

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public void find(String title) throws DaoException {

        try {

            fileSave.findStorage(mockSource.find(title));

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }


    @Override
    public synchronized ArrayBlockingQueue<Note> allNotes() throws DaoException {
        return mockSource.get();
    }

}
