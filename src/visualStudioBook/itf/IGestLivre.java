package visualStudioBook.itf;

public interface IGestLivre {
	public void addLivre(String title, String auteur,String description);
	public ILivre getLivre(String titre);
	public void deleteLivre(String titre);
	public  ILivre importerLivre(String fileName);
}
