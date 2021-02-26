package aguiardaniel.fr.persistance.entity.document;

import aguiardaniel.fr.persistance.entity.state.Borrowed;
import aguiardaniel.fr.persistance.entity.state.Free;
import mediatek2021.Document;

import java.util.Arrays;

public class DocumentFactory {

    /**
     * Function for create a new document (type of documents available -> BOOK, CD, DVD)
     * @param title title of document
     * @param type type of document
     * @param isFree ts the document is free or borrowed
     * @param args as many you want just follow the class pattern
     * @return a document of the type chose
     */
    public static Document newDocument(String title, DocType type, boolean isFree, Object... args) {
        switch (type) {
            case BOOK :
                return new Book(title, args[0].toString(), args[1].toString(), isFree ? new Free() : new Borrowed());
            case CD :
                return new CD(title, args[0].toString(), args[1].toString(), isFree ? new Free() : new Borrowed());
            default :
                return new DVD(title, args[0].toString(), args[1].toString(), isFree ? new Free() : new Borrowed());
        }
    }

    public static Document newDocument(int id, String title, DocType type, boolean isFree, Object... args) {
        switch (type) {
            case BOOK :
                return new Book(id, title, args[0].toString(), args[1].toString(), isFree ? new Free() : new Borrowed());
            case CD :
                return new CD(id, title, args[0].toString(), args[1].toString(), isFree ? new Free() : new Borrowed());
            default :
                return new DVD(id, title, args[0].toString(), args[1].toString(), isFree ? new Free() : new Borrowed());
        }
    }
}
