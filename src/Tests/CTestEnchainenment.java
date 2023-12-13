package Tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;
import visualStudioBook.factory.EnchainementFactory;
import visualStudioBook.factory.ObjetFactory;
import visualStudioBook.factory.SectionFactory;


class CTestEnchainenment {
	@Test
	void test1() {
		ISection s1 = SectionFactory.createNewSection("s1", "content s1");
		ISection s2 = SectionFactory.createNewSection("s2", "content s2");
		ISection s3 = SectionFactory.createNewSection("s4", "content s4");
		ISection s4 = SectionFactory.createNewSection("s4", "content s4");
		
		Objects.requireNonNull(s1);
		Objects.requireNonNull(s2);
		Objects.requireNonNull(s3);
		Objects.requireNonNull(s4);
		
		IEnchainement ench = EnchainementFactory.createEnchainement(s1, s2);
		
		assertEquals(ench.getSource(), s1);
		assertEquals(ench.getDestination(), s2);
		
		ench.setSource(s3);
		ench.setDestination(s4);

		assertEquals(ench.getSource(), s3);
		assertEquals(ench.getDestination(), s4);
	}
	
	void test2() {
		ISection s1 = SectionFactory.createNewSection("s1", "content s1");
		ISection s2 = SectionFactory.createNewSection("s2", "content s2");
		ArrayList<IObjet> condition = new ArrayList<IObjet>();
		IObjet objet = ObjetFactory.createObjet("obj 1", "description");
		
		Objects.requireNonNull(s1);
		Objects.requireNonNull(s2);
		Objects.requireNonNull(condition);
		Objects.requireNonNull(objet);
		
		condition.add(objet);
		
		IEnchainement ench = EnchainementFactory.createEnchainement(s1, s2);
		
		assertEquals(ench.getCondition(), condition);
	}
}
