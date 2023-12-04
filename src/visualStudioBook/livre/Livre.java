package visualStudioBook.livre;

import java.util.ArrayList;
import java.util.HashMap;
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
	private final HashMap<Integer,ISection> sections;
	private final HashMap<Integer,IObjet> objets;
	
	public Livre(String title, String auteur, String description) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(auteur);
		Objects.requireNonNull(description);
		this.title = title;
		this.auteur = auteur;
		this.description = description;
		enchainements = new ArrayList<IEnchainement>();
		sections = new HashMap<Integer,ISection>();
		objets = new HashMap<Integer,IObjet>();
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
		return new ArrayList<ISection>(sections.values());
	}

	public List<IObjet> getObjets() {
		return new ArrayList<IObjet>(objets.values());
	}
	
	
	
	public boolean addSection(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		ISection newSection = SectionFactory.createNewSection(title, content);
		this.sections.put(Integer.valueOf(newSection.getIdSection()), newSection);
		return true;
	}

	public boolean modifySection(int id, String title, String content) {
		if (sections.containsKey(Integer.valueOf(id))) {
			sections.get(Integer.valueOf(id)).setTitle(title);
			sections.get(Integer.valueOf(id)).setContent(content);
			return true;
		}
		return false;
	}
	
	public boolean deleteSection(int id) {
		if (sections.containsKey(Integer.valueOf(id))) {
			sections.remove(Integer.valueOf(id));
			return true;
		}
		return false;
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
	
	public boolean modifyEnchainement(int id, ISection source, ISection destination) {
		Objects.requireNonNull(source);
		Objects.requireNonNull(destination);
		
		Iterator<IEnchainement> iterator = this.enchainements.iterator();
		IEnchainement toModify = null;
		while(iterator.hasNext()) {
			IEnchainement next = iterator.next();
			if (next.getSource().getIdSection() == source.getIdSection()
				&&
				next.getDestination().getIdSection() == destination.getIdSection()) {
				return false;
			}
			if (next.getIdEnchainement() == id) toModify = next;
		}
		if (toModify != null) {
			toModify.setDestination(destination);
			toModify.setSource(source);
			return true;
		}
		return false;
	}
	
	public boolean deleteEnchainement(int id) {
		Iterator<IEnchainement> iterator = this.enchainements.iterator();
		IEnchainement toDelete;
		while(iterator.hasNext()) {
			IEnchainement next = iterator.next();
			if (next.getIdEnchainement() == id) {
				toDelete = next;
				enchainements.remove(toDelete);
				return true;
			}
		}
		return false;
	}
	
	public boolean addObjet(String name, String description) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(description);
		IObjet newObjet = ObjetFactory.createObjet(name, description);
		this.objets.put(Integer.valueOf(newObjet.getIdObjet()), newObjet);
		return true;
	}
	

}
