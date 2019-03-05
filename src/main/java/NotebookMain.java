
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class NotebookMain {

    String newNote;

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
                    displayNotes(notebook.fetchAll(), howToDisplay());
                    break;
                }
                case (3): {
                    displayNotes(notesFilter(notebook) , howToDisplay());
                    break;
                }
                case (4): {
                    deleteNote(notebook);
                    break;
                }
                case (5): {
                    program = false;
                    break;
                }
            }

        }
    }

    public static int howToDisplay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What view you want to see? \n" +
                "1- compact view \n" +
                "2- full view");
        int displayway = userInput.nextInt();
        return displayway;
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

    public static void displayNotes(List<Note> noteList, int howToDisplay) {
        Scanner userInput = new Scanner(System.in);
        int view = userInput.nextInt();
        view = howToDisplay;


        if (view == 1) {
            DisplayStrategy displayStrategy = new DisplayCompact();
            DisplayNotebook displayNotebook = new DisplayNotebook(noteList, displayStrategy);
            displayNotebook.displayNotes();
        } if (view == 2) {
            DisplayStrategy displayStrategy = new DisplayAll();
            DisplayNotebook displayNotebook = new DisplayNotebook(noteList, displayStrategy);
            displayNotebook.displayNotes();
        }


    }

    public static NoteFilter availableFilters() {
        String author = null;
        String title = null;
        String content = null;

        Scanner userInput = new Scanner(System.in);

        boolean program = true;

        while (program) {
            menuToFilter();
            int input = userInput.nextInt();

            switch (input) {
                case (1): {
                    System.out.println("Enter author: ");
                    userInput.nextLine();
                    author = userInput.nextLine();
                }
                case (2): {
                    System.out.println("Enter title: ");
                    userInput.nextLine();
                    title = userInput.nextLine();
                }
                case (3): {
                    System.out.println("Enter content: ");
                    userInput.nextLine();
                    content = userInput.nextLine();
                }
            }
        }
        FilterBuilder filterBuilder = new FilterBuilder();
        filterBuilder.withAuthor(author).withTitle(title).withContent(content);
        NoteFilter noteFilter = filterBuilder.build();
        return noteFilter;
    }

    public static List<Note> notesFilter (Notebook notebook) {
        NoteFilter noteFilter = availableFilters();
        return Predicates.listVsPredicates(notebook.fetchAll(), Predicates.predicateFilter(noteFilter));
    }

    public static boolean deleteNote (Notebook notebook) {
        Scanner userInput = new Scanner(System.in);
        List <Note> filteredNotes = notesFilter(notebook);
        int howToDisplay = 1;
        System.out.println("Following notes are going to remove: ");
        displayNotes(filteredNotes, howToDisplay);
        System.out.println("Press Y to confirm");
        String confirm =userInput.next();
        if (confirm.equalsIgnoreCase("y")) {
            notebook.delete(filteredNotes);
            System.out.println("Note deleted");
            return true;
        } else  {
            System.out.println("Nothing changed");
            return false;
        }
    }

    public static void menuToFilter() {
        System.out.println(
                "How do you like to filter? \n" +
                "1 - by author \n" +
                "2 - by title \n" +
                "3 - content \n");
    }


    public NoteBuilder mainBuilder() {
        Scanner userInput = new Scanner(System.in);
        NoteBuilder noteBuilder = new NoteBuilder();
        newNote = userInput.next("Enter author");
        noteBuilder.withAuthor(newNote);
        newNote = userInput.next("Enter title");
        noteBuilder.withTitle(newNote);
        newNote = userInput.next("Enter content");
        noteBuilder.withContent(newNote);
        return noteBuilder;
    }


}
