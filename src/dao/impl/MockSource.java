package dao.impl;

import entity.Note;
import logic.LogicException;

import java.util.ArrayList;
import java.util.Collections;
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

    public void deleteList(String deleteByValue, int deleteNumberValue) {

        switch (deleteByValue) {

            case "id" -> {
                MockSourseProvider.getNotes().removeIf(s -> s.getId() == deleteNumberValue);
            }

            case "number" -> {

                int counter = 0;

                for (Note s : MockSourseProvider.getNotes()) {

                    if (counter == deleteNumberValue - 1) {
                        MockSourseProvider.getNotes().remove(s);
                        break;
                    }

                    counter++;

                }

            }

        }

    }

    public void find(String field, String meaning) throws NumberFormatException {

        ArrayList<Note> notes = new ArrayList<>();

        for (Note s : MockSourseProvider.getNotes()) {

            switch (field) {

                case "title" -> {

                    if (meaning.equals(s.getTitle())) {
                        notes.add(s);
                    }

                }

                case "id" -> {

                    if (Integer.parseInt(meaning) == s.getId()) {
                        notes.add(s);
                    }

                }

            }

        }

        System.out.println(notes);

    }

    public void sortList(String sortField) {

        ArrayList<Note> notes = new ArrayList<>();

        notes.addAll(0, MockSourseProvider.getNotes());

        switch (sortField) {

            case "id" -> notes.sort((Note o1, Note o2) -> o1.getId() - o2.getId());

            case "title" -> notes.sort((Note o1, Note o2) -> o1.getTitle().compareTo(o2.getTitle()));

            case "content" -> notes.sort((Note o1, Note o2) -> o1.getContent().compareTo(o2.getContent()));

            case "date" -> notes.sort((Note o1, Note o2) -> o1.getDate().compareTo(o2.getDate()));

        }

        clear();

        MockSourseProvider.getNotes().addAll(notes);

    }

    public ArrayBlockingQueue<Note> get() {
        return MockSourseProvider.getNotes();
    }

    public int countOfNotes() {
        return MockSourseProvider.getNotes().size();
    }

}