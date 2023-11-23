package visualStudioBook.livre;

import java.util.ArrayList;
import java.util.List;

import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;

public class Livre {
	private String title;
	private String auteur;
	private String description;
	private final ArrayList<IEnchainement> enchainements;
	private final ArrayList<ISection> sections;
	private final ArrayList<IObjet> objets;
	
	public Livre(String title, String auteur, String description) {
		this.title = title;
		this.auteur = auteur;
		this.description = description;
		enchainements = new ArrayList<IEnchainement>();
		sections = new ArrayList<ISection>();
		objets = new ArrayList<IObjet>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<IEnchainement> getEnchainements() {
		return enchainements;
	}

	public List<ISection> getSections() {
		return sections;
	}

	public List<IObjet> getObjets() {
		return objets;
	}
	
	
}
