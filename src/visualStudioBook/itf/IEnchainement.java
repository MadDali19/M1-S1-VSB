package visualStudioBook.itf;

import java.util.List;

public interface IEnchainement {
	void setSource(ISection source);
	void setDestination(ISection destination);
	void afficherEnchainement();
	void setCondition(ISection source);

	ISection getSource();
	ISection getDestination();
	int getIdEnchainement();
	List<IObjet> getCondition();
}
