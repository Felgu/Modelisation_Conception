import java.util.Scanner;

class MenuCommencerActivite {
    private Scanner scanner;

    public MenuCommencerActivite(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        int commencerActiviteChoice;
        do {
            System.out.println("\n************************** \t ! Menu Activite !\t ***************************\n");
            System.out.println("1. Choisir Projet");
            System.out.println("2. Revenir au menu Employe");
            System.out.print("\nChoisissez une option : ");
            commencerActiviteChoice = scanner.nextInt();

            switch (commencerActiviteChoice) {
                case 1:
                    MenuProjet menuChoisirProjet = new MenuProjet(scanner);
                    menuChoisirProjet.displayMenu();
                    break;
                case 2:
                    System.out.println("Retour au menu Employe.");
                    break;
                default:
                    System.out.println("Option invalide, veuillez choisir à nouveau.");
            }
        } while (commencerActiviteChoice != 2);
    }
}