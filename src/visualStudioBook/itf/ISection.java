package visualStudioBook.itf;


import java.util.ArrayList;
import java.util.List;

public interface ISection {
	String getTitle();
	void setTitle(String title);
	void setgivenObjects(ArrayList<IObjet> Objects);
	String getContent();
	void setContent(String content);
	int getIdSection();
	List<IObjet> getGivenObjects();
}
