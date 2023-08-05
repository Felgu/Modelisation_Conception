
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
  private static HashMap<String, String> employes = new HashMap<>();
  private static HashMap<String, String> admins = new HashMap<>();

  public static void main(String[] args) {
    // Ajouter quelques employés et administrateurs pour les besoins de l'exemple
    employes.put("Omar", "123");
    employes.put("Pires", "234");
    employes.put("Madona", "345");
    admins.put("Jamal", "987");

    Scanner scanner = new Scanner(System.in);

    int mainChoice;
    do {
      // Affichage du Menu Principal
      System.out.println("############################## \t - Menu Principal - \t #################################\n");
      System.out.println("1. Se connecter comme Employe");
      System.out.println("2. Se connecter comme Admin");
      System.out.println("3. Quitter");
      System.out.print("\nChoisissez une option : ");
      mainChoice = scanner.nextInt();

      switch (mainChoice) {
        case 1:
          if (authentifierEmploye(scanner)) {
            employeMenu();
          } else {
            System.out.println("Echec de l'authentification de l'employé.");
          }
          break;
        case 2:
          if (authentifierAdmin(scanner)) {
            adminMenu();
          } else {
            System.out.println("Echec de l'authentification de l'admin.");
          }
          break;
        case 3:
          System.out.println("Bon travail!");
                    break;
        default:
          System.out.println("Option invalide, veuillez choisir à nouveau.");
            }
      } while (mainChoice != 3);

      scanner.close();
    }

    public static boolean authentifierEmploye(Scanner scanner) {
      System.out.println("\nAuthentification de l'employe :");
      System.out.print("\t\tNom d'utilisateur : ");
      String nomUtilisateur = scanner.next();
      System.out.print("\t\t\t\tID : ");
      String id = scanner.next();

      // Vérifier si l'employé existe dans la liste et si l'ID correspond
      return employes.containsKey(nomUtilisateur) && employes.get(nomUtilisateur).equals(id);
    }

    public static boolean authentifierAdmin(Scanner scanner) {
      System.out.println("\nAuthentification de l'admin :");
      System.out.print("\t\tNom d'utilisateur : ");
      String nomUtilisateur = scanner.next();
      System.out.print("\t\tMot de passe : \t");
      String motDePasse = scanner.next();

      // Vérifier si l'admin existe dans la liste et si le mot de passe correspond
      return admins.containsKey(nomUtilisateur) && admins.get(nomUtilisateur).equals(motDePasse);
    }

    // ... (Les autres méthodes restent inchangées)
    public static void employeMenu() {
      Scanner scanner = new Scanner(System.in);
      int employeChoice;
      do {
          // Affichage du Menu Employe
          System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ \t - Menu Employe - \t $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n");
          System.out.println("1. Commencer Activite");
          System.out.println("2. Consulter");
          System.out.println("3. Se deconnecter");
          System.out.print("\nChoisissez une option : ");
          employeChoice = scanner.nextInt();

          switch (employeChoice) {
              case 1:
                  choisirProjetEtDiscipline();
                  break;
              case 2:
                  consulterInformations();
                  break;
              case 3:
                  System.out.println("Deconnexion de l'employe.");
                  break;
              default:
                  System.out.println("Option invalide, veuillez choisir à nouveau.");
          }
      } while (employeChoice != 3);
      scanner.close();
  }

  public static void choisirProjetEtDiscipline() {
    Scanner scan = new Scanner(System.in);
      // Logique pour choisir le projet et la discipline
    System.out.println("\nFonctionnalite Commencer Activite : Choisir Projet et Discipline");
      // Ajoutez votre code ici pour choisir le projet et la discipline
    HashMap<String, String> projets = new HashMap<>();
    projets.put("TimeLog", "Design 1");
    projets.put("DepenseCalo", "Design 2");

        // Affichage des projets disponibles
    System.out.println("\nProjets disponibles :\n");
    for (String projet : projets.keySet()) {
      System.out.println(projet);
    }

        // L'utilisateur choisit un projet
    System.out.print("\nChoisissez un projet : \n");
    String projetChoisi = scan.next();

        // Vérifier si le projet choisi existe dans la liste
    if (!projets.containsKey(projetChoisi)) {
      System.out.println("Projet invalide, retour au menu Employe.");
      return;
    }

        // Affichage des disciplines disponibles pour le projet choisi
    String disciplineChoisie = projets.get(projetChoisi);
    System.out.println("\nDiscipline disponible pour le projet " + projetChoisi + " : " + disciplineChoisie + " \n");

        // L'utilisateur choisit une discipline
    System.out.print("\nChoisissez une discipline : \n");
    String disciplineUtilisateur = scan.next();

        // Vérifier si la discipline choisie correspond à celle du projet
    if (!disciplineUtilisateur.equals(disciplineChoisie)) {
      System.out.println("Discipline invalide, retour au menu Employe.");
      return;
    }

        // Le travail sur la discipline et le projet choisis peut maintenant commencer
    System.out.println("\nCommencer le travail sur la discipline " + disciplineUtilisateur + " du projet " + projetChoisi + " \n");
    scan.close();
  }

  public static void consulterInformations() {
    // Logique pour consulter les informations
    System.out.println("Fonctionnalite Consulter");
    // Ajoutez votre code ici pour consulter les informations
  }

  public static void adminMenu() {
    Scanner scan = new Scanner(System.in);
    int adminChoice;
    do {
          // Affichage du Menu Admin
      System.out.println("\n%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% \t Menu Admin: \t %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%\n");
      System.out.println("1. Creer Employe");
      System.out.println("2. Changer Mot de Passe");
      System.out.println("3. Supprimer Employe");
      System.out.println("4. Creer Projet");
      System.out.println("5. Supprimer Projet");
      System.out.println("6. Assigner Projet");
      System.out.println("7. Se deconnecter");
      System.out.print("\nChoisissez une option : ");
      adminChoice = scan.nextInt();

      switch (adminChoice) {
        case 1:
          creerEmploye();
          break;
        case 2:
          changerMotDePasse();
          break;
        case 3:
          supprimerEmploye();
          break;
        case 4:
          creerProjet();
        break;
        case 5:
          supprimerProjet();
          break;
        case 6:
          assignerProjet();
          break;
        case 7:
          System.out.println("Deconnexion de l'admin.");
          break;
        default:
          System.out.println("Option invalide, veuillez choisir à nouveau.");
      }
    } while (adminChoice != 7);
    scan.close();
  }

  // méthodes pour fonctionnalité du menu Admin
  public static void creerEmploye() {
    System.out.println("Fonctionnalite Creer Employe");
  }

  public static void changerMotDePasse() {
    System.out.println("Fonctionnalite Changer Mot de Passe");
  }

  public static void supprimerEmploye() {
    System.out.println("Fonctionnalite Supprimer Employe");
  }

  public static void creerProjet() {
    System.out.println("Fonctionnalite Creer Projet");
  }

  public static void supprimerProjet() {
    System.out.println("Fonctionnalite Supprimer Projet");
  }

  public static void assignerProjet() {
    System.out.println("Fonctionnalite Assigner Projet");
  }
}