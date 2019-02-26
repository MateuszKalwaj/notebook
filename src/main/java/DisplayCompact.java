import java.util.List;

public class DisplayCompact implements DisplayStrategy {


    @Override
    public void display(List<Note> notes) {
        notes.stream().map(note -> note.getTitle() + note.getAuthor()).forEach(System.out::println);

    }
}
