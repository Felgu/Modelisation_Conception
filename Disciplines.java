enum Disciplines {
    //les attributs
    DESIGN1("design1 (haut niveau)"),
    DESIGN2("design2 (détaillé)"),
    IMPLEMENTATION("implémentation"),
    TEST("test"),
    DEPLOIEMENT("déploiement");
    
    private final String label;
  
    //le constructeur
    Disciplines(String label){
      this.label = label;
    }
    
    //les getters et setters
    public String getEtat(){
      return label;
    } 
}