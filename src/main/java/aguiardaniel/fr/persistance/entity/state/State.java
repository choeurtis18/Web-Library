package aguiardaniel.fr.persistance.entity.state;

import aguiardaniel.fr.persistance.entity.document.BorrowException;
import aguiardaniel.fr.persistance.entity.document.DocumentState;
import aguiardaniel.fr.persistance.entity.document.GeneralDocument;
import mediatek2021.Utilisateur;

public class State implements DocumentState {

    @Override
    public DocumentState borrow(GeneralDocument doc, Utilisateur u) {
        throw new BorrowException();
    }

    @Override
    public DocumentState returnBack(GeneralDocument doc) {
        return null;
    }

    @Override
    public boolean isBorrowed() {
        return false;
    }
}
