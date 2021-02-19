package aguiardaniel.fr.persistance.dao;

import aguiardaniel.fr.persistance.entity.document.*;

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
        List<Document> documents = new ArrayList<>();
        Document doc;

        try(Statement stmt = super.getConnection().createStatement()) {
            ResultSet set = stmt.executeQuery(query);

            while (set.next()) {
                int documentID = set.getInt("documentID");
                String title = set.getString("title");
                String state = set.getString("state");
                String type = set.getString("type");
                String borrowID = set.getString("borrowID");

                ResultSet docSet = getDocumentById(documentID, type);
                if(docSet == null || !docSet.next())
                    return null;

                doc = DocumentFactory.newDocument(title, DocType.getTypeFromString(type), state.equals("free"));

                documents.add(doc);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            System.out.println("1");
        }

        return documents;
    }

    @Override
    public Document get(int id) {
        String queryDoc = "SELECT * FROM Document WHERE documentID = ?";
        try (PreparedStatement preparedStatement = super.getConnection().prepareStatement(queryDoc)) {
            preparedStatement.setInt(1, id);
            ResultSet set = preparedStatement.executeQuery();

            if (!set.next())
                return null;

            int documentID = set.getInt("documentID");
            String title = set.getString("title");
            String state = set.getString("state");
            String type = set.getString("type");
            String borrowID = set.getString("borrowID");

            ResultSet docSet = getDocumentById(documentID, type.toUpperCase());

            if (docSet == null || !docSet.next())
                return null;

            return DocumentFactory.newDocument(title, DocType.getTypeFromString(type), state.equals("free"));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    @Override
    public void delete(int id) {
        String deleteQuery = "DELETE FROM Document WHERE documentID = ?";

        try(PreparedStatement preparedStatement = super.getConnection().prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        }catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    private ResultSet getDocumentById(int documentID, String table){
        String queryDoc = "SELECT * FROM " + table.toUpperCase() + " WHERE documentID = ?";
        try {
            PreparedStatement preparedStatement = super.getConnection().prepareStatement(queryDoc);
            preparedStatement.setInt(1, documentID);
            return preparedStatement.executeQuery();
        }catch (SQLException throwable){
            throwable.printStackTrace();
            return null;
        }
    }
}
