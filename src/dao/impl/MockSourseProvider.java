package dao.impl;

import entity.Note;

import java.util.concurrent.ArrayBlockingQueue;

public final class MockSourseProvider {

    private static final ArrayBlockingQueue<Note> notes;

    static {
        notes = new ArrayBlockingQueue<>(1000);
    }

    private MockSourseProvider() {
    }

    public static ArrayBlockingQueue<Note> getNotes() {
        return notes;
    }

}
