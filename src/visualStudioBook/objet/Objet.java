package visualStudioBook.objet;

import java.util.Objects;

import visualStudioBook.itf.IObjet;

public class Objet implements IObjet {
	private final int idObjet;
	private static int numberObjet = 1;
	private String name;
	private String description;
	
	public Objet(String name, String description) {
		Objects.requireNonNull(name);
		Objects.requireNonNull(description);
		
		this.idObjet = numberObjet;
		numberObjet++;
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdObjet() {
		return idObjet;
	}
    public void afficherObjet() {
        System.out.println("		ID: " + getIdObjet());
        System.out.println("		Nom: " + getName());
        System.out.println("		Description: " + getDescription());
        System.out.println("		-------------------------------------------------------------------------------");
    }
	
	
}
