package visualStudioBook.enchainement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;
import visualStudioBook.objet.Objet;

public class Enchainement implements IEnchainement, Serializable {
	private final int idEnchainement;
	private static int numberEnchainement = 1;
	private ISection source;
	private ISection destination;
	private ArrayList<IObjet> condition;
	
	public Enchainement(ISection source, ISection destination) {
		this.source = source;
		this.destination = destination;
		this.idEnchainement = numberEnchainement;
		this.condition = new  ArrayList<IObjet>();
		numberEnchainement++;
	}

	public int getIdEnchainement() {
		return idEnchainement;
	}

	public ISection getSource() {
		return source;
	}

	public void setSource(ISection source) {
		this.source = source;
	}

	public ISection getDestination() {
		return destination;
	}

	public void setDestination(ISection destination) {
		this.destination = destination;
	}
	public void setCondition(ISection s) {
		this.condition = (ArrayList<IObjet>) s.getGivenObjects();
	}
	public List<IObjet> getCondition() {
		return condition;
	}
	public void afficherEnchainement() {
        System.out.println("ID Enchainement : " + getIdEnchainement());
        System.out.println("Source Section : " + getSource().getTitle()); // Assurez-vous que ISection a une méthode getTitle()
        System.out.println("Destination Section : " + getDestination().getTitle()); // Assurez-vous que ISection a une méthode getTitle()

        List<IObjet> conditions = getCondition();
        System.out.println("Conditions : ");
        for (IObjet condition : conditions) {
            ((Objet) condition).afficherObjet();
        }
        System.out.println();
    }

	
}
