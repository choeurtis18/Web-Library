package aguiardaniel.fr.persistance;

import aguiardaniel.fr.persistance.dao.DocumentDAO;
import aguiardaniel.fr.persistance.dao.UserDAO;
import aguiardaniel.fr.persistance.entity.document.DocType;
import aguiardaniel.fr.persistance.entity.document.DocumentFactory;
import mediatek2021.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// classe mono-instance : l'unique instance est connue de la bibliotheque
// via une injection de dépendance dans son bloc static

public class MediatekData implements PersistentMediatek {
// Jean-François Brette 01/01/2018

    static {
        // injection dynamique de la dépendance dans le package stable mediatek2021
        Mediatek.getInstance().setData(new MediatekData());
    }

    private UserDAO userDAO;
    private DocumentDAO documentDAO;

    private MediatekData() {
        userDAO = new UserDAO();
        documentDAO = new DocumentDAO();
    }

    // renvoie la liste de tous les documents de la bibliothèque
    @Override
    public List<Document> catalogue(int type) {
        DocType docType = DocType.getTypeById(type);
        if (docType == null)
            return documentDAO.getAll();
        return documentDAO.getAll().stream().filter(d -> {
            Class<?> docClass = (Class<?>) d.data()[6];
            return docClass.getSimpleName().equalsIgnoreCase(docType.toString());
        }).collect(Collectors.toList());
    }

    // va récupérer le User dans la BD et le renvoie
    // si pas trouvé, renvoie null
    @Override
    public Utilisateur getUser(String login, String password) {
        return userDAO.getByLogin(login, password);
    }

    // va récupérer le document de numéro numDocument dans la BD
    // et le renvoie
    // si pas trouvé, renvoie null
    @Override
    public Document getDocument(int numDocument) {
        return documentDAO.get(numDocument);
    }

    // ajoute un nouveau document - exception à définir
    @Override
    public void newDocument(int type, Object... args) throws NewDocException {
        DocType docType = DocType.getTypeById(type);

        if (docType == null)
            throw new NewDocException("This type doesn't exist");

        List<Object> normalizedArgs = new ArrayList<>(Arrays.asList(args));
        normalizedArgs.remove(0);
        Document doc = DocumentFactory.newDocument(args[0].toString(), docType,
                true, normalizedArgs.toArray());

        documentDAO.insert(doc);
        // args[0] -> le titre
        // args [1] --> l'auteur
        // etc en fonction du type et des infos optionnelles
    }

    // supprime un document - exception à définir
    @Override
    public void suppressDoc(int numDoc) throws SuppressException {
        boolean isDeleted = this.documentDAO.delete(numDoc);
        if (!isDeleted)
            throw new SuppressException("This document is borrowed. You can't delete this document");
    }

}

