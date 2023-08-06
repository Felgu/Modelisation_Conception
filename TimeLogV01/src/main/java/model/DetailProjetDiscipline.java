/**
 * 
 */
package model;

/**
 *  cette classe reprensent l'associate d'un projet à une ou plusiers discpline
 */
public class DetailProjetDiscipline {

	private int idDetailProjetDiscipline;
	private int idProjet;
	private int idDiscpline;
	private String etat; // etat d'avancement
	private double budget; // montant prevu pour une discpline dans un projet	
 
	private static int lastDetaild = 0;
	
	public DetailProjetDiscipline(int idProjet, int idDiscpline, double budget) { 
		this.idProjet = idProjet;
		this.idDiscpline = idDiscpline;
		this.budget = budget;
		this.idDetailProjetDiscipline= ++lastDetaild;
	}



	public DetailProjetDiscipline() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getIdDetailProjetDiscipline() {
		return idDetailProjetDiscipline;
	}
	public void setIdDetailProjetDiscipline(int idDetailProjetDiscipline) {
		this.idDetailProjetDiscipline = idDetailProjetDiscipline;
	}
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	public int getIdDiscpline() {
		return idDiscpline;
	}
	public void setIdDiscpline(int idDiscpline) {
		this.idDiscpline = idDiscpline;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
	
}


