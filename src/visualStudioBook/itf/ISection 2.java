package visualStudioBook.itf;


import java.util.ArrayList;
import java.util.List;

public interface ISection {
	
	void setTitle(String title);
	void setgivenObjects(ArrayList<IObjet> Objects);
	void setContent(String content);
	
	int getIdSection();
	String getContent();
	String getTitle();
	List<IObjet> getGivenObjects();
}
