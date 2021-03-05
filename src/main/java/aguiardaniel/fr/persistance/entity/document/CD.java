package aguiardaniel.fr.persistance.entity.document;

import java.util.Arrays;
import java.util.stream.Stream;

public class CD extends GeneralDocument{
    private final String artist;

    public CD(String title, String description, String artist, DocumentState state) {
        super(title, description, state);
        this.artist = artist;
    }

    public CD(int id, String title, String description, String artist, DocumentState state) {
        super(id, title, description, state);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public Object[] data() {
        Object[] data = {artist, CD.class};
        return Stream.of(super.data(), data).flatMap(Stream::of).toArray();
    }

    @Override
    public String toString() {
//        return "CD{" +
//                "artist='" + artist + '\'' +
//                '}' + super.toString();
        return super.toString() + Arrays.toString(data());
    }
}
