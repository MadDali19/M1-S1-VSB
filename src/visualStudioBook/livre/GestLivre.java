package visualStudioBook.livre;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import visualStudioBook.itf.ILivre;
import visualStudioBook.factory.*;
public class GestLivre implements Serializable {
	private Map<String, ILivre> livres =new HashMap<String,ILivre>();
	boolean c= false;
	public void addLivre(String title, String auteur,String description)  {
		// TODO Auto-generated method stub
		
		ILivre livre=LivreFactory.createLivre(title, auteur, description);
		
		if (livres.containsKey(title) ) {
			c=true;
		}
		else {
		livres.put(title,livre);
		}
		
		//System.out.println(livre.toString()+ " a été crée");
	}
	public ILivre getLivre(String titre) {
		// TODO Auto-generated method stub
		if (c==false){
		return livres.get(titre);}
		else {return null;}
	}
	
	
	public void deleteLivre(String titre) throws Exception{
		// TODO Auto-generated method stub
		
		if(livres.remove(titre)==null) {
			throw new Exception("Le livre que vous essayez de supprimer n'existe pas:: ");
		}
		//System.out.println("Le livre "+titre+ " a été supprimé");
	}
	/*public static void sauvegarderLivre(ILivre livre, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(livre);
            System.out.println("Le livre a été sauvegardé avec succès dans le fichier : " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
	public  ILivre importerLivre(String fileName) {
        ILivre livre = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            livre = (ILivre) ois.readObject();
            System.out.println("Le livre a été importé avec succès depuis le fichier : " + new File(fileName).getAbsolutePath());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return livre;
    }

}
