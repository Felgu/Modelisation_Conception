enum Disciplines {
  //les attributs
  DESIGN1(""),
  DESIGN2(""),
  IMPLEMENTATION(""),
  TEST(""),
  DEPLOIEMENT("");
  private String etat;

  //le constructeur
  Disciplines(String etat){
    this.etat = etat;
  }
  
  //les getters et setters
  public String getEtat(){
    return etat;
  }
  public void setEtat(String e){
    this.etat = e;
  }

}