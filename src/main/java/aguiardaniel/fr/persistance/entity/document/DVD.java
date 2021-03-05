package aguiardaniel.fr.persistance.entity.document;

import java.util.stream.Stream;

public class DVD extends GeneralDocument{
    private final String producer;

    public DVD(String title, String description, String producer, DocumentState state) {
        super(title, description, state);
        this.producer = producer;
    }

    public DVD(int id, String title, String description, String producer, DocumentState state) {
        super(id, title, description, state);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public Object[] data() {
        Object[] data = {producer, DVD.class};
        return Stream.of(super.data(), data).flatMap(Stream::of).toArray();
    }

    @Override
    public String toString() {
        return "DVD{" +
                "producer='" + producer + '\'' +
                '}' + super.toString();
    }
}
