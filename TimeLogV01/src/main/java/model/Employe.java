/**
 * 
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 
 */
public class Employe extends Utilisateur {

	private String poste;
	private String dateDepart;
	private String dateEmbauche;
	private int npe = 2; // nombre de projet par employe par defaut
	private String nas; // numero d'assurance sociale
	private int idTauxHoraire;
	
	private static int lastEmployeId = 0;

	public Employe(String nom) {
		super(nom);
		this.dateEmbauche = formatDate();
		this.id = ++lastEmployeId;
		this.nomUtilisateur = nom+this.id;
	}
	
	

	public Employe() { 
	}



	public String formatDate() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		return localDate.format(formatter);
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {
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
