import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Admin extends Utilisateur{
  private String motDePasse;
  private int NPE = 2;
  private Map<String, Employe> listeEmployes; // Stocke les employés avec leur nom d'utilisateur comme clé
  private Map<Integer, Projet> listeProjets; // Stocke les projets avec leur ID comme clé
  private Map<String, Integer> assignationsEmployes; // Stocke le nombre de projets assignés à chaque employé

  public Admin(String nomUtilisateur, String motDePasse) {
        this.nomUsager = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.NPE = 2; // Valeur par défaut pour le nombre maximum de projets assignés
        this.listeEmployes = new HashMap<>();
        this.listeProjets = new HashMap<>();
        this.assignationsEmployes = new HashMap<>();
  }

  public void setNPE(int npe) {
        this.NPE = npe;
  }

  public void modifierNomUtilisateur(Employe employe, String nouveauNomUtilisateur) {
        // Vérifier que le nouveau nom d'utilisateur n'est pas déjà utilisé par un autre employé
        if (!listeEmployes.containsKey(nouveauNomUtilisateur)) {
            // Supprimer l'ancienne entrée de la liste et ajouter la nouvelle avec le nouveau nom d'utilisateur
            listeEmployes.remove(employe.getNomUsager());
            employe.setNomUsager(nouveauNomUtilisateur);
            listeEmployes.put(nouveauNomUtilisateur, employe);
        } else {
            System.out.println("Le nom d'utilisateur " + nouveauNomUtilisateur + " est déjà utilisé par un autre employé.");
        }
    }

  public void modifierID(Employe employe, int nouvelID) {
        employe.setId(nouvelID);
  }

  public void modifierCaracteristiquesEmploye(Employe employe, String nom, int id, Date dateEmbauche, Date dateDepart,
                                  double tauxHoraireBase, double tauxHoraireSupplem, String numeroAssuranceSociale, String posteTravail) {
    employe.setNom(nom);
    employe.setId(id);
    employe.setDateEmbauche(dateEmbauche);
    employe.setDateDepart(dateDepart);
    employe.setTauxHoraireBase(tauxHoraireBase);
    employe.setTauxHoraireSupplem(tauxHoraireSupplem);
    employe.setNumeroAssuranceSociale(numeroAssuranceSociale);
    employe.setPosteTravail(posteTravail);
  }

  public void ajouterEmploye(Employe employe) {
        // Vérifier que le nom d'utilisateur n'est pas déjà utilisé par un autre employé
        if (!listeEmployes.containsKey(employe.getNomUsager())) {
            listeEmployes.put(employe.getNomUsager(), employe);
        } else {
            System.out.println("Le nom d'utilisateur " + employe.getNomUsager() + " est déjà utilisé par un autre employé.");
        }
  }

  public void supprimerEmploye(Employe employe) {
        listeEmployes.remove(employe.getNomUsager());
  }

  public void ajouterProjet(Projet projet) {
    // Vérifier que l'ID du projet n'est pas déjà utilisé par un autre projet
    if (!listeProjets.containsKey(projet.getNumeroIdentification())) {
      listeProjets.put(projet.getNumeroIdentification(), projet);
    } else {
      System.out.println("L'ID du projet " + projet.getNumeroIdentification() + " est déjà utilisé par un autre projet.");
    }
  }

  public void supprimerProjet(Projet projet) {
        listeProjets.remove(projet.getNumeroIdentification());
  }

  public void modifierCaracteristiquesProjet(Projet projet, String nom, int id, Date dateDebut, Date dateFin, int nombreHeuresBudgetees, String description) {
    projet.setNom(nom);
    projet.setNumeroIdentification(id);
    projet.setDateDebut(dateDebut);
    projet.setDateFin(dateFin);
    projet.setNombreHeuresBudgetees(nombreHeuresBudgetees);
    projet.setDescription(description);
  }

  public void assignerProjetAEmploye(Employe employe, Projet projet) {
    // Vérifier si l'employé peut être assigné à un nouveau projet
    if (getNombreProjetsAssignes(employe) < NPE) {
      employe.ajouterProjetAssigne(projet);
    // Incrémenter le nombre de projets assignés à cet employé
      assignationsEmployes.put(employe.getNomUsager(), getNombreProjetsAssignes(employe) + 1);
    } else {
      System.out.println("L'employé " + employe.getNomUsager() + " a déjà atteint le nombre maximum de projets assignés (" + NPE + ").");
    }
  }

  public void retirerProjetAEmploye(Employe employe, Projet projet) {
    employe.retirerProjetAssigne(projet);
    // Décrémenter le nombre de projets assignés à cet employé
    assignationsEmployes.put(employe.getNomUsager(), getNombreProjetsAssignes(employe) - 1);
  }

  public int getNombreProjetsAssignes(Employe employe) {
    return assignationsEmployes.getOrDefault(employe.getNomUsager(), 0);
  }
}