import java.util.List;

public interface NoteContainer {

    void add(Note note);
    boolean delete(List<Note> notes);
    List <Note> fetchAll();
}
