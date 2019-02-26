import java.util.List;

public interface NoteContainer {

    void add(Note note);
    boolean remove(List<Note> notes);
    List <Note> fetchAll();
}
