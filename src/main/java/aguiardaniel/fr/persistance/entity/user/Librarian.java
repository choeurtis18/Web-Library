package aguiardaniel.fr.persistance.entity.user;

public class Librarian extends User {

    public Librarian(String username, String email, String password) {
        super(username, email, password);
    }

    public Librarian(int id, String username, String email, String password) {
        super(id, username, email, password);
    }

    public boolean isLibrarian() {
        return true;
    }
}
