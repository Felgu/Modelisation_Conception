import java.util.Scanner;

class MenuDiscipline {
    private Scanner scanner;
    private String projetChoisi;

    public MenuDiscipline(Scanner scanner, String projetChoisi) {
        this.scanner = scanner;
        this.projetChoisi = projetChoisi;
    }

    public void displayMenu() {
        System.out.println("\n++++++++++++++++++++++++++ \t % -- Menu Discipline -- % \t +++++++++++++++++++++++++++\n" + projetChoisi + ":");
        // Simulation de disciplines disponibles pour le projet choisi
        System.out.println("Disciplines disponibles :");
        System.out.println("1. Design1");
        System.out.println("2. Design2");
        System.out.println("3. Implementation");
        System.out.println("4. Test");
        System.out.println("5. Deploiement");
        System.out.println("6. Revenir au menu Choisir Projet");
        System.out.print("\nChoisissez une option : ");
        int disciplineChoice = scanner.nextInt();

        switch (disciplineChoice) {
            case 1:
                commencerTravail("Design1");
                break;
            case 2:
                commencerTravail("Design2");
                break;
            case 3:
                commencerTravail("Implementation");
                break;
            case 4:
                commencerTravail("Test");
                break;
            case 5:
                commencerTravail("Deploiement");
                break;
            case 6:
                System.out.println("Retour au menu Choisir Projet.");
                break;
            default:
                System.out.println("Option invalide, veuillez choisir à nouveau.");
        }
    }

    private void commencerTravail(String disciplineChoisie) {
        System.out.println("Commencer le travail sur la discipline " + disciplineChoisie + " du projet " + projetChoisi);
        // Ajouter ici la logique pour commencer le travail sur la discipline et le projet choisis
    }
}