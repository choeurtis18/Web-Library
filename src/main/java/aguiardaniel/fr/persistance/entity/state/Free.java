package aguiardaniel.fr.persistance.entity.state;

import aguiardaniel.fr.persistance.entity.document.DocumentState;
import aguiardaniel.fr.persistance.entity.document.GeneralDocument;
import mediatek2021.Utilisateur;

public class Free extends State {

    @Override
    public DocumentState borrow(GeneralDocument doc, Utilisateur u) {
        return null;
    }
}
