package aguiardaniel.fr.persistance.entity.document;

import mediatek2021.Document;

public abstract class GeneralDocument implements Document {
    private int number;
    private final String title;
    private final String description;
    private DocumentState state;

    public GeneralDocument(String title, String description, DocumentState state) {
        number = 0;
        this.title = title;
        this.description = description;
        this.state = state;
    }

    public GeneralDocument(int id, String title, String description, DocumentState state) {
        this(title, description, state);
        this.number = id;
    }
    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public DocumentState getState() { return state; }

    @Override
    public Object[] data() {
        return new Object[]{number, title, description, state, state.getClass().getSimpleName()};
    }

    @Override
    public String toString() {
        return "GeneralDocument{" +
                "number=" + number +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", state=" + state +
                '}';
    }
}
