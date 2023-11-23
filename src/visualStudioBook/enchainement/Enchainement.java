package visualStudioBook.enchainement;
import java.util.ArrayList;
import java.util.List;

import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;

public class Enchainement implements IEnchainement {
	private final int idEnchainement;
	private static int numberEnchainement = 1;
	private ISection source;
	private ISection destination;
	private final ArrayList<IObjet> condition;
	
	public Enchainement(ISection source, ISection destination) {
		this.source = source;
		this.destination = destination;
		this.idEnchainement = numberEnchainement;
		this.condition = new ArrayList<IObjet>();
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

	public List<IObjet> getCondition() {
		return condition;
	}
	
}
