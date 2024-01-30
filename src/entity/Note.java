package entity;

import util.GenerateId;

import java.util.Date;
import java.util.Objects;

public class Note {

    private int id;
    private String title;
    private String content;
    private Date date;

    public Note() {
    }

    public Note(int id, String title, String content, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Note(String title, String content, Date date) {
        this.id = GenerateId.nextId();
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Note(String title, String content) {
        this.id = GenerateId.nextId();
        this.title = title;
        this.content = content;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && Objects.equals(title, note.title) && Objects.equals(content, note.content) && Objects.equals(date, note.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, date);
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

}
