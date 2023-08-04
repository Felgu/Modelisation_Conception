package model;

public class Admin extends Utilisateur {
	
	private String motDePasse = "admin"; // admin  est le mot de passe par defaut comme indiqué dans le contrat	
	

	public Admin(String nom) {
		super(nom);
		this.setNomUtilisateur("admin");
	}
	
	public Admin() {}


	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public void setNomUtilisateur(String nomUtilisateur) {
		// TODO Auto-generated method stub
		super.setNomUtilisateur(nomUtilisateur);
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}
	
	
	
	
	
}
