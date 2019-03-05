import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {

    public static Predicate<Note> predicateFilter (NoteFilter noteFilter) {
        return p ->
                (p.getAuthor().equals(noteFilter.getAuthorFilter()) ||
                noteFilter.getAuthorFilter() == null) &&
                        (p.getTitle().equalsIgnoreCase(noteFilter.getTitleFilter()) ||
                                noteFilter.getTitleFilter() == null) &&
                        (p.getContent().equalsIgnoreCase(noteFilter.getAuthorFilter()) ||
                                noteFilter.getContentFilter() == null);
    }

    public static List<Note> listVsPredicates (List<Note> notes, Predicate<Note> filterPredicate) {
        return notes.stream().filter(filterPredicate).collect(Collectors.toList());
    }
}
