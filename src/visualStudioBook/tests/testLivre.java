package visualStudioBook.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import visualStudioBook.enchainement.Enchainement;
import visualStudioBook.itf.IEnchainement;
import visualStudioBook.itf.IObjet;
import visualStudioBook.itf.ISection;
import visualStudioBook.livre.Livre;
import visualStudioBook.objet.Objet;

import java.util.Scanner;

import java.util.Scanner;
import visualStudioBook.livre.Livre;

public class testLivre {

    private static Livre monLivre = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            afficherMenuPrincipal();
            int choixPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (choixPrincipal) {
                case 1:
                    monLivre = creerLivre(scanner);
                    System.out.println("Le livre '" + monLivre.getTitle() + "' a été créé avec succès!");
                    
                    afficherMenuSections(scanner);
                    break;
                case 2:
                    System.out.println("Au revoir!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("Menu Principal:");
        System.out.println("1. Créer un nouveau livre");
        System.out.println("2. Quitter");
        System.out.print("Choisissez une option (1-2): ");
    }

    private static void afficherMenuSections(Scanner scanner) {
        int choixSections;

        do {
            System.out.println("\nMenu Sections :");
            System.out.println("0. Analyse Sections");
            System.out.println("1. Afficher les sections du livre");
            System.out.println("2. Créer une nouvelle section");
            System.out.println("3. Supprimer une section");
            System.out.println("4. Modifier une section");
            System.out.println("5. Ajouter un objet a une section");
            System.out.println("6. Crrer un enchainement");
            System.out.println("7. afficher les enchainements");
            System.out.println("8. Retour au menu principal");
            System.out.print("Choisissez une option (1-8): ");
            choixSections = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choixSections) {
                case 0:
                	System.out.println("Analyse de sections");
                	// monLivre.analyseSectionsNonLiees();
                    break;
                case 1:
                    afficherSections();
                    break;
                case 2:
                    creerSection(scanner);
                    break;
                case 3:
                    supprimerSection(scanner);
                    break;
                case 4:
                    modifierSection(scanner);
                    break;
                case 5:
                	AjouterobjetSection(scanner);
                    break;
                case 6:
                	Ajouterenchainement(scanner);
                    break;
                case 7:
                	afficherEnchainement();
                    break;
                case 8:
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choixSections != 8);
    }

    private static void afficherSections() {
        if (monLivre != null) {
        	List<ISection> sections = monLivre.getSections();
        	
            for (ISection section : sections) {
                System.out.println("   Titre : " + section.getTitle());
                System.out.println("   Contenu : " + section.getContent());
                System.out.println("   Numero : " + section.getIdSection());
                System.out.println("   objets : ");
                List<IObjet> objets = section.getGivenObjects();

                for (IObjet objet : objets) {
                    ((Objet) objet).afficherObjet();
                }
                System.out.println("------------------------------------------------------------------------------------------------------------");
            }
            
            
        }

        else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }

    private static void creerSection(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le titre de la nouvelle section : ");
            String title = scanner.nextLine();
            System.out.print("Entrez le contenu de la nouvelle section : ");
            String content = scanner.nextLine();
            //ISections sectionsManager = new Sections();
            //ISection section1 = sectionsManager.createSection(title, content);
            monLivre.addSection(title, content);
            System.out.println("Nouvelle section ajoutée avec succès!");
        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }

    private static void supprimerSection(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le numéro de la section à supprimer : ");
            int sectionNumber = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            boolean sectionRemoved = monLivre.removeSection(sectionNumber);

            if (sectionRemoved) {
                System.out.println("Section supprimée avec succès !");
            } else {
                System.out.println("La section n'a pas été trouvée.");
            }
        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }

    private static void modifierSection(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le numéro de la section à modifier : ");
            int sectionNumber = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne
            System.out.print("Entrez le titre : ");
            String title = scanner.nextLine();
            System.out.print("Entrez le contenu : ");
            String content = scanner.nextLine();
         // Mettre à jour la section numéro 2 avec de nouvelles informations
            boolean sectionUpdated = monLivre.updateSection(sectionNumber, title, content);

            if (sectionUpdated) {
                System.out.println("Section mise à jour avec succès !");
            } else {
                System.out.println("La section n'a pas été trouvée.");
            }

        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }
    private static void AjouterobjetSection(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le numéro de la section : ");
            int sectionNumber = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            // Créer la liste d'objets
            ArrayList<IObjet> givenObjects = new ArrayList<>();

            // Demander à l'utilisateur d'ajouter jusqu'à 5 objets
            for (int i = 0; i < 5; i++) {
                System.out.print("Entrez le nom de l'objet : ");
                String nomObjet = scanner.nextLine();
                System.out.print("Entrez la description de l'objet : ");
                String descriptionObjet = scanner.nextLine();

                // Créer un objet avec le nom et la description donnés
                IObjet nouvelObjet = new Objet(nomObjet, descriptionObjet);

                // Ajouter l'objet à la liste
                givenObjects.add(nouvelObjet);

                // Demander si l'utilisateur veut ajouter un autre objet
                System.out.print("Voulez-vous ajouter un autre objet ? (oui/non) ");
                String reponse = scanner.nextLine().toLowerCase();

                // Si la réponse n'est pas "oui", sortir de la boucle
                if (!reponse.equals("oui")) {
                    break;
                }
            }

            // Afficher la liste des objets ajoutés
            System.out.println("Liste des objets ajoutés : ");
            for (IObjet objet : givenObjects) {
                System.out.println("ID: " + objet.getIdObjet() + ", Nom: " + objet.getName() + ", Description: " + objet.getDescription());
            }

            boolean sectionUpdated = monLivre.updateObjetSection(sectionNumber, givenObjects);

            if (sectionUpdated) {
                System.out.println("Section mise à jour avec succès !");
            } else {
                System.out.println("La section n'a pas été trouvée.");
            }

        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }
    private static void Ajouterenchainement(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le numéro de la section de depart : ");
            int sectionNumber1 = scanner.nextInt();
            System.out.print("Entrez le numéro de la section d'arrive : ");
            int sectionNumber2 = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne
            monLivre.addEnchainement(monLivre.getSection(sectionNumber1), monLivre.getSection(sectionNumber2));
            System.out.println("l'enchainement a ete cree avec succès !");
          

        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }

    private static void afficherEnchainement() {
        if (monLivre != null) {
        	List<IEnchainement> Enchainments = monLivre.getEnchainements();
        	for (IEnchainement Enchainment : Enchainments) {
                ((IEnchainement) Enchainment).afficherEnchainement();
            }
        	
        }

        else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
        
        
    }
    private static Livre creerLivre(Scanner scanner) {
        System.out.print("Entrez le titre du livre: ");
        String titre = scanner.nextLine();
        System.out.print("Entrez le nom de l'auteur: ");
        String auteur = scanner.nextLine();
        System.out.print("Entrez la description du livre: ");
        String description = scanner.nextLine();

        Livre livre = new Livre(titre, auteur, description);
        livre.addSection("Première Section", "Contenu initial de la première section");
        return livre;
    }
}
