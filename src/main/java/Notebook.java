import java.util.ArrayList;
import java.util.List;

public class Notebook implements NoteContainer{

    private static Notebook notebook = new Notebook();

    public static Notebook getInstance() {
        return notebook;
    }

    private Notebook() {

    }
    private List<Note> noteContainer = new ArrayList<>();


    @Override
    public void add(Note note) {
        if (note != null) {
            noteContainer.add(note);
        }
    }

    @Override
    public boolean delete(List<Note> notes) {
        if (notes.isEmpty()) {
        }
        return noteContainer.removeAll(notes);
    }

    @Override
    public List<Note> fetchAll() {
        List<Note> notesList = new ArrayList<>();
        notesList.addAll(noteContainer);
        return notesList;
    }
}
