import java.util.Scanner;

class MenuProjet {
    private Scanner scanner;

    public MenuProjet(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\n---------------------------- \t ? -- Menu Projet -- ? \t -----------------------------");
        // Simulation de projets disponibles
        System.out.println("Projets disponibles :");
        System.out.println("1. Projet1");
        System.out.println("2. Projet2");
        System.out.println("3. Revenir au menu Commencer Activite");
        System.out.print("\nChoisissez une option : ");
        int projetChoice = scanner.nextInt();

        switch (projetChoice) {
            case 1:
                MenuDiscipline menuChoisirDisciplineProjet1 = new MenuDiscipline(scanner, "Projet1");
                menuChoisirDisciplineProjet1.displayMenu();
                break;
            case 2:
                MenuDiscipline menuChoisirDisciplineProjet2 = new MenuDiscipline(scanner, "Projet2");
                menuChoisirDisciplineProjet2.displayMenu();
                break;
            case 3:
                System.out.println("Retour au menu Commencer Activite.");
                break;
            default:
                System.out.println("Option invalide, veuillez choisir à nouveau.");
        }
    }
}
