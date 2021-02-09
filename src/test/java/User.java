import aguiardaniel.fr.persistance.entity.user.Librarian;
import aguiardaniel.fr.persistance.entity.user.Subscriber;
import aguiardaniel.fr.persistance.entity.user.UserFactory;
import mediatek2021.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class User {
    private static Utilisateur subscriber;
    private static Utilisateur librarian;

    @BeforeEach
    public static void init() {
        subscriber = UserFactory.newUser("Danny",
                "danny0794@outlook.fr", "wxcvbn", false);
        librarian = UserFactory.newUser("Laura",
                "laura.r@gmail.com", "qsdfgh", true);
    }

    @Test
    public static void main(String[] args) {
        init();
        assertTrue(subscriber instanceof Subscriber);
        assertTrue(librarian instanceof Librarian);

        assertEquals("danny0794@outlook.fr", subscriber.data()[1]);
        assertEquals("laura.r@gmail.com", librarian.data()[1]);
    }
}
