package aguiardaniel.fr.persistance.entity.document;

import java.util.stream.Stream;

public class Book extends GeneralDocument{
    private final String author;

    public Book(String title, String description, String author, DocumentState state) {
        super(title, description, state);
        this.author = author;
    }

    public Book(int id, String title, String description, String author, DocumentState state) {
        super(id, title, description, state);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public Object[] data() {
        Object[] data = {author, Book.class};
        return Stream.of(super.data(), data).flatMap(Stream::of).toArray();
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}'+super.toString();
    }
}
