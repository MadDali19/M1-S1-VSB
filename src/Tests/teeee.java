package Tests;

import java.util.ArrayList;

import visualStudioBook.livre.Livre;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import visualStudioBook.enchainement.Enchainement;
import visualStudioBook.factory.SectionFactory;
import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;
import visualStudioBook.livre.Livre;
import visualStudioBook.objet.Objet;

import java.util.Scanner;

import java.util.Scanner;
import visualStudioBook.livre.Livre;
public class teeee {
	public static void main(String[] args) {
	Livre Livre1 = new Livre("titre", "auteur", "description");
	
	Livre1.addSection("Première Section", "Contenu initial de la première section");
	Livre1.addSection("deuxieme Section", "Contenu initial de la deuxieme section");
	ArrayList<IObjet> givenObjectss = new ArrayList<>();
    IObjet nouvelObjets = new Objet("objetS2.1", "descriptionObjet");
    givenObjectss.add(nouvelObjets);
    Livre1.updateObjetSection(1, givenObjectss);
    
    Livre1.addEnchainement(Livre1.getSection(1), Livre1.getSection(2));
    System.out.print(Livre1.getEnchainements().get(0).getCondition().get(0).getName());
    
	}
    
}
