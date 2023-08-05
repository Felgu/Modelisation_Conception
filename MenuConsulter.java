import java.util.Scanner;

public class MenuConsulter {
  
  private Scanner scanner;
  private Employe employe;

    public MenuConsulter(Scanner scanner, Employe employe) {
        this.scanner = scanner;
    }
  private void consulterSousMenu() {
    int consulterChoice;
    do {
        System.out.println("Sous-menu Consulter:");
        System.out.println("1. Consulter nombre d'heures travaillees de base et supplementaires");
        System.out.println("2. Revenir au menu Employe");
        System.out.print("Choisissez une option : ");
        consulterChoice = scanner.nextInt();

        switch (consulterChoice) {
            case 1:
                employe.consulterHeuresTravaillees(scanner);
                break;
            case 2:
                System.out.println("Retour au menu Employe.");
                break;
            default:
                System.out.println("Option invalide, veuillez choisir à nouveau.");
        }
    } while (consulterChoice != 2);
}
}
