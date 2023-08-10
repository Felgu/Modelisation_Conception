/**
 * 
 */
package model;

/**
 *  cette classe definie les taux horaires qu'un employé peut avoir
 */
public class TauxHoraire {
	
	private int idTauxHoraire;
	private double tauxHoraireBase; // taux de base
	private int tauxSuppl; // taux de base supplementaire
	
	 private static int lastTauxtId = 0;	 
	 
	 
	public TauxHoraire(double tauxHoraireBase, int tauxSuppl) {
		super();
		this.tauxHoraireBase = tauxHoraireBase;
		this.tauxSuppl = tauxSuppl;
		this.idTauxHoraire = ++lastTauxtId;
	}
	
	
	
	public TauxHoraire() {}



	public int getIdTauxHoraire() {
		return idTauxHoraire;
	}
	public void setIdTauxHoraire(int idTauxHoraire) {
		this.idTauxHoraire = idTauxHoraire;
	}
	public double getTauxHoraireBase() {
		return tauxHoraireBase;
	}
	public void setTauxHoraireBase(double tauxHoraireBase) {
		this.tauxHoraireBase = tauxHoraireBase;
	}
	public int getTauxSuppl() {
		return tauxSuppl;
	}
	public void setTauxSuppl(int tauxSuppl) {
		this.tauxSuppl = tauxSuppl;
	}
	
	
}
