package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

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
				this.commencerActivite();
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

	private void commencerActivite() throws IOException {
		
		List<Projet> projets = (List<Projet>) this.lireLesDonnees("projets", Projet.class);

		List<EmployeProjet> employeProjets = (List<EmployeProjet>) this.lireLesDonnees("employeProjets", EmployeProjet.class);
		
		List<Integer> recupererIdsProjetEmploye = employeProjets.stream().filter(employeProjet -> employeProjet.getIdEmploye() == this.idEmploye).map(EmployeProjet::getIdProjet).collect(Collectors.toList());
		
		projets = projets.stream().filter(_projets -> recupererIdsProjetEmploye.contains(_projets.getIdProjet())).collect(Collectors.toList());

		//Boucle
		projets.forEach(projets_ -> System.out.println(projets_.getIdProjet()+" " +projets_.getNomProjet()));
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
