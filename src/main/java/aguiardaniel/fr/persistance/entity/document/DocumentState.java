package aguiardaniel.fr.persistance.entity.document;

import mediatek2021.Utilisateur;

public interface DocumentState {
    DocumentState borrow(GeneralDocument doc, Utilisateur u) throws BorrowException;
    DocumentState returnBack(GeneralDocument doc) throws ReturnException;
    boolean isBorrowed();

}
