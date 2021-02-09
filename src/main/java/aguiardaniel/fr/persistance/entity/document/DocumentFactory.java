package aguiardaniel.fr.persistance.entity.document;

import aguiardaniel.fr.persistance.entity.state.Free;
import mediatek2021.Document;

public class DocumentFactory {

    public static Document newDocument(String title, DocType type) {
        switch (type) {
            case BOOK :
                return new Book(title, new Free());
            case CD :
                return new CD(title, new Free());
            default :
                return new DVD(title, new Free());
        }
    }
}
