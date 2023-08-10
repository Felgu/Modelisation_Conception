package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import _TimeLogV01.Main;
import model.Activite;
import model.DetailProjetDiscipline;
import model.Discipline;
import model.EmployeProjet;
import model.Projet;

public class EmployeService extends ResourceService {

	private int idEmploye;

	public EmployeService(int idEmploye) {
		this.idEmploye = idEmploye;
	}

	// Menu pour la première fois avec le nom
	public void menuEmploye(String name) throws IOException {
		System.out.println("** Bienvenue " + name + " sur TimeLog **");
		this.menuPrincipaleEmploye();
	}

	void menuPrincipaleEmploye() throws IOException {
		System.out.println("\n-- Menu employé --\n");
		System.out.println("1. Commencer une activité");
		System.out.println("2. Consulter mes heures travaillées");
		System.out.println("0. Se deconnecter");

		try {

			int nbrChosi = Integer
					.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu."));

			switch (nbrChosi) {
			case 1:
				this.commencerActivite(true);
				break;

			default:
				System.out.println("Veuillez entrer un nombre indiqué au menu\n");
				break;

			}

		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre indiqué au menu\n");
			menuPrincipaleEmploye();
		}
	}

	private boolean commencerActivite(boolean estDeconnecter) throws IOException {
		
		if (estDeconnecter) {
			this.menuActiviteEncours(true);
			return false;
		}

		List<Projet> projets = (List<Projet>) this.lireLesDonnees("projets", Projet.class);
		List<Discipline> disciplines = (List<Discipline>) this.lireLesDonnees("disciplines", Discipline.class);

		List<EmployeProjet> employeProjets = (List<EmployeProjet>) this.lireLesDonnees("employeProjets",
				EmployeProjet.class);

		List<Integer> recupererIdsProjetEmploye = employeProjets.stream()
				.filter(employeProjet -> employeProjet.getIdEmploye() == this.idEmploye).map(EmployeProjet::getIdProjet)
				.collect(Collectors.toList());

		projets = projets.stream().filter(_projets -> recupererIdsProjetEmploye.contains(_projets.getIdProjet()))
				.collect(Collectors.toList());

		// Boucle pour lister les projets
		projets.forEach(projets_ -> System.out.println(projets_.getIdProjet() + " " + projets_.getNomProjet()));

		int choixProjet = Integer.parseInt(recupererLesEntree("Veuillez chosir un projet"));

		// verifier si le projet choisi existe
		if (!projets.stream().filter(projet -> projet.getIdProjet() == choixProjet).findFirst().isPresent()) {

			System.out.println("Veuillez entrer l'ID comme affiché");

			if (recupererLesEntree("Appuyer sur entrer pour rependre") != null) {
				commencerActivite(false);
				return false;
			}
		}

		disciplines.forEach(disciplines_ -> System.out.println(disciplines_.getIdDiscipline() + " " + disciplines_.getNom()));

		int choixDiscipline = Integer.parseInt(recupererLesEntree("Veuillez chosir une discipline"));

		// verifier si le projet choisi existe
		if (!disciplines.stream().filter(disciplines_ -> disciplines_.getIdDiscipline() == choixDiscipline).findFirst()
				.isPresent()) {

			System.out.println("Veuillez entrer l'ID de disciple comme affiché");

			if (recupererLesEntree("Appuyer sur entrer pour rependre") != null) {
				commencerActivite(false);
				return false;
			}
		}

		List<Activite> activites = (List<Activite>) this.lireLesDonnees("activites", Activite.class);
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this.lireLesDonnees("detailProjetDisciplines", DetailProjetDiscipline.class);
		
		int idDetailProjet = detailProjetDisciplines.stream()
				.filter(detail -> detail.getIdProjet() == choixProjet && detail.getIdDiscpline() == choixDiscipline)
				.findFirst().get().getIdDetailProjetDiscipline();

		activites.add(new Activite(this.idEmploye, idDetailProjet, LocalDate.now().toString(),
				LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))));
		this.modifierDonnee("activites", activites);

		System.out.println("** L'activité a débuté à " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")) + "... **");
		this.menuActiviteEncours(false);
		
		return true;
	}

	private boolean menuActiviteEncours(boolean estDeconnecter) throws IOException {
		
		List<Activite> activites = (List<Activite>) this.lireLesDonnees("activites", Activite.class);
		
		Activite activite = activites.stream().filter(activite_ ->activite_.getHeureFin() == null).findFirst().isPresent() ? activites.stream().filter(activite_ ->activite_.getHeureFin() == null).findFirst().get() : null;
		
		if (activite == null) {
			this.commencerActivite(false);
			return false;
		}
		
		if (activite != null && estDeconnecter) {
			System.out.println("\n1. Finir l'activité commencé à " +activite.getHeureDebut());
			System.out.println("2. Consulter mes heures travaillées");
		} else {
			System.out.println("1. Consulter mes heures travaillées");
		}
		System.out.println("0. Se deconnecter");
		
		int choix = Integer.parseInt(recupererLesEntree("Veuillez chosir une option"));
		
		try {
			
			if (!estDeconnecter) {
				switch (choix) {
				case 1:	System.out.println("TETS ");break;
				case 0:	new Main().menuInitiation(); ;break;
				default: System.out.println("Entre les obtions proposées"); menuActiviteEncours(estDeconnecter);
				}
			}else {
				switch (choix) {
				case 1:	System.out.println("TETS "); break;
				case 0:	new Main().menuInitiation(); ;break;
				default: System.out.println("Entre les obtions proposées"); menuActiviteEncours(estDeconnecter);
				}
			}
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
		}
		
		if (choix != 0) {
			
		}
		System.out.println("Veuillez entre une valeur au menu");
		menuActiviteEncours(estDeconnecter);
		return true;
	}

	/**
	 * 
	*/
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
