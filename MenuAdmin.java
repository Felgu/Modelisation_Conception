import java.util.Scanner;

public class MenuAdmin {
  
  private Scanner scanner;
  public MenuAdmin(Scanner scanner) {
    this.scanner = scanner;
  }

  public void displayMenu() {
    int adminChoice;
    do {
            System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@ \t -- Menu Admin -- \t@@@@@@@@@@@@@@@@@@@@@@@@@@\n");
            System.out.println("1. Creer Employe");
            System.out.println("2. Changer Mot de Passe");
            System.out.println("3. Supprimer Employe");
            System.out.println("4. Creer Projet");
            System.out.println("5. Supprimer Projet");
            System.out.println("6. Assigner Projet");
            System.out.println("7. Se deconnecter");
            System.out.print("\nChoisissez une option : ");
            adminChoice = scanner.nextInt();

      switch (adminChoice) {
                case 1:
                    // Logique pour la fonctionnalité "Creer Employe"
                    System.out.println("Fonctionnalite Creer Employe");
                    break;
                case 2:
                    // Logique pour la fonctionnalité "Changer Mot de Passe"
                    System.out.println("Fonctionnalite Changer Mot de Passe");
                    break;
                case 3:
                    // Logique pour la fonctionnalité "Supprimer Employe"
                    System.out.println("Fonctionnalite Supprimer Employe");
                    break;
                case 4:
                    // Logique pour la fonctionnalité "Creer Projet"
                    System.out.println("Fonctionnalite Creer Projet");
                    break;
                case 5:
                    // Logique pour la fonctionnalité "Supprimer Projet"
                    System.out.println("Fonctionnalite Supprimer Projet");
                    break;
                case 6:
                    // Logique pour la fonctionnalité "Assigner Projet"
                    System.out.println("Fonctionnalite Assigner Projet");
                    break;
                case 7:
                    System.out.println("Deconnexion de l'admin.");
                    break;
                default:
                    System.out.println("Option invalide, veuillez choisir à nouveau.");
            }
        } while (adminChoice != 7);
    }
}