package aguiardaniel.fr.persistance.entity.user;

import mediatek2021.Utilisateur;

public abstract class User implements Utilisateur {
    private final String username;
    private final String email;
    private final String password;
    private int id;

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
