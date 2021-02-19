package aguiardaniel.fr.persistance.dao;

import aguiardaniel.fr.persistance.entity.document.Book;
import aguiardaniel.fr.persistance.entity.document.CD;
import aguiardaniel.fr.persistance.entity.document.DVD;
import aguiardaniel.fr.persistance.entity.document.DocumentState;
import aguiardaniel.fr.persistance.entity.state.Borrowed;
import aguiardaniel.fr.persistance.entity.state.Free;
import aguiardaniel.fr.persistance.entity.user.Librarian;
import aguiardaniel.fr.persistance.entity.user.Subscriber;
import aguiardaniel.fr.persistance.entity.user.User;
import mediatek2021.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO extends DAO<Document> {
    public DocumentDAO() {
        super(DBConnection.getInstance());
    }

    @Override
    public void insert(Document entity) {

    }

    @Override
    public List<Document> getAll() {
        String query = "SELECT * FROM document";
        List<Document> documentslist = new ArrayList<>();
        Document doc = null;

        try (Statement stmt = super.getConnection().createStatement()) {

            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                int documentID = set.getInt("documentID");
                String title = set.getString("title");
                String state = set.getString("state");
                String type = set.getString("type");
                String borrowID = set.getString("borrowID");

                if(set.getString("type").equals("dvd")){
                    String queryDVD = "SELECT * FROM DVD WHERE documentID = ?";
                    PreparedStatement stmtDVD = super.getConnection().prepareStatement(queryDVD);
                    stmtDVD.setInt(1, documentID);

                    ResultSet setDVD = stmtDVD.executeQuery();

                    if(setDVD.next()){
                        doc = new DVD(title, state.equals("free")? new Free() : new Borrowed());
                    }
                }
                else if(set.getString("type").equals("book")){
                    String queryBook = "SELECT * FROM book WHERE documentID = ?";
                    PreparedStatement stmtBook = super.getConnection().prepareStatement(queryBook);
                    stmtBook.setInt(1, documentID);

                    ResultSet setBook = stmtBook.executeQuery();

                    if(setBook.next()){
                        doc = new Book(title, state.equals("free")? new Free() : new Borrowed());
                    }
                }
                else if(set.getString("type").equals("cd")){
                    String queryCD = "SELECT * FROM cd WHERE documentID = ?";
                    PreparedStatement stmtCD = super.getConnection().prepareStatement(queryCD);
                    stmtCD.setInt(1, documentID);

                    ResultSet setCD = stmtCD.executeQuery();

                    if(setCD.next()){
                        doc = new CD(title, state.equals("free")? new Free() : new Borrowed());
                    }
                }

                documentslist.add(doc);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return documentslist;
    }

    @Override
    public Document get(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
