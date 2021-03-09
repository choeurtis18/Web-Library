package aguiardaniel.fr.persistance.dao;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
    private final Connection connection;

    public DAO(Connection connection) {
        this.connection = connection;
    }

    public static java.sql.Date convertDate(java.util.Date uDate) {
        return new java.sql.Date(uDate.getTime());
    }

    public abstract void insert(T entity);

    public abstract List<T> getAll();

    public abstract T get(int id);

    public abstract boolean delete(int id);

    public Connection getConnection() {
        return connection;
    }

}
