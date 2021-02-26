package aguiardaniel.fr.persistance.entity.user;

import mediatek2021.Utilisateur;

public class UserFactory {

    public static Utilisateur newUser(String username, String email, String password, boolean lib) {
        return lib ? new Librarian(username, email, password) : new Subscriber(username, email, password);
    }
    public static Utilisateur newUser(int id, String username, String email, String password, boolean lib) {
        return lib ? new Librarian(id, username, email, password) : new Subscriber(id, username, email, password);
    }

}
