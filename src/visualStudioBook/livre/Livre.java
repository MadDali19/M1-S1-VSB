package visualStudioBook.livre;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import visualStudioBook.factory.EnchainementFactory;
import visualStudioBook.factory.ObjetFactory;
import visualStudioBook.factory.SectionFactory;
import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.ILivre;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;
import visualStudioBook.section.Section;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//LVDH projet master
public class Livre implements ILivre,Serializable {
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

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setTitle(String title) {
		Objects.requireNonNull(title);
		this.title = title;
	}

	@Override
	public String getAuteur() {
		return auteur;
	}

	@Override
	public void setAuteur(String auteur) {
		Objects.requireNonNull(auteur);
		this.auteur = auteur;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(String description) {
		Objects.requireNonNull(description);
		this.description = description;
	}

	@Override
	public List<IEnchainement> getEnchainements() {
		return enchainements;
	}

	@Override
	public List<ISection> getSections() {
		return sections;
	}

	@Override
	public List<IObjet> getObjets() {
		return objets;
	}
	
	@Override
	public boolean addSection(String title, String content) {
		Objects.requireNonNull(title);
		Objects.requireNonNull(content);
		return this.sections.add(SectionFactory.createNewSection(title, content));
	}
	
	@Override
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
		IEnchainement enchainement = EnchainementFactory.createEnchainement(source, destination);
		enchainement.setCondition(source);
		return this.enchainements.add(enchainement);
		
		
	}
	
	
	@Override
	public boolean removeSection(int sectionNumber) {
        Iterator<ISection> iterator = this.sections.iterator();
        while (iterator.hasNext()) {
            ISection section = iterator.next();
            if (((Section) section).getIdSection() == sectionNumber) {
                iterator.remove();
                return true; // Section supprimée avec succès
            }
        }
        return false; // La section n'a pas été trouvée
    }
	
	@Override
	public boolean updateSection(int sectionNumber, String newTitle, String newContent) {
        for (ISection section : sections) {
            if (((Section) section).getIdSection() == sectionNumber) {
                section.setTitle(newTitle);
                section.setContent(newContent);
                return true; // Section mise à jour avec succès
            }
        }
        return false; // La section n'a pas été trouvée
    }
	
	@Override
	public boolean updateObjetSection(int sectionNumber, ArrayList<IObjet> Objects) {
        for (ISection section : sections) {
            if (((Section) section).getIdSection() == sectionNumber) {
                section.setgivenObjects(Objects);
                
        		
                return true; // Section mise à jour avec succès
            }
        }
        return false; // La section n'a pas été trouvée
    }
	
	@Override
	public ISection getSection(int sectionNumber) {
        for (ISection section : sections) {
            if (((Section) section).getIdSection() == sectionNumber) {
                
                return section; // Section mise à jour avec succès
            }
        }
		return null;
        
    }
	
	@Override
	public void exportLivre(String path, int type) {
		
	}
	
	@Override
	public void importLivre(String path) {
		
	}

	@Override
	public void analyseSectionsNonLiees() {
		// TODO Auto-generated method stub
		
	}
	public void sauvegarderLivre(ILivre livre, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(livre);
            System.out.println("Le livre a été sauvegardé avec succès dans le fichier : " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
