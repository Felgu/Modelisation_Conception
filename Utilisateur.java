
public class Utilisateur {
   //les attributs
  protected String nom;
  protected int id;
  protected String nomUsager;

    //le constructeur
  public Utilisateur() {}
    
  public Utilisateur (String nom, int id, String nomUsager) {
    this.nom = nom;
    this.id = id;
    this.nomUsager = nomUsager;
  }
  public Utilisateur(String nom, int id){
    this.nom = nom;
    this.id = id;
  }
   public Utilisateur(String nom){
    this.nom = nom;
  }
    //les getters et setters
  public String getNom() {
    return nom;
  }
  public void setNom(String nom) {
    this.nom = nom;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNomUsager() {
    return nomUsager;
  }
  public void setNomUsager(String user) {
    this.nomUsager = user;
  }
  //les methodes, fonctions
    
  public void seConnecter( String nomUser, String passwrd, boolean estAdmin) {
    if (nomUser.equals(nomUsager)) {
    	if (estAdmin) {
    		System.out.println("Connexion reussi en tant qu'administrateur.");
    	} else {
    		System.out.println("Connexion reussi en tant qu'employe.");
    	}
    } else {
    	System.out.println("Nom d'utilisateur incorrect.");
    }
  }   
}