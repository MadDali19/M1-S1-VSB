package visualStudioBook.itf;


import java.util.List;

public interface ISection {
	String getTitle();
	void setTitle(String title);
	String getContent();
	void setContent(String content);
	int getIdSection();
	List<IObjet> getGivenObjects();
	
	@Override
	int hashCode();
}
