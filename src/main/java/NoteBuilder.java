import java.util.Date;

public class NoteBuilder {

    private String author;
    private String title;
    private String content;
    private Date date;

    public NoteBuilder() {
    }

    public NoteBuilder withAuthor (String author) {
        this.author = author;
        return this;
    }
    public NoteBuilder withTitle (String title) {
        this.title = title;
        return this;
    }
    public NoteBuilder withContent (String content) {
        this.content = content;
        return this;
    }
    public NoteBuilder withDate (Date date) {
        this.date = date;
        return this;
    }

    public Note build() {
        Note note = new Note();
        note.setAuthor(author);
        note.setTitle(title);
        note.setContent(content);
        note.setDate(date);
        return note;
    }


}
