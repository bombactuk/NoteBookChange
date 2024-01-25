package dao.impl;

import dao.DaoProvider;
import entity.Note;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public final class FileSave {

    private FileSave() {
    }

    public static void dataStorage(List<Note> notes) throws IOException {

        FileWriter writer = new FileWriter(DaoProvider.getFileName(), false);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        for (Note s : notes) {
            writer.write("/Id=" + s.getId() +
                    "/Title=" + s.getTitle() +
                    "/Content=" + s.getContent() +
                    "/Date=" + formatter.format(s.getDate()));
            writer.append("\n");
        }

        writer.close();

    }

}
