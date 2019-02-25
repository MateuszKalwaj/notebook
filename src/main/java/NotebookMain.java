
import java.util.Date;
import java.util.Scanner;

public class NotebookMain {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        Notebook notebook = new Notebook();
        boolean program = true;

        while(program) {
            int input;
            input = userInput.nextInt();

            switch (input) {
                case (1): {
                    //add note
                    break;
                }
                case (2): {
                    //display all
                    break;
                }
                case (3): {
                    //filter notes
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
        String content = userInput.nextLine();

        NoteBuilder noteBuilder = new NoteBuilder();

        Date date = new Date();

        noteBuilder.withAuthor(author)
                .withTitle(title)
                .withContent(content)
                .withDate(date);
        Note note = noteBuilder.build();

        if(note != null) {
            System.out.println("Note added");
        }
        return note;
    }

}
