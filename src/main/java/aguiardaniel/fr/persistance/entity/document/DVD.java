package aguiardaniel.fr.persistance.entity.document;

import java.util.stream.Stream;

public class DVD extends GeneralDocument{
    private final String producer;
    public DVD(String title, String producer, DocumentState state) {
        super(title, state);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    @Override
    public Object[] data() {
        Object[] data = {producer};
        return Stream.of(super.data(), data).flatMap(Stream::of).toArray();
    }

    @Override
    public String toString() {
        return "DVD{" +
                "producer='" + producer + '\'' +
                '}' + super.toString();
    }
}
