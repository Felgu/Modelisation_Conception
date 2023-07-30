/**
 * 
 */
package model;

import java.util.Date;

/**
 * 
 */
public class Employe extends Utilisateur{
	
	private int id;
	private String poste;
	private Date dateDepart;
	private int npe = 2; // nombre de projet par employe par defaut
	private String nas; // numero d'assurance sociale
	private int idTauxHoraire; 
}
