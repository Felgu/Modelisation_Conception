import java.util.Scanner;

class MenuEmploye {
    private Scanner scanner;
    //private Employe employe;

    public MenuEmploye(Scanner scanner ){
        this.scanner = scanner;
        //this.employe = employe;
    }
    public void displayMenu() {
      int employeChoice;
      do {
          System.out.println("\n^^^^^^^^^^^^^^^^^^^^^^^^^^ \t $ Menu Employe $ \t ^^^^^^^^^^^^^^^^^^^^^^^^^^^^ \n");
          System.out.println("1. Commencer Activite");
          System.out.println("2. Consulter");
          System.out.println("3. Se deconnecter");
          System.out.print("\nChoisissez une option : ");
          employeChoice = scanner.nextInt();

          switch (employeChoice) {
              case 1:
                  MenuCommencerActivite menuCommencerActivite = new MenuCommencerActivite(scanner);
                  menuCommencerActivite.displayMenu();
                  break;
              case 2:
                  // Logique pour la fonctionnalité "Consulter"
                  System.out.println("Fonctionnalite Consulter");
                  break;
              case 3:
                  System.out.println("Deconnexion de l'employe.");
                  break;
              default:
                  System.out.println("Option invalide, veuillez choisir à nouveau.");
          }
      } while (employeChoice != 3);
  }
}