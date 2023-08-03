package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import _TimeLogV01.Main;

public class AdminService {

	public AdminService() {}

	//Pour la première connexion
	public void menu(String nomPersonne) throws IOException {
		System.out.println("Bienvenue " + nomPersonne.toUpperCase()+"\n");
		
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

			int nbrChosi = Integer.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu."));

			switch (nbrChosi) {

			case 0: this.deconnecter(); break;

			default:
				System.out.println("Veuillez entrer un nombre indiqué au menu\n");

			}

		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre indiqué au menu\n");
			
			menu();
		}
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

}
