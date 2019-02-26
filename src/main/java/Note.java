
import java.util.Date;

public class Note {

    private String author;
    private String title;
    private String content;
    private Date date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

        if (!title.equals(note.title)) return false;
        if (!author.equals(note.author)) return false;
        if (!content.equals(note.content)) return false;
        return date.equals(note.date);
    }
    @Override
    public String toString() {
        return "Note{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + date.hashCode();
        return result;





    }
}
