package visualStudioBook.analyse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.ISection;
import visualStudioBook.section.Section;
import visualStudioBook.section.Section;
public class Analyse implements Serializable {
	public void analyseSectionsNonLiees(ArrayList<ISection> sections,ArrayList<IEnchainement> enchainements) {
        List<ISection> sectionsNonLiees = new ArrayList<>();

        for (ISection section : sections) {
            boolean sectionLiee = false;

            // Vérifier si la section a au moins un enchaînement sortant
            for (IEnchainement enchainement : enchainements) {
                if (enchainement.getSource().getIdSection() == section.getIdSection()) {
                    sectionLiee = true;
                    break;
                }
            }

            // Si la section n'a pas d'enchaînement sortant, l'ajouter à la liste des sections non liées
            if (!sectionLiee) {
                sectionsNonLiees.add(section);
            }
        }

        // Afficher les sections non liées
        if (!sectionsNonLiees.isEmpty()) {
        	System.out.println("------------------------------------Analyse------------------------------------");
            System.out.println("Sections non liées : ");
            for (ISection section : sectionsNonLiees) {
                System.out.println("   Titre : " + section.getTitle());
                System.out.println("   Contenu : " + section.getContent());
                System.out.println("   Numero : " + ((Section) section).getIdSection());
                System.out.println("--------------------------------------");
                
            }
            System.out.println("------------------------------------Analyse termine------------------------------------");
        } else {
            System.out.println("Toutes les sections sont liées.");
        }
    }
}
