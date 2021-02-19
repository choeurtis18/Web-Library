package aguiardaniel.fr.persistance;

import aguiardaniel.fr.persistance.dao.DocumentDAO;
import aguiardaniel.fr.persistance.dao.UserDAO;
import mediatek2021.*;

import java.util.List;


// classe mono-instance : l'unique instance est connue de la bibliotheque
// via une injection de dépendance dans son bloc static

public class MediatekData implements PersistentMediatek {
// Jean-François Brette 01/01/2018

	private UserDAO userDAO;
	private DocumentDAO documentDAO;

	static {
		// injection dynamique de la dépendance dans le package stable mediatek2021
		Mediatek.getInstance().setData(new MediatekData());
	}

	private MediatekData(){
		userDAO = new UserDAO();
		documentDAO = new DocumentDAO();
	}

	// renvoie la liste de tous les documents de la bibliothèque
	@Override
	public List<Document> catalogue(int type) {
		return documentDAO.getAll();
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
		// args[0] -> le titre
		// args [1] --> l'auteur
		// etc en fonction du type et des infos optionnelles
	}

	// supprime un document - exception à définir
	@Override
	public void suppressDoc(int numDoc) throws SuppressException {
		
	}

}

