package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import model.DetailProjetDiscipline;
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

			int nbrChosi = Integer.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu de rapport."));

			switch (nbrChosi) {
			
			case 1 : rapportEtatProjet();break;

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
		
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this.resourceService.lireLesDonnees("detailProjetDisciplines", Projet.class);
		
		detailProjetDisciplines = detailProjetDisciplines.stream().filter(detail->detail.getIdProjet() == idProjet).collect(Collectors.toList());

		

		return true;
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
