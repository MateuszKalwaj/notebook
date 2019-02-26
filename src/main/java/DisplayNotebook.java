
public class DisplayNotebook {

    private Notebook notebook;
    private DisplayStrategy displayStrategy;

    public DisplayNotebook(Notebook notebook, DisplayStrategy displayStrategy) {
        this.notebook = notebook;
        this.displayStrategy = displayStrategy;
    }

    public void displayNotes() {
        displayStrategy.display(notebook.fetchAll());
    }


}
