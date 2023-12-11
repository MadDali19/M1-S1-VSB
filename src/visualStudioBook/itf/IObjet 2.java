package visualStudioBook.itf;

public interface IObjet {
	String getName();
	String getDescription();
	
	void setName(String name);
	void setDescription(String description);
	int getIdObjet();
	void afficherObjet();
}
