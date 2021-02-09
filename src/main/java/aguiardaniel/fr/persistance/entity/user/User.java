package aguiardaniel.fr.persistance.entity.user;

import mediatek2021.Utilisateur;

import java.util.UUID;

public abstract class User implements Utilisateur {
    private final String id;
    private final String username;
    private final String email;
    private final String password;

    public User(String username, String email, String password) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getId() {
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

    @Override
    public Object[] data() {
        return new Object[]{username, email};
    }
}
