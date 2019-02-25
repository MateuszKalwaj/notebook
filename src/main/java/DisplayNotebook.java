import java.util.List;

public class DisplayNotebook {
    private List<Note> notesList;
    private DisplayStrategy displayStrategy;

    public DisplayNotebook(List<Note> notebook, DisplayStrategy displayStrategy) {
        this.notesList = notebook;
        this.displayStrategy = displayStrategy;
    }

    public void displayNotes() {
        displayStrategy.display(notesList);
    }


}
