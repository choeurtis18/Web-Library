package aguiardaniel.fr.persistance.entity.user;

import mediatek2021.Utilisateur;

import java.util.UUID;

public abstract class User implements Utilisateur {
    private int id;
    private final String username;
    private final String email;
    private final String password;

    public User(String username, String email, String password) {
        this.id = 0;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password) {
        this(username, email, password);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String login() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }

    public boolean isLibrarian() {
        return false;
    }

    @Override
    public Object[] data() {
        return new Object[]{id, username, email, isLibrarian()};
    }
}
