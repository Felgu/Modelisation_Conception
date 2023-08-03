package model;
 

public class Discipline {
	
	private static int lastDisciplineId = 0;

	private int idDiscipline;
	private String nom;
	
	
	
	public Discipline() {
		super();
	}


	public Discipline(String nom) { 
		this.nom = nom;
		this.idDiscipline=++lastDisciplineId;
	}


	public int getIdDiscipline() {
		return idDiscipline;
	}


	public void setIdDiscipline(int idDiscipline) {
		this.idDiscipline = idDiscipline;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
