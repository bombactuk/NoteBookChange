package dao.impl;

import entity.Note;

import java.util.concurrent.ArrayBlockingQueue;

public final class MockSource {
    public void add(Note n) {
        MockSourseProvider.getNotes().add(n);
    }

    public void update(Note n) {

        for (Note s : MockSourseProvider.getNotes()) {

            if (s.getId() == n.getId()) {

                s.setTitle(n.getTitle());
                s.setContent(n.getContent());
                s.setDate(n.getDate());

            }

        }

    }

    public void clear() {
        MockSourseProvider.getNotes().clear();
    }

    public void deleteNumberList(int numberInTheListDelete) {

        int counter = 0;

        for (Note s : MockSourseProvider.getNotes()) {

            if (counter == numberInTheListDelete) {
                MockSourseProvider.getNotes().remove(s);
                break;
            }

            counter++;

        }

    }

    public void deleteIdList(int idListDelete) {
        MockSourseProvider.getNotes().removeIf(s -> s.getId() == idListDelete);
    }

    public ArrayBlockingQueue<Note> find(int idFind) {

        ArrayBlockingQueue<Note> notes = new ArrayBlockingQueue<>(1000);

        for (Note s : MockSourseProvider.getNotes()) {
            if (idFind == s.getId()) {
                notes.add(s);
            }
        }

        return notes;

    }

    public ArrayBlockingQueue<Note> find(String title) {

        ArrayBlockingQueue<Note> notes = new ArrayBlockingQueue<>(1000);

        for (Note s : MockSourseProvider.getNotes()) {
            if (title.equals(s.getTitle())) {
                notes.add(s);
            }
        }

        return notes;

    }

    public ArrayBlockingQueue<Note> get() {
        return MockSourseProvider.getNotes();
    }

    public int countOfNotes() {
        return MockSourseProvider.getNotes().size();
    }

}