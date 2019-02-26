import java.util.ArrayList;
import java.util.List;

public class Notebook implements NoteContainer{
    private List<Note> noteContainer = new ArrayList<>();


    @Override
    public void add(Note note) {
        if (note != null) {
            noteContainer.add(note);
        }
    }

    @Override
    public boolean remove(List<Note> notes) {
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
