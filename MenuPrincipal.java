import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            System.out.println("\n######################### \t & Menu Principal & \t ########################\n");
            System.out.println("1. Se connecter comme Employe");
            System.out.println("2. Se connecter comme Admin");
            System.out.println("3. Quitter");
            System.out.print("\nChoisissez une option : ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    MenuEmploye menuEmploye = new MenuEmploye(scanner);
                    menuEmploye.displayMenu();
                    break;
                case 2:
                    MenuAdmin menuAdmin = new MenuAdmin(scanner);
                    menuAdmin.displayMenu();
                    break;
                case 3:
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option invalide, veuillez choisir à nouveau.");
            }
        } while (mainChoice != 3);

        scanner.close();
    }
}