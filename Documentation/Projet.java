class Projet {
  //les attributs
  int numeroIdentification;
  String nom;
  Disciplines descipline;
  double dateDebut;
  double dateFin;
  double nombreHeures;

  //le constructeur
  Projet(String nom, int ID){
    this.nom = nom;
    this.numeroIdentification = ID;
  }

  //les getters et seters
  public String getNom(){
    return this.nom;
  }
  public int getNumeroIdentification(){
    return numeroIdentification;
  }
  public double getDateDebut(){
    return dateDebut;
  }
  public double getDateFin(){
    return dateFin;
  }
  public double getNombreHeures(){
    return nombreHeures;
  }

  //les methodes


}