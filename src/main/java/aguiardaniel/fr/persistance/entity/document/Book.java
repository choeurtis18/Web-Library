package aguiardaniel.fr.persistance.entity.document;

import java.util.stream.Stream;

public class Book extends GeneralDocument{
    private final String author;

    public Book(String title, String author, DocumentState state) {
        super(title, state);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public Object[] data() {
        Object[] data = {author};
        return Stream.of(super.data(), data).flatMap(Stream::of).toArray();
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}'+super.toString();
    }
}
