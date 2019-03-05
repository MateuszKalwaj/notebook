import java.util.List;

public class DisplayNotebook {

    private List<Note> noteList;
    private DisplayStrategy displayStrategy;

    public DisplayNotebook(List<Note> notebook, DisplayStrategy displayStrategy) {
        this.noteList = notebook;
        this.displayStrategy = displayStrategy;
    }

    public void displayNotes() {
        displayStrategy.display(noteList);
    }


}
