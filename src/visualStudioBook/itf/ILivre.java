package visualStudioBook.itf;

import java.util.List;

public interface ILivre {
	void setTitle(String title);
	void setAuteur(String auteur);
	void setDescription(String description);
	String getTitle();
	String getAuteur();
	String getDescription();
	List<IEnchainement> getEnchainements();
	List<ISection> getSections();
	List<IObjet> getObjets();
	void importLivre(String path);
	void exportLivre(String path, int type);
	
}
