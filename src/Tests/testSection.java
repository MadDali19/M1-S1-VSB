package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import visualStudioBook.livre.Livre;

class testSection {

	@Test
	void test() {
		Livre Livre1 = new Livre("titre", "auteur", "description");
		Livre1.addSection("Première Section", "Contenu initial de la première section");
		Livre1.addSection("deuxieme Section", "Contenu initial de la deuxieme section");
		assertEquals("erreur",2, Livre1.getSections().size());
		
	
		Livre1.getSection(2).setTitle("Section 2");
		assertEquals("erreur","Section 2",Livre1.getSection(2).getTitle() );
		
		Livre1.removeSection(1);
		assertEquals("erreur",1, Livre1.getSections().size());
		
	}

}
