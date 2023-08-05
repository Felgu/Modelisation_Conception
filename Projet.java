 import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

class Projet {
 //les attributs
  private int numeroIdentification;
  private String nom;
  private Date dateDebut;
  private Date dateFin;
  double nombreHeures;
  private double nombreHeuresBudgetees;
  private String description;
  private List<Disciplines> disciplines;

  //le constructeur
  Projet(String nom, int ID){
    this.nom = nom;
    this.numeroIdentification = ID;
  }
  public Projet (String nom, int id, Date dateDebut, Date dateFin, double nombreHeuresBudgetees, String description) {
    this.nom = nom;
    this.numeroIdentification = id;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
    this.nombreHeuresBudgetees = nombreHeuresBudgetees;
    this.description = description;
    this.disciplines = new ArrayList<>();
  }
  //les getters et seters
  public String getNom(){
    return this.nom;
  }
  public void setNom(String nom){
    this.nom = nom;
  }
  public int getNumeroIdentification(){
    return numeroIdentification;
  }
  public void setNumeroIdentification(int numeroIdentif){
  this.numeroIdentification = numeroIdentif;
  }
  public Date getDateDebut(){
    return dateDebut;
  }
  public void setDateDebut(Date dateDebut){
    this.dateDebut = dateDebut;
  }
  public Date getDateFin(){
    return dateFin;
  }
  public void setDateFin(Date dateFin){
    this.dateFin = dateFin;
  }
  public double getNombreHeures(){
    return nombreHeures;
  }
  public void setNombreHeuresBudgetees(double nombreHeuresBudgetees){
    this.nombreHeuresBudgetees = nombreHeuresBudgetees;
  }

  public String getDescription(){
    return this.description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public List<Disciplines> getDisciplines(){
    return disciplines;
  }
  public void setDisciplines(List<Disciplines> disciplines) {
    this.disciplines = disciplines;
  }

  //les methodes
  public void addDiscipline(Disciplines discipline) {
    if (!disciplines.contains(discipline)) {
      disciplines.add(discipline);
    }
  }
  //afficher toutes les info du projet
  public void afficherProjet(){
    System.out.println("\n########################## Projet:   " + nom +" #############\n");
    System.out.println("1. ID du projet: " + numeroIdentification);
    System.out.println("2. Date de debut: " + dateDebut);
    System.out.println("3. Date de fin: " + dateFin);
    System.out.println("4. Heures budgetees: " + nombreHeuresBudgetees);
    List<Disciplines> disciplines = getDisciplines();
    System.out.println("5. Disciplines associees: ");
    for (Disciplines discip : disciplines) {
      System.out.println("\t\t\t_ " + discip.getEtat());
    }
    System.out.println("\n########################  $ Fin $ ###########################\n");

  }
  public double getHeuresTravailleesSupplementaires() {
    return 0;
  }
  public boolean estDansPeriode(String dateDebut2, String dateFin2) {
    return false;
  }
}