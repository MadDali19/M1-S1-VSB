package visualStudioBook.itf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
	
	boolean addSection(String title, String content);
	boolean addEnchainement(ISection source, ISection destination);
	
	boolean removeSection(int sectionNumber);
	boolean updateSection(int sectionNumber, String newTitle, String newContent);
	void analyseSectionsNonLiees();
	ISection getSection(int sectionNumber);
	boolean updateObjetSection(int sectionNumber, ArrayList<IObjet> Objects);
	void sauvegarderLivre(ILivre livre, String fileName);
}
   