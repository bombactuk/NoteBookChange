package task.test.dao.impl;

import task.test.dao.DaoException;
import task.test.dao.NoteBookDao;
import task.test.entity.Note;

import java.io.IOException;
import java.util.Date;
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
    public void deleteList(String deleteByValue, int deleteNumberValue) throws DaoException {
        try {
            mockSource.deleteList(deleteByValue, deleteNumberValue);

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
    public void find(String field, String meaning) throws DaoException {
        try {
            mockSource.find(field, meaning);

        } catch (NumberFormatException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void sortList(String sortField) throws DaoException {

        try {
            mockSource.sortList(sortField);

            fileSave.dataStorage(mockSource.get());

        } catch (IOException e) {
            throw new DaoException(e);
        }

    }


    @Override
    public synchronized ArrayBlockingQueue<Note> allNotes() {
        return mockSource.get();
    }

}
