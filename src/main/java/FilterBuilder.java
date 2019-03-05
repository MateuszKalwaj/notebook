import java.util.logging.Filter;

public class FilterBuilder {
    private String authorFilter;
    private String titleFilter;
    private String contentFilter;

    public FilterBuilder withAuthor (String author) {
        this.authorFilter = author;
        return this;
    }

    public FilterBuilder withTitle (String title) {
        this.titleFilter = title;
        return this;
    }

    public FilterBuilder withContent (String content) {
        this.contentFilter = content;
        return this;
    }

    public NoteFilter build() {
        NoteFilter noteFilter = new NoteFilter();
        noteFilter.setAuthorFilter(authorFilter);
        noteFilter.setTitleFilter(titleFilter);
        noteFilter.setContentFilter(contentFilter);
        return noteFilter;
    }



}
