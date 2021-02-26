package aguiardaniel.fr.persistance.entity.user;

public class Subscriber extends User{

    public Subscriber(String username, String email, String password) {
        super(username, email, password);
    }

    public Subscriber(int id, String username, String email, String password) {
        super(id, username, email, password);
    }

}
