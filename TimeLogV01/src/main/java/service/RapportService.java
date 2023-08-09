package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import model.Activite;
import model.DetailProjetDiscipline;
import model.Discipline;
import model.EmployeProjet;
import model.Projet;

public class RapportService {

	private ResourceService resourceService;

	public RapportService() throws IOException {

		this.resourceService = new ResourceService();
		menuRapport();
	}

	public void menuRapport() throws IOException {

		System.out.println("1. Rapport d'état d'un projet");
		System.out.println("2. Rapport d'état global");
		System.out.println();

		try {

			int nbrChosi = Integer
					.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu de rapport."));

			switch (nbrChosi) {

			case 1:
				rapportEtatProjet();
				break;

			default:
				System.out.println("Veuillez entrer un nombre indiqué au menu\n");
				menuRapport();
				break;

			}

		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre indiqué au menu\n");
			menuRapport();
		}
	}

	// Q1
	public boolean rapportEtatProjet() throws IOException {
		List<Projet> projets = (List<Projet>) this.resourceService.lireLesDonnees("projets", Projet.class);

		for (Projet projet : projets) {
			System.out.println("" + projet.getIdProjet() + " " + projet.getNomProjet());
		}

		int idProjet = Integer.parseInt(recupererLesEntree("Entre le num du projet:"));

		// Testter si le projet existe
		if (!projets.stream().filter(projet -> projet.getIdProjet() == idProjet).findFirst().isPresent()) {
			System.out.println("** Veuillez entrer le numéro de projet affiché **");

			try {
				int choix = Integer.parseInt(recupererLesEntree("Appuyer sur 1 pour recommencer ..."));
				if (choix == 1) {
					this.rapportEtatProjet();
					return false;
				}
			} catch (NumberFormatException e) {
				System.out.println("** Veuillez entrer le numéro de projet affiché **");
				this.rapportEtatProjet();
				return false;
			}
		}
		
		String nomProjet = projets.stream().filter(projet->projet.getIdProjet() == idProjet).findFirst().get().getNomProjet();		
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this.resourceService.lireLesDonnees("detailProjetDisciplines", DetailProjetDiscipline.class);

		detailProjetDisciplines = detailProjetDisciplines.stream().filter(detail -> detail.getIdProjet() == idProjet).collect(Collectors.toList());
		
		long heures; // heures d'activité
		long min; // min d'activité

		
		System.out.println("\n** Rapport d'état "+ nomProjet + " **\n");
		
		
		for (DetailProjetDiscipline detailProjetDiscipline : detailProjetDisciplines) {

			heures = calculeNombreHeureParDisciple(detailProjetDiscipline.getIdDetailProjetDiscipline()).toHours();
			min = calculeNombreHeureParDisciple(detailProjetDiscipline.getIdDetailProjetDiscipline()).toMinutesPart();
			
			System.out.println(recupererNomDiscpline(detailProjetDiscipline.getIdDiscpline()) + " " + ""+heures + ":"+min);
			}

		//Afficher total heures
		heures = calculeNombreHeureTotalProjet(idProjet).toHours();
		min = calculeNombreHeureTotalProjet(idProjet).toMinutesPart();
		
		System.out.println("Total heures projets :" +heures + ":" + min);
		return true;
	}

	Duration calculeNombreHeureParDisciple(int idDetailProjetDiscipline) throws IOException {
		List<Activite> activites = (List<Activite>) this.resourceService.lireLesDonnees("activites", Activite.class);
		
		Duration totalDuree = activites.stream().filter(activite -> activite.getIdDetailProjet() == idDetailProjetDiscipline) .map(activite -> Duration.between(LocalTime.parse(activite.getHeureDebut()), LocalTime.parse(activite.getHeureFin()))).reduce(Duration.ZERO, Duration::plus);
		
		return totalDuree;
	}
	
	Duration calculeNombreHeureTotalProjet(int idProjet) throws IOException {
		
		List<Activite> activites = (List<Activite>) this.resourceService.lireLesDonnees("activites", Activite.class);
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this.resourceService.lireLesDonnees("detailProjetDisciplines", DetailProjetDiscipline.class);
		
		List<Integer> recupererIdsDetailProjetDisciplines = detailProjetDisciplines.stream().filter(detailProjetDiscipline -> detailProjetDiscipline.getIdProjet() == idProjet).map(DetailProjetDiscipline::getIdDetailProjetDiscipline).collect(Collectors.toList());
		
		activites = activites.stream().filter(activite -> recupererIdsDetailProjetDisciplines.contains(activite.getIdDetailProjet())).collect(Collectors.toList());
		
		
		Duration totalDuree = activites.stream().map(activite -> Duration.between(LocalTime.parse(activite.getHeureDebut()), LocalTime.parse(activite.getHeureFin()))).reduce(Duration.ZERO, Duration::plus);
		
		return totalDuree;
	}
	
	private double calculePourcentageEstimeParDiscipline(double heureTravallé,double heureBudgete) throws IOException {
		
		 double pourcentageTravaille = (heureTravallé/heureBudgete) * 100;
		 
		 return pourcentageTravaille;
	}

	String recupererNomDiscpline(int idDiscipline) throws IOException {

		List<Discipline> disciplines = (List<Discipline>) this.resourceService.lireLesDonnees("disciplines",Discipline.class);

		String nomDiscpline = disciplines.stream().filter(discipline -> discipline.getIdDiscipline() == idDiscipline).findFirst().get().getNom();
		return nomDiscpline;
	}

	private static String recupererLesEntree(String message) {
		System.out.println(message);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnString = "";
		try {
			returnString = br.readLine();
		} catch (IOException e) {
			System.out.println("Erreur lors de la lecture de la valeur");
		}
		return returnString;
	}
}
