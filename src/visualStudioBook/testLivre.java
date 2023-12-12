package visualStudioBook;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import visualStudioBook.livre.Livre; // Assurez-vous de cette ligne d'import


import visualStudioBook.itf.ISection;


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
            System.out.println("1. Afficher les sections du livre");
            System.out.println("2. Créer une nouvelle section");
            System.out.println("3. Supprimer une section");
            System.out.println("4. Modifier une section");
            System.out.println("5. Retour au menu principal");
            System.out.print("Choisissez une option (1-5): ");
            choixSections = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            switch (choixSections) {
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
                    System.out.println("Retour au menu principal.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choixSections != 5);
    }

    private static void afficherSections() {
        if (monLivre != null) {
            System.out.println("\nSections du livre :");
            List<ISection> sections = monLivre.getSections();
            Iterator<ISection> iterator = sections.iterator();
            while(iterator.hasNext()) {
            	ISection next = iterator.next();
            	System.out.println("Section " + next.getIdSection() + " : " + next.getTitle());
            	System.out.println("Contenu : " + next.getContent());
            	System.out.println();
            }
            
        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }

    private static void creerSection(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le titre de la nouvelle section : ");
            String title = scanner.nextLine();
            System.out.print("Entrez le contenu de la nouvelle section : ");
            String content = scanner.nextLine();
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

            // Ajoutez ici la logique pour supprimer la section avec le numéro sectionNumber
            // Utilisez monLivre.getSections() pour obtenir la liste des sections actuelles
            // Assurez-vous que la section 1 ne peut pas être supprimée
        } else {
            System.out.println("Aucun livre n'a été créé. Veuillez d'abord créer un livre.");
        }
    }

    private static void modifierSection(Scanner scanner) {
        if (monLivre != null) {
            System.out.print("Entrez le numéro de la section à modifier : ");
            int sectionNumber = scanner.nextInt();
            scanner.nextLine(); // consommer la nouvelle ligne

            // Ajoutez ici la logique pour modifier la section avec le numéro sectionNumber
            // Utilisez monLivre.getSections() pour obtenir la liste des sections actuelles
            // Assurez-vous que la section 1 ne peut pas être modifiée
        } else {
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
