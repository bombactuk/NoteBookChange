package dao;

import entity.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public interface NoteBookDao {

    void save(Note n) throws DaoException;

    void update(Note n) throws DaoException;

    void deleteList(String deleteByValuem, int deleteNumberValue) throws DaoException;

    void clear() throws DaoException;

    void find(String field, String meaning) throws DaoException;

    void sortList(String sortField) throws DaoException;

    ArrayBlockingQueue<Note> allNotes();

}