package model;

public class Admin extends Utilisateur {
	
	private String motDePasse = "admin"; // admin  est le mot de passe par defaut comme indiqué dans le contrat	
	

	public Admin(String nom) {
		super(nom);
		
	}
	
	public Admin() {}


	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	
}
