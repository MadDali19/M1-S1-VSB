package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import visualStudioBook.livre.Livre;
import visualStudioBook.objet.Objet;
import visualStudioBook.enchainement.Enchainement;
import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
class testEnchainement {
	@Test
	void test() {
		Livre Livre1 = new Livre("titre", "auteur", "description");
		
		Livre1.addSection("Première Section", "Contenu initial de la première section");
		Livre1.addSection("deuxieme Section", "Contenu initial de la deuxieme section");
		Livre1.addEnchainement(Livre1.getSection(1), Livre1.getSection(2));
		int idSectionDestination = Livre1.getEnchainements().get(0).getDestination().getIdSection();
		assertEquals("erreur",2, idSectionDestination);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		ArrayList<IObjet> givenObjectss = new ArrayList<>();
	    IObjet nouvelObjets = new Objet("objetS2.1", "descriptionObjet");
	    givenObjectss.add(nouvelObjets);
	    Livre1.updateObjetSection(1, givenObjectss);
	    Livre1.getEnchainements().get(0).setCondition(Livre1.getSection(1));
	    assertEquals("erreur","objetS2.1", Livre1.getEnchainements().get(0).getCondition().get(0).getName());
	    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    assertNotEquals(4, idSectionDestination);
	    assertFalse(idSectionDestination==4);


	}

}
