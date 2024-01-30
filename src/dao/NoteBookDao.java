package dao;

import entity.Note;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public interface NoteBookDao {

    void save(Note n) throws DaoException;

    void update(Note n) throws DaoException;

    void deleteNumberList(int numberInTheListDelete) throws DaoException;

    void deleteIdList(int idListDelete) throws DaoException;

    void clear() throws DaoException;

    void find(int idFind) throws DaoException;

    void find(String title) throws DaoException;

    ArrayBlockingQueue<Note> allNotes() throws DaoException;

}