package dao;

import entity.Note;

import java.util.List;

public interface NoteBookDao {

    void save(Note n) throws DaoException;

    void deleteNumberList(int numberInTheListDelete) throws DaoException;

    void deleteIdList(int idListDelete) throws DaoException;

    void clear() throws DaoException;

    void sortNotesTitle() throws DaoException;

    void sortNotesContent() throws DaoException;

    List<Note> allNotes() throws DaoException;

}