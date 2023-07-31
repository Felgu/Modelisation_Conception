/**
 * 
 */
package model;

import java.util.Date;

import javax.swing.text.DateFormatter;

/**
 * 
 */
public class Employe extends Utilisateur{ 
	
	private String poste;
	private Date dateDepart;
	private Date dateEmbauche;
	private int npe = 2; // nombre de projet par employe par defaut
	private String nas; // numero d'assurance sociale
	private int idTauxHoraire; 

	public Employe(String nom) {
		super(nom); 
		//dateEmbauche = new DateFormatter("dd/mm/yyyy");
	}

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public int getNpe() {
		return npe;
	}

	public void setNpe(int npe) {
		this.npe = npe;
	}

	public String getNas() {
		return nas;
	}

	public void setNas(String nas) {
		this.nas = nas;
	}

	public int getIdTauxHoraire() {
		return idTauxHoraire;
	}

	public void setIdTauxHoraire(int idTauxHoraire) {
		this.idTauxHoraire = idTauxHoraire;
	}
 
	
 
	

}
