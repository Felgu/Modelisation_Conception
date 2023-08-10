import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

class Employe extends Utilisateur {
  //les attributs
  private Date dateEmbauche;
  private Date dateDepart;
  private String posteTravail;
  private String numeroAssuranceSociale;
  private int NPE = 2;
  private double tauxHoraireDeBase;
  private double tauxHoraireSupplement;
  private static HashMap<String, String> employes = new HashMap<>();
  private List<Projet> projetsAssignes;
  private List<Projet> listeProjets; 

  //les constructeurs
  Employe(String nom, int id,int NPE,  String nomUsager, double tauxHoraireSupplement, double tauxHoraireBase, Date dateEmbauche, Date dateDepart, String NAS, String poste){
    super(nom, id, nomUsager);
    this.posteTravail = poste;
    this.dateDepart = dateDepart;
    this.tauxHoraireDeBase = tauxHoraireBase;
    this.numeroAssuranceSociale = NAS;
    this.tauxHoraireSupplement = tauxHoraireSupplement;
    this.NPE = NPE;
  }
  public Employe(String nom, int id){
    super(nom, id);
  }

  public Employe(int i, String string, String string2, String string3, String string4, String string5, int j,
      double d) {
  }
  	public String formatDate() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDate localDate = LocalDate.now();
		return localDate.format(formatter);
	}
  //les getters et setters
  public String getNom(){
    return this.nom;
  }
  public int getid(){
    return this.id;
  }
  public int getNPE(){
    return NPE;
  }
  public Date getDateDepart(){
    return dateDepart;
  }
  public Date getDateEmbauch(){
    return dateEmbauche;
  }
  public String getNumeroAssuranceSocial(){
    return this.numeroAssuranceSociale;
  }

  public String getPosteTravail(){
    return this.posteTravail;
  }

  public void setNumeroAssuranceSociale(String numeroAssuranceSocial){
    this.numeroAssuranceSociale = numeroAssuranceSocial;
  }

  public void setDateEmbauche(Date dateEmbauche){
    this.dateEmbauche = dateEmbauche;
  }

  public void setNom(String nom){
    this.nom = nom;
  }

  public void setId(int id){
    this.id = id;
  }
  public void setNPE(int NPE){
    this.NPE = NPE;
  }

  public void setPosteTravail(String posteTravail){
    this.posteTravail = posteTravail;
  }

  public void setDateDepart(Date dateDepart){
    this.dateDepart = dateDepart;
  }

  public void setTauxHoraireBase(double tauxHoraireBase){
    this.tauxHoraireDeBase = tauxHoraireBase;
  }

  public void setTauxHoraireSupplem(double tauxHoraireSupplem){
    this.tauxHoraireSupplement = tauxHoraireSupplem;
  }
  //les methodes
  public static boolean authentifierEmploye(Scanner scanner) {
    System.out.println("\nAuthentification de l'employe :");
    System.out.print("\t\tNom d'utilisateur : ");
    String nomUtilisateur = scanner.next();
    System.out.print("\t\t\tID : ");
    String id = scanner.next();

    // Vérifier si l'employé existe dans la liste et si l'ID correspond
    return employes.containsKey(nomUtilisateur) && employes.get(nomUtilisateur).equals(id);
  }

  public void ajouterProjetAssigne(Projet projet) {
    projetsAssignes.add(projet);
  }

  public void retirerProjetAssigne(Projet projet) {
    projetsAssignes.remove(projet);
  }

  public void consulterHeuresTravaillees(Scanner scanner) {
    System.out.println("Veuillez saisir la période pour laquelle vous souhaitez consulter les heures travaillées.");
    System.out.print("Date de début (format : jj/mm/aaaa HH:mm) : ");
    String dateDebut = scanner.next();
    System.out.print("Date de fin (format : jj/mm/aaaa HH:mm) : ");
    String dateFin = scanner.next();

    // Appeler une méthode pour calculer le nombre d'heures travaillées de base et supplémentaires
    double heuresTravailleesBase = calculerHeuresTravailleesBase(dateDebut, dateFin);
    double heuresTravailleesSupplementaires = calculerHeuresTravailleesSupplementaires(dateDebut, dateFin);

    System.out.println("Nombre d'heures travaillées de base pour la période " + dateDebut + " à " + dateFin + " : " + heuresTravailleesBase);
    System.out.println("Nombre d'heures supplémentaires travaillées pour la période " + dateDebut + " à " + dateFin + " : " + heuresTravailleesSupplementaires);
}

// Méthode pour calculer le nombre d'heures travaillées de base pour une période spécifiée
private double calculerHeuresTravailleesBase(String dateDebut, String dateFin) {
  double heuresBase = 0.0;
  for (Projet projet : projetsAssignes) {
    if (projet.estDansPeriode(dateDebut, dateFin)) {
      heuresBase += projet.getHeuresTravailleesSupplementaires();
    }
  }
  return heuresBase;
}

// Méthode pour calculer le nombre d'heures supplémentaires travaillées pour une période spécifiée
private double calculerHeuresTravailleesSupplementaires(String dateDebut, String dateFin) {
  double heuresSupplementaires = 0.0;
  for (Projet projet : projetsAssignes) {
    if (projet.estDansPeriode(dateDebut, dateFin)) {
      heuresSupplementaires += projet.getHeuresTravailleesSupplementaires();
    }
  }
  return heuresSupplementaires;
}

}