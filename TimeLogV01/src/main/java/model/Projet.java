package model;

import java.util.Date;
 
public class Projet {
	
	private int idProjet;
	private Date dateFin; // date de fin estimé
	private String nomProjet;
	private String statut;	

	 private static int lastProjectId = 0;

	public Projet(String nomProjet) {
		
		this.nomProjet = nomProjet;
		this.idProjet = ++lastProjectId;
		statut="Début";
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public static int getLastProjectId() {
		return lastProjectId;
	}

	public static void setLastProjectId(int lastProjectId) {
		Projet.lastProjectId = lastProjectId;
	}
	 
	
	
	 
}


