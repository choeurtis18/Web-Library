package aguiardaniel.fr.persistance.entity.document;

import mediatek2021.Document;

public abstract class GeneralDocument implements Document {
    private final int number;
    private final String title;
    private DocumentState state;
    private static int count = 0;

    public GeneralDocument(String title, DocumentState state) {
        this.number = ++count;
        this.title = title;
        this.state = state;
    }
    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public DocumentState getState() { return state; }

    @Override
    public Object[] data() {
        return new Object[]{number, title, state};
    }
}
