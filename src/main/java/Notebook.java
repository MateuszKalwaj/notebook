import java.util.ArrayList;
import java.util.List;

public class Notebook implements NotesContainer{

    private List<Note> notesContainer= new ArrayList<>();

    @Override
    public void add(Note note) {

    }

    @Override
    public boolean remove(List<Note> notes) {
        return false;
    }
}
