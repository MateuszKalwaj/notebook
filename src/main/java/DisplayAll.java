import java.util.List;

public class DisplayAll implements DisplayStrategy {

    @Override
    public void display(List<Note> notes) {
        notes.stream().forEach(System.out::println);
    }
}
