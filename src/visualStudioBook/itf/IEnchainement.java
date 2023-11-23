package visualStudioBook.itf;

import java.util.List;

public interface IEnchainement {
	ISection getSource();
	void setSource(ISection source);
	ISection getDestination();
	void setDestination(ISection destination);
	int getIdEnchainement();
	List<IObjet> getCondition();
}
