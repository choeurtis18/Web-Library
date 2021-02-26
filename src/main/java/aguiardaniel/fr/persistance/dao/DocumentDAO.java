package aguiardaniel.fr.persistance.dao;

import aguiardaniel.fr.persistance.entity.document.*;

import mediatek2021.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DocumentDAO extends DAO<Document> {
    public DocumentDAO() {
        super(DBConnection.getInstance());
    }

    @Override
    public void insert(Document entity){
        String insertionQuery = "INSERT INTO document(title, description, state, type, borrowID) VALUES (?, ?, ?, ?, null)";

        try(PreparedStatement preparedStatement = super.getConnection()
                .prepareStatement(insertionQuery, Statement.RETURN_GENERATED_KEYS)) {
            GeneralDocument gDoc = (GeneralDocument) entity;
            preparedStatement.setString(1, gDoc.getTitle());
            preparedStatement.setString(2, gDoc.getDescription());
            preparedStatement.setString(3, gDoc.getState().getClass().getSimpleName().toLowerCase());
            preparedStatement.setString(4, gDoc.getClass().getSimpleName().toLowerCase());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(!resultSet.next())
                throw new SQLException("No generated keys !");
            int documentID = (int) resultSet.getLong(1);
            PreparedStatement pst = null;

            if(entity instanceof Book) {
                Book book = (Book) gDoc;
                String insert = "INSERT INTO book(documentID, author) VALUES (?, ?)";
                pst = super.getConnection().prepareStatement(insert);
                pst.setInt(1, documentID);
                pst.setString(2, book.getAuthor());
            }
            else if(entity instanceof CD) {
                CD cd = (CD) gDoc;
                String insert = "INSERT INTO cd(documentID, artist) VALUES (?, ?)";
                pst = super.getConnection().prepareStatement(insert);
                pst.setInt(1, documentID);
                pst.setString(2, cd.getArtist());
            }
            else if( entity instanceof DVD) {
                DVD dvd = (DVD) gDoc;
                String insert = "INSERT INTO dvd(documentID, producer) VALUES (?, ?)";
                pst = super.getConnection().prepareStatement(insert);
                pst.setInt(1, documentID);
                pst.setString(2, dvd.getProducer());
            }
            if(pst == null)
                throw new SQLException("Inserting issue");
            pst.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
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
                String description = set.getString("description");
                String state = set.getString("state");
                String type = set.getString("type");

                ResultSet docSet = getDocumentById(documentID, type);

                if(docSet == null || !docSet.next()) {
                    return null;
                }
                switch (type) {
                    case "book":
                        doc = DocumentFactory.newDocument(documentID, title, DocType.getTypeFromString(type),
                                state.equals("free"), description, docSet.getString("author"));
                        break;
                    case "cd":
                        doc = DocumentFactory.newDocument(documentID, title, DocType.getTypeFromString(type),
                                state.equals("free"), description, docSet.getString("artist"));
                        break;
                    case "dvd":
                        doc = DocumentFactory.newDocument(documentID, title, DocType.getTypeFromString(type),
                                state.equals("free"), description, docSet.getString("producer"));
                        break;
                    default:
                        throw new SQLException("Document type invalid");
                }
                documents.add(doc);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();

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
            String description = set.getString("description");
            String state = set.getString("state");
            String type = set.getString("type");

            ResultSet docSet = getDocumentById(documentID, type.toLowerCase());

            if (docSet == null || !docSet.next())
                return null;

            switch (type) {
                case "book":
                    return DocumentFactory.newDocument(documentID, title, DocType.getTypeFromString(type),
                            state.equals("free"), description, docSet.getString("author"));
                case "cd":
                    return DocumentFactory.newDocument(documentID, title, DocType.getTypeFromString(type),
                            state.equals("free"), description, docSet.getString("artist"));
                case "dvd":
                    return DocumentFactory.newDocument(documentID, title, DocType.getTypeFromString(type),
                            state.equals("free"), description, docSet.getString("producer"));
                default:
                    throw new SQLException("Document type invalid");
            }
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
