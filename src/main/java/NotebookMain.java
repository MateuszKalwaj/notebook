
import java.util.Date;
import java.util.Scanner;

public class NotebookMain {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Notebook notebook = Notebook.getInstance();

        boolean program = true;

        while (program) {
            menuToDisplay();
            int input;
            input = userInput.nextInt();

            switch (input) {
                case (1): {
                    notebook.add(addNote());
                    break;
                }
                case (2): {
                    displayNotes(notebook);
                    break;
                }
                case (3): {

                    break;
                }
                case (4): {
                    //remove note/notes
                    break;
                }
                case (5): {
                    program = false;
                    break;
                }
            }

        }
    }

    public static Note addNote() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter author");
        String author = userInput.nextLine();
        System.out.println("Enter title");
        String title = userInput.nextLine();
        System.out.println("Enter content");
        String content = userInput.nextLine();

        NoteBuilder noteBuilder = new NoteBuilder();

        Date date = new Date();

        noteBuilder.withAuthor(author)
                .withTitle(title)
                .withContent(content)
                .withDate(date);
        Note note = noteBuilder.build();

        if (note != null) {
            System.out.println("Note added");
        }
        return note;
    }

    public static void menuToDisplay() {
        System.out.println("\nHello! \n" +
                "What do you like to do? \n" +
                "1 - add note \n" +
                "2 - display all notes \n" +
                "3 - filter notes \n" +
                "4 - remove note/notes \n" +
                "5 - exit");
    }

    public static void displayNotes(Notebook notebook) {
        System.out.println("What view do you like to see? \n" +
                "1 - compact view; " +
                "2 - summary view");
        Scanner userInput = new Scanner(System.in);
        int view = userInput.nextInt();


        if (view == 1) {
            DisplayStrategy displayStrategy = new DisplayCompact();
            DisplayNotebook displayNotebook = new DisplayNotebook(notebook,displayStrategy);
            displayNotebook.displayNotes();
        } if (view == 2) {
            DisplayStrategy displayStrategy = new DisplayAll();
            DisplayNotebook displayNotebook = new DisplayNotebook(notebook, displayStrategy);
            displayNotebook.displayNotes();
        }
    }


}
