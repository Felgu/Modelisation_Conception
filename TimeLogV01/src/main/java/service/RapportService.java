package service;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import model.Activite;
import model.DetailProjetDiscipline;
import model.Discipline; 
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
		System.out.println("3. Rapport de salaire d'un employé");
		System.out.println();

		try {

			int nbrChosi = Integer
					.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu de rapport."));

			switch (nbrChosi) {

			case 1:
				rapportEtatProjet();
				break;
			case 2:
				rapportGlobalProjet();
				break;	
				
			case 3:
				rapportSalaire();
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
		double nbrHeureEstime =  0.0;
		
		double heures; // heures d'activité 

		
		System.out.println("\n** Rapport d'état "+ nomProjet + " **\n"); //Affichage titre de raport
		
		System.out.printf("%-20s %-20s %-20s %-20s%n", "Discipline", "Nbr heure travaillé", "% Avancement", "Heures Budgétées\n");
		for (DetailProjetDiscipline detailProjetDiscipline : detailProjetDisciplines) { 
			nbrHeureEstime += detailProjetDiscipline.getNbrHeureBudgetees();
			heures = calculeNombreHeureParDisciple(detailProjetDiscipline.getIdDetailProjetDiscipline());
			System.out.printf("%-20s %-20.2f %-20.2f %-20.2f%n", recupererNomDiscpline(detailProjetDiscipline.getIdDiscpline()),heures, calculePourcentageEstime(heures, detailProjetDiscipline.getNbrHeureBudgetees()) , detailProjetDiscipline.getNbrHeureBudgetees());
			}

		//Afficher total heures 
		System.out.println("\nTotal heures travaillés : " +calculeNombreHeureTotalProjet(idProjet).toHours() + ":" +calculeNombreHeureTotalProjet(idProjet).toMinutesPart());
		
		//le pourcentage estimée d’avancement total
		System.out.printf("Pourcentage estimée d’avancement total : %2f" , this.calculePourcentageEstime(calculeNombreHeureTotalProjet(idProjet).toHours() + calculeNombreHeureTotalProjet(idProjet).toMinutesPart() / 60.0, nbrHeureEstime));
		
		String retourMenu = recupererLesEntree("\n\nAppuyer sur entrer pour retourner au menu");
		
		
		if (retourMenu != null) {
			new AdminService().menu();;
		}
		return true;
	}
	
	// Q2
		public boolean rapportGlobalProjet() throws IOException {
			List<Projet> projets = (List<Projet>) this.resourceService.lireLesDonnees("projets", Projet.class);
			String heureTotalTravailee;
			
			System.out.println("\n** Rapport global **\n");
			
			System.out.printf("%-20s %-20s %-20s%n", "Nom projet", "Nbr heure travaillé", "% Avancement");
			for (Projet projet : projets) {
				heureTotalTravailee = calculeNombreHeureTotalProjet(projet.getIdProjet()).toHours()+":"+ calculeNombreHeureTotalProjet(projet.getIdProjet()).toMinutesPart();
				 
				System.out.printf("\n%-20s %-20s %-20.2f%n", projet.getNomProjet(),heureTotalTravailee, calculePourcentageEstime(calculeNombreHeureTotalProjet(projet.getIdProjet()).toHours() + calculeNombreHeureTotalProjet(projet.getIdProjet()).toMinutesPart()/60.0,totalBudgeteProjet(projet.getIdProjet())));
						
			}
			String retourMenu = recupererLesEntree("\nAppuyer sur entrer pour retourner au menu");
			
			
			if (retourMenu != null) {
				new AdminService().menu();;
			}
			return true;
		}
		
	//Q3
		
	private void rapportSalaire() {
		
		try {
			int idEmploye = Integer.parseInt(recupererLesEntree("\n\nEntrer l'id employé"));
			//string idEmploye = Integer.parseInt(recupererLesEntree("\n\nEntrer l'id employé"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	private double totalBudgeteProjet(int idProjet) throws IOException {
	
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this.resourceService.lireLesDonnees("detailProjetDisciplines", DetailProjetDiscipline.class);
		
		return detailProjetDisciplines.stream().filter(detail -> detail.getIdProjet() == idProjet).mapToDouble(DetailProjetDiscipline::getNbrHeureBudgetees).sum();
	}
	
	double calculeNombreHeureParDisciple(int idDetailProjetDiscipline) throws IOException {
		List<Activite> activites = (List<Activite>) this.resourceService.lireLesDonnees("activites", Activite.class);
		
		Duration totalDuree = activites.stream().filter(activite -> activite.getIdDetailProjet() == idDetailProjetDiscipline) .map(activite -> Duration.between(LocalTime.parse(activite.getHeureDebut()), LocalTime.parse(activite.getHeureFin()))).reduce(Duration.ZERO, Duration::plus);
		
		return totalDuree.toHours() + totalDuree.toMinutesPart() / 60.0;
	}
	
	//total heure travaillé
	private Duration calculeNombreHeureTotalProjet(int idProjet) throws IOException {
		
		List<Activite> activites = (List<Activite>) this.resourceService.lireLesDonnees("activites", Activite.class);
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this.resourceService.lireLesDonnees("detailProjetDisciplines", DetailProjetDiscipline.class);
		
		List<Integer> recupererIdsDetailProjetDisciplines = detailProjetDisciplines.stream().filter(detailProjetDiscipline -> detailProjetDiscipline.getIdProjet() == idProjet).map(DetailProjetDiscipline::getIdDetailProjetDiscipline).collect(Collectors.toList());
		
		activites = activites.stream().filter(activite -> recupererIdsDetailProjetDisciplines.contains(activite.getIdDetailProjet())).collect(Collectors.toList());
		
		
		Duration totalDuree = activites.stream().map(activite -> Duration.between(LocalTime.parse(activite.getHeureDebut()), LocalTime.parse(activite.getHeureFin()))).reduce(Duration.ZERO, Duration::plus);
		
		return totalDuree;
	}
	
	private double calculePourcentageEstime(double heureTravallee,double heureBudgete) throws IOException {
		
		 double pourcentageTravaille = (heureTravallee/heureBudgete) * 100;
		 
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
