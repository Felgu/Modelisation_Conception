/**
 * 
 */
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import _TimeLogV01.Main;
import model.Admin;
import model.Employe;

/**
 * Cette classe gere les authentifications (Admin,Employe)
 */
public class AuthService extends ResourceService {

	public void seConnecter(boolean isAdmin) throws IOException {

		if (!isAdmin) {
			this.connectionEmploye();
		} else {
			this.connectionAdmin();
		}
	}

	private void connectionEmploye() throws IOException {

		System.out.println("-- Connexion Employe --\n");
		
		String nomUsage = recupererLesEntree("Entrée votre nom d'usager");
		String id = recupererLesEntree("Entrée votre id");

		this.employeAuth(nomUsage, Integer.parseInt(id));
	}

	private void connectionAdmin() throws IOException {

		System.out.println("-- Connexion Admin --");
		String nomUsager = recupererLesEntree("Entrée votre nom d'usager");
		String motDePasse = recupererLesEntree("Entrée votre mot de passe");

		this.adminAuth(nomUsager, motDePasse);

	}

	// comparer les entrées avec nos donnees
	private boolean adminAuth(String nomUsage, String motPasse) throws IOException {

		// recuperation de la liste des admins dans la DB
		List<Admin> admins = (List<Admin>) this.lireLesDonnees("admins", Admin.class);

		for (Admin admin : admins) {

			if (admin.getNomUtilisateur().equals(nomUsage) && admin.getMotDePasse().equals(motPasse)) {

				System.out.println();
				// Appelle Admin Service
				new AdminService().menu(admin.getNom());
				return true;
			}
		}

		System.out.println("Nom usage ou mot de passe incorrect ...\n");

		// recuper le choix de l'utisateur
		try {

			int choixUtilisateur = Integer
					.parseInt(recupererLesEntree("1.Se connecter à nouveau\n2.Menu precedent\n3.Quitter"));

			switch (choixUtilisateur) {

			case 1:
				connectionAdmin();
				break;

			case 2:
				Main.main(null);
				break;

			case 3:
				System.out.println("Aurevoir");
				break;

			default:
				System.out.println("veuillez entrer un nombre indiqué au menu");
				connectionAdmin();
				break;

			}

		} catch (NumberFormatException e) {

			System.out.println("Veuillez entrer un nombre indiqué au menu");
			new Main().main(null);
		}

		return true;
	}

	// comparer les entrées avec nos donnees
	private boolean employeAuth(String nomUsage, int id) throws IOException {

		// recuperation de la liste des admins dans la DB
		List<Employe> employes = (List<Employe>) this.lireLesDonnees("employes", Employe.class);

		for (Employe employe : employes) {

			if (employe.getNomUtilisateur().equals(nomUsage) && employe.getId() == id) {

				System.out.println();
				// Appelle Admin Service
				new EmployeService(employe.getId()).menuEmploye(employe.getNom().toUpperCase());
				;
				return true;
			}
		}

		System.out.println("Nom usage ou mot de passe incorrect ...\n");

		// recuper le choix de l'utisateur
		try {

			int choixUtilisateur = Integer
					.parseInt(recupererLesEntree("1.Se connecter à nouveau\n2.Menu precedent\n3.Quitter"));

			switch (choixUtilisateur) {

			case 1:
				connectionEmploye();
				break;

			case 2:
				Main.main(null);
				break;

			case 3:
				System.out.println("Aurevoir");
				break;

			default:
				System.out.println("veuillez entrer un nombre indiqué au menu");
				connectionEmploye();
				break;

			}

		} catch (NumberFormatException e) {

			System.out.println("Veuillez entrer un nombre indiqué au menu");
			new Main().main(null);
		}

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
