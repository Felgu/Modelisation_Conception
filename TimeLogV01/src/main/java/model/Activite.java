package model;
 

public class Activite {
	
	private int idActivite;
	private int idEmploye;
	private int idDetailProjet; // fait reference à la classe detail projet
	private String dateDebut;
	private String heureDebut;
	private String heureFin;
	
	
	
	public Activite(int idEmploye, int idDetailProjet, String dateDebut, String heureDebut, String heureFin) {
		super();
		this.idEmploye = idEmploye;
		this.idDetailProjet = idDetailProjet;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	
	
	public Activite(int idEmploye, int idDetailProjet, String dateDebut, String heureDebut) {
		super();
		this.idEmploye = idEmploye;
		this.idDetailProjet = idDetailProjet;
		this.dateDebut = dateDebut;
		this.heureDebut = heureDebut;
	}


	public Activite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdActivite() {
		return idActivite;
	}
	public void setIdActivite(int idActivite) {
		this.idActivite = idActivite;
	}
	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	public int getIdDetailProjet() {
		return idDetailProjet;
	}
	public void setIdDetailProjet(int idDetailProjet) {
		this.idDetailProjet = idDetailProjet;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}
	public String getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	} 
	
	
	

}
