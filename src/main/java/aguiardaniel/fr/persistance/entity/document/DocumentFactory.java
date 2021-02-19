package aguiardaniel.fr.persistance.entity.document;

import aguiardaniel.fr.persistance.entity.state.Borrowed;
import aguiardaniel.fr.persistance.entity.state.Free;
import mediatek2021.Document;

public class DocumentFactory {

    public static Document newDocument(String title, DocType type, boolean isFree) {
        switch (type) {
            case BOOK :
                return new Book(title, isFree ? new Free() : new Borrowed());
            case CD :
                return new CD(title, isFree ? new Free() : new Borrowed());
            default :
                return new DVD(title, isFree ? new Free() : new Borrowed());
        }
    }
}
