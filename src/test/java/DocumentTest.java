import aguiardaniel.fr.persistance.entity.document.DocType;
import aguiardaniel.fr.persistance.entity.document.DocumentFactory;
import aguiardaniel.fr.persistance.entity.state.Free;
import mediatek2021.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class DocumentTest {

    private static Document cd;
    private static Document dvd;
    private static Document book;

    @BeforeAll
    public static void init() {
        cd = DocumentFactory.newDocument("Beally Jean - Mickael Jackson", DocType.CD, true);
        dvd = DocumentFactory.newDocument("Fast and Furious 8", DocType.DVD, true);
        book = DocumentFactory.newDocument("The Java Programming", DocType.BOOK, true);
    }

    public static void cdTest() {
        Assertions.assertEquals(Free.class, cd.data()[2].getClass());
    }

    @Test
    public static void main(String[] args) {
        init();
        cdTest();
    }
}
