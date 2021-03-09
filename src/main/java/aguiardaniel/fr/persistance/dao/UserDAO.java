package aguiardaniel.fr.persistance.dao;

import aguiardaniel.fr.persistance.entity.user.Librarian;
import aguiardaniel.fr.persistance.entity.user.Subscriber;
import aguiardaniel.fr.persistance.entity.user.User;
import mediatek2021.Utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends DAO<Utilisateur> {

    public UserDAO() {
        super(DBConnection.getInstance());
    }

    @Override
    public void insert(Utilisateur entity) {
    }

    @Override
    public List<Utilisateur> getAll() {
        return null;
    }

    @Override
    public Utilisateur get(int id) {
        return null;
    }

    public Utilisateur getByLogin(String login, String password) {
        String query = "SELECT * FROM user WHERE email = ? AND pwd = ?";
        User u = null;
        try {
            PreparedStatement preparedStatement = super.getConnection().prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet set = preparedStatement.executeQuery();

            if (set.next()) {
                int userID = set.getInt("id");
                String username = set.getString("username");
                String email = set.getString("email");
                String pwd = set.getString("pwd");
                boolean isLibrarian = set.getBoolean("isLibrarian");

                if (isLibrarian)
                    u = new Librarian(userID, username, email, pwd);
                else
                    u = new Subscriber(userID, username, email, pwd);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
