
class Employe {
  //les attributs
  String nom;
  int numero;
  double dateDebut;
  double dateFin;
  double dateEmbauche;
  double dateDepart;
  int numeroAssuranceSocial;
  int poste;

  //les constructeurs
  Employe(String nom, int n){
    this.nom = nom;
    this.numero = n;
  }

  //les getters et setters
  public String getNom(){
    return this.nom;
  }
  public int getNumero(){
    return this.numero;
  }
  public double getDateDebut(){
    return dateDebut;
  }
  public double getDateFin(){
    return dateFin;
  }

  //les methodes

}