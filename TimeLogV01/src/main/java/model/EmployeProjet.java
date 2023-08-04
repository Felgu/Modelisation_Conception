/**
 * 
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Classe associative dans laquelle on definit le(s) projet(s) assigné à l'employé 
 */
public class EmployeProjet {

	private int idEmploye;
	private int idProjet;
	private String dateAssignee;
	 
	 
	public EmployeProjet(int idEmploye, int idProjet) {
		super();
		this.idEmploye = idEmploye;
		this.idProjet = idProjet;
		this.dateAssignee = formatDate();
	}
	 
	
	public EmployeProjet() {}



	public String formatDate() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		return localDate.format(formatter);
	}
	
	
	public String getDateAssignee() {
		return dateAssignee;
	}


	public void setDateAssignee(String dateAssignee) {
		this.dateAssignee = dateAssignee;
	}


	public int getIdEmploye() {
		return idEmploye;
	}
	public void setIdEmploye(int idEmploye) {
		this.idEmploye = idEmploye;
	}
	public int getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}
	
	
	
	
}
