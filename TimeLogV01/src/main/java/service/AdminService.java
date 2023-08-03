package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import _TimeLogV01.Main;
import model.Admin;

public class AdminService {

	private ResourceService resourceService;

	public AdminService() {

		this.resourceService = new ResourceService();
	}

	// Pour la première connexion
	public void menu(String nomPersonne) throws IOException {
		System.out.println("Bienvenue " + nomPersonne.toUpperCase() + "\n");

		this.menu();
	}

	public void menu() throws IOException {
		System.out.println("-- Menu Admin--");
		System.out.println("1. Créer un projet");
		System.out.println("2. Supprimer un projet");
		System.out.println("3. Ajouter un employé");
		System.out.println("4. Assigner un employé au projet");
		System.out.println("5. Ajouter une discipline au projet");
		System.out.println("6. Supprimer un employé");
		System.out.println("7. Changer le NPE d'un employé");
		System.out.println("8. Modifier le nom d'un utilisateur");
		System.out.println("9. Modifier le ID");
		System.out.println("0. Deconnecter");
		System.out.println();

		try {

			int nbrChosi = Integer
					.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu."));

			switch (nbrChosi) {

			case 0:
				this.deconnecter();
				break;
			case 8 : this.modifierNomUsagerAdmin(); break;	

			default:
				System.out.println("Veuillez entrer un nombre indiqué au menu\n");

			}

		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre indiqué au menu\n");

			menu();
		}
	}
	private void creerProjet() throws IOException {
		
		}
	private void supprimerProjet() throws IOException {
		
		}
	private void ajouterEmploye() throws IOException {
		
		}
	private void assignerProjet() throws IOException {
		
		}
	private void ajouterDisciplineProjet() throws IOException {
		
		}
	private void supprimerEmploye() throws IOException {
		
		
		}
	private void modifierNPE() throws IOException {
		
		}
	private void modifierNomUsager() throws IOException {
		
		}
	
	private void modifierID() throws IOException {
		
	}
	private void deconnecter() throws IOException {
		Main.main(null);
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

	public boolean modifierNomUsagerAdmin() throws IOException {

		List<Admin> listAdmin = (List<Admin>) this.resourceService.lireLesDonnees("admins", Admin.class);
		String nouvelNomUsage = null;

		String actuelNomUsage = recupererLesEntree("Entree le nom d'usage actuel :");

		for (Admin admin : listAdmin) {	 
			//test si ce nom existe
			if (admin.getNomUtilisateur().equals(actuelNomUsage)) {
				nouvelNomUsage = recupererLesEntree("Entree le nouveau d'usage :");				
				if (nouvelNomUsage.length() != 0) {					
					// Verifier si ce nom d'ulisateur existe deja
					for (Admin checkAdmin : listAdmin) {
						if (admin.getNomUtilisateur().equals(nouvelNomUsage)) {
							System.out.println("Ce nom d'utilsateur existe deja\n");
							this.menu();
							return false;
						}
					}
					//modifier le nom
					admin.setNomUtilisateur(nouvelNomUsage); 				
				}
				listAdmin.set(listAdmin.indexOf(admin), admin); 
				
				if(this.resourceService.modifierDonnee("admins", listAdmin)) {
					System.out.println("** Nom d'usage modifié avec succes **");
					this.menu();
				}				
				return true;
			}else {
				System.out.println("*** Nom d'usage inconnu ***");
				this.menu();
				return false;
			}
		}
 
		
		
		return true;
	}

}
