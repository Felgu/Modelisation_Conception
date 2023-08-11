package model;
 

public class Discipline {
	//les  attributs
	private static int lastDisciplineId = 0;

	private int idDiscipline;
	private String nom;
	
	//les constructeurs
	
	public Discipline() {
		super();
	}


	public Discipline(String nom) { 
		this.nom = nom;
		this.idDiscipline=++lastDisciplineId;
	}

	//les getters et setters
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
