/**
 * 
 */
package model;

/**
 * 
 */
public class Utilisateur {
	
	protected String nom; //nom propre de la personne
	protected int id;
	protected String nomUtilisateur; // nom d'usage dans le systeme
	

	
	
	
	public Utilisateur(String nom) {
		super();
		this.nom = nom; 
	}

	public Utilisateur() {
		super();
	}

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

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	
	
	
}
