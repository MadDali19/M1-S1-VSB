package visualStudioBook.livre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import visualStudioBook.factory.EnchainementFactory;
import visualStudioBook.factory.ObjetFactory;
import visualStudioBook.factory.SectionFactory;
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
		Objects.requireNonNull(title);
		Objects.requireNonNull(auteur);
		Objects.requireNonNull(description);
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
		Objects.requireNonNull(title);
		this.title = title;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		Objects.requireNonNull(auteur);
		this.auteur = auteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		Objects.requireNonNull(description);
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
	
	
	
	public boolean addSection(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		return this.sections.add(SectionFactory.createNewSection(title, content));
	}
	
	public boolean addEnchainement(ISection source, ISection destination) {
		Objects.requireNonNull(source);
		Objects.requireNonNull(destination);
		
		Iterator<IEnchainement> iterator = this.enchainements.iterator();
		while(iterator.hasNext()) {
			IEnchainement next = iterator.next();
			if (next.getSource().getIdSection() == source.getIdSection()
				&&
				next.getDestination().getIdSection() == destination.getIdSection()) {
				return false;
			}
		}
		
		return this.enchainements.add(EnchainementFactory.createEnchainement(source, destination));
	}
	
	public boolean addObjet(String name, String description) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(description);
		return this.objets.add(ObjetFactory.createObjet(name, description));
	}
	
	
}
