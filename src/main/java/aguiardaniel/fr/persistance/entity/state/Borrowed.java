package aguiardaniel.fr.persistance.entity.state;

import aguiardaniel.fr.persistance.entity.document.DocumentState;
import aguiardaniel.fr.persistance.entity.document.GeneralDocument;

public class Borrowed extends State {

    @Override
    public DocumentState returnBack(GeneralDocument doc) {
        return null;
    }

    @Override
    public boolean isBorrowed() { return true; }
}
