package model;

import java.time.LocalTime;
import java.util.Date;

public class Activite {
	
	private int idActivite;
	private int idEmploye;
	private int idDetailProjet; // fait reference à la classe detail projet
	private Date dateDebut;
	private LocalTime heureDebut;
	private LocalTime heureFin; 

}
