package service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import _TimeLogV01.Main;
import model.Admin;
import model.Discipline;
import model.Employe;
import model.EmployeProjet;
import model.Projet;

public class AdminService {
	//les attributs
	private ResourceService resourceService;
	//le constructeur
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
		System.out.println("10. Génerer de rapport");
		System.out.println("0. Deconnecter");
		System.out.println();

		try {

			int nbrChosi = Integer
					.parseInt(recupererLesEntree("Veuillez appuyer sur le numéro qui correspond au menu. \n\t\t"));

			switch (nbrChosi) {

			case 0:
				this.deconnecter();
				break;
			case 1:
				this.creerProjet();
				break;
			case 2:
				this.supprimerProjet();
				break;
			case 3:
				this.ajouterEmploye();
				break;
			case 4:
				this.assignerProjet();
				break;
			case 5:
				this.ajouterDisciplineProjet();
				break;
			case 6:
				this.supprimerEmploye();
				break;
			case 7:
				this.changerNpeEmploye(0);
				break;
			case 8:
				this.modifierNomUsagerAdmin();
				break;
			case 9:
				this.modifierIdAdmin();
				break;
			case 10:
				this.genererRapport();
				break;

			default:
				System.out.println("Veuillez entrer un nombre indiqué au menu\n");
				break;

			}

		} catch (NumberFormatException e) {
			System.out.println("Veuillez entrer un nombre indiqué au menu\n");
			menu();
		}
	}

	private void genererRapport() throws IOException {
		new RapportService();
	}

	private boolean creerProjet() throws IOException {

		List<Projet> projets = (List<Projet>) this.resourceService.lireLesDonnees("projets", Projet.class);
		String nomProjet = recupererLesEntree("Nom projet:");

		// verifier si le nom projet existe
		if (projets.stream().filter(projet -> projet.getNomProjet().equalsIgnoreCase(nomProjet)).findFirst()
				.isPresent()) {
			System.out.println("** Le projet <" + nomProjet + "> existe déja**");

			int choix = Integer.parseInt(recupererLesEntree("Appuyer sur 1 pour recommencer ..."));

			if (choix == 1) {
				this.creerProjet();
				return false;
			}

			menu();
			return false;
		}

		projets.add(new Projet(nomProjet));
		this.resourceService.modifierDonnee("projets", projets);

		System.out.println("**Le projet <" + nomProjet + "> est ajouté avec succès ... **\n");
		menu();
		return true;
	}

	private boolean supprimerProjet() throws IOException {

		List<Projet> projets = (List<Projet>) this.resourceService.lireLesDonnees("projets", Projet.class);

		for (Projet projet : projets) {
			System.out.println("" + projet.getIdProjet() + " " + projet.getNomProjet());
		}

		int idProjetASupprimer = Integer.parseInt(recupererLesEntree("Entre le num du projet:"));

		// Test si la valeur correspond à l'Id affiché
		if (!projets.stream().filter(projet -> projet.getIdProjet() == idProjetASupprimer).findFirst().isPresent()) {

			System.out.println("** Veuillez entrer le numéro de projet affiché **");

			try {

				int choix = Integer.parseInt(recupererLesEntree("Appuyer sur 1 pour recommencer ..."));
				if (choix == 1) {
					this.supprimerProjet();
					return false;
				}
				menu();
				return false;
			} catch (NumberFormatException e) {
				System.out.println("** Veuillez entrer le numéro de projet affiché **");
				this.supprimerEmploye();
				return false;
			}
		}

		// supprimer le projet
		projets.removeIf(projet -> projet.getIdProjet() == idProjetASupprimer);

		this.resourceService.modifierDonnee("projets", projets);
		System.out.println("** Le projet a été supprimé avec  succès **\n");
		menu();

		return true;
	}

	private void ajouterEmploye() throws IOException {

		List<Employe> employes = (List<Employe>) this.resourceService.lireLesDonnees("employes", Employe.class);

		String nomEmploye = recupererLesEntree("Entrez le nom :");
		String poste = recupererLesEntree("Entrez le poste :");
		String nas = recupererLesEntree("Entrez le NAS :");

		employes.add(new Employe(nomEmploye, poste, nas));

		// savegarder
		this.resourceService.modifierDonnee("employes", employes);

		System.out.println("** " + nomEmploye.toUpperCase() + " est ajouté avec l'ID "
				+ employes.stream().reduce((first, last) -> last).get().getId() + "**\n3");

		menu();
	}

	// Q9 assigner un employe au projet
	private boolean assignerProjet() throws IOException {

		List<EmployeProjet> employeProjets = (List<EmployeProjet>) this.resourceService.lireLesDonnees("employeProjets",
				EmployeProjet.class);
		List<Employe> employes = (List<Employe>) this.resourceService.lireLesDonnees("employes", Employe.class);
		List<Projet> projets = (List<Projet>) this.resourceService.lireLesDonnees("projets", Projet.class);

		int idEmploye = Integer.parseInt(recupererLesEntree("Entree l'ID de l'employe:"));

		Employe getEmployeById = employes.stream().filter(employe -> employe.getId() == idEmploye).findFirst()
				.isPresent() ? employes.stream().filter(employe -> employe.getId() == idEmploye).findFirst().get()
						: null;
		Long verifierEmployeNbrDeProjet = employeProjets.stream()
				.filter(employeProjet -> employeProjet.getIdEmploye() == idEmploye).count();
		boolean estNombre = false;

		// check si l'id existe
		if (getEmployeById == null) {
			System.out.println("*** Id inconnue... ***\n");
			menu();
			return false;
		}

		if (verifierEmployeNbrDeProjet < getEmployeById.getNpe()) {

			List<Integer> recupererIdsProjetEmploye = employeProjets.stream()
					.filter(employeProjet -> employeProjet.getIdEmploye() == idEmploye).map(EmployeProjet::getIdProjet)
					.collect(Collectors.toList());

			projets = projets.stream().filter(_projets -> !recupererIdsProjetEmploye.contains(_projets.getIdProjet()))
					.collect(Collectors.toList());

			System.out.println("\n**Choisisez le projet**\n");
			for (Projet projet : projets) {

				System.out.println("" + projet.getIdProjet() + " " + projet.getNomProjet());
			}
			while (!estNombre) {
				try {
					int choixProjet = Integer.parseInt(recupererLesEntree("Entre le numero de projet affiché: "));
					estNombre = true;

					if (projets.stream().filter(projet -> projet.getIdProjet() == choixProjet).findFirst()
							.isPresent()) {
						employeProjets.add(new EmployeProjet(idEmploye, choixProjet));
					} else {
						System.out.println("\n** Choix de projet incorrect **\n");
						menu();
						return false;
					}
				} catch (NumberFormatException e) {
					System.out.println("** Veuillez entrer un entier **");
					estNombre = false;
				}
			}

			this.resourceService.modifierDonnee("employeProjets", employeProjets);
			System.out.println("**L'employé " + getEmployeById.getNom() + " est assigné avec succès au projet**\n");
			menu();
			return true;
		}

		System.out.println("*** L'employé " + getEmployeById.getNom()
				+ " n'est peut etre assigné à un autre projet car son NPE est " + getEmployeById.getNpe() + "\n");
		menu();

		return false;
	}

	private void ajouterDisciplineProjet() throws IOException {

		List<Discipline> disciplines = (List<Discipline>) this.resourceService.lireLesDonnees("disciplines",
				Discipline.class);

		String nomDisciple = recupererLesEntree("Entree le nom de la discipline :");

		disciplines.add(new Discipline(nomDisciple.toUpperCase()));

		this.resourceService.modifierDonnee("disciplines", disciplines);
		System.out.println("** La discipline " + nomDisciple.toUpperCase() + " est ajoutée avec succès **\n");
		menu();

	}

	private boolean supprimerEmploye() throws IOException {

		List<Employe> employes = (List<Employe>) this.resourceService.lireLesDonnees("employes", Employe.class);

		boolean estNombre = false;
		int idEmploye = 0;

		while (!estNombre) {
			try {
				idEmploye = Integer.parseInt(recupererLesEntree("Entree l'ID de l'employé :"));
				estNombre = true;
			} catch (NumberFormatException e) {
				System.out.println("** Veuillez entrer un entier **");
				estNombre = false;
			}
		}
		for (Employe employe : employes) {
			if (employe.getId() == idEmploye) {
				employes.remove(employe);
				this.resourceService.modifierDonnee("employes", employes);
				System.out.println("** L'employé " + employe.getNom() + " est supprimer avec succes **\n");
				menu();
				return true;
			}
		}

		System.out.println("** Cet Id employé n'existe pas **\n");
		this.menu();
		return false;
	}

	private void deconnecter() throws IOException {
		Main.main(null);
	}

	/**
	 * 
	*/
	private static String recupererLesEntree(String message) {
		System.out.print(message + " ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String returnString = "";
		try {
			returnString = br.readLine();
		} catch (IOException e) {
			System.out.println("Erreur lors de la lecture de la valeur");
		}
		return returnString;
	}

	// Q11 nom usager
	public boolean modifierNomUsagerAdmin() throws IOException {

		List<Admin> listAdmin = (List<Admin>) this.resourceService.lireLesDonnees("admins", Admin.class);
		String nouvelNomUsage = null;

		String actuelNomUsage = recupererLesEntree("Entree le nom d'usage actuel :");

		for (Admin admin : listAdmin) {
			// test si ce nom existe
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
					// modifier le nom
					admin.setNomUtilisateur(nouvelNomUsage);
				}
				listAdmin.set(listAdmin.indexOf(admin), admin);

				if (this.resourceService.modifierDonnee("admins", listAdmin)) {
					System.out.println("** Nom d'usage modifié avec succes **\n");
					this.menu();
				}
				return true;
			} else {
				System.out.println("*** Nom d'usage inconnu ***\n");
				this.menu();
				return false;
			}
		}

		return true;
	}

	// Q11 modifier ID
	public boolean modifierIdAdmin() throws IOException {

		List<Admin> listAdmin = (List<Admin>) this.resourceService.lireLesDonnees("admins", Admin.class);
		int nouvelId = 0;

		boolean estNombre = false;
		int actuelId = 0;

		while (!estNombre) {
			try {
				actuelId = Integer.parseInt(recupererLesEntree("Entree l'ID actuel :"));
				estNombre = true;
			} catch (NumberFormatException e) {
				System.out.println("** Veuillez entrer votre nom un entier **");
				estNombre = false;
			}
		}
		estNombre = false;
		for (Admin admin : listAdmin) {
			// test si le id existe
			if (admin.getId() == actuelId) {
				while (!estNombre) {
					try {
						nouvelId = Integer.parseInt(recupererLesEntree("Entree le nouveau id :"));
						estNombre = true;
					} catch (NumberFormatException e) {
						System.out.println("**Veuillez entrer votre nom un entier **");
						estNombre = false;
					}
				}

				// Verifier si ce nom l'id existe deja
				for (Admin checkAdmin : listAdmin) {
					if (admin.getId() == nouvelId) {
						System.out.println("Cet id existe deja\n");
						this.menu();
						return false;
					}
				}
				// modifier l'id
				admin.setId(nouvelId);
				listAdmin.set(listAdmin.indexOf(admin), admin);

				if (this.resourceService.modifierDonnee("admins", listAdmin)) {
					System.out.println("** L'id est modifié avec succes **\n");
					this.menu();
				}
				return true;
			} else {
				System.out.println("*** L'id est inconnu **\n");
				this.menu();
				return false;
			}
		}

		return true;
	}

	// Q6 modifier le NPE
	public boolean changerNpeEmploye(int idEmploye_) throws IOException {

		List<Employe> employes = (List<Employe>) this.resourceService.lireLesDonnees("employes", Employe.class);

		boolean estNombre = false;
		int nouvauNPe = 0;
		int idEmploye = idEmploye_ == 0 ? 0 : idEmploye_;

		if (idEmploye == 0) {
			while (!estNombre) {
				try {
					idEmploye = Integer.parseInt(recupererLesEntree("Entree l'ID de l'employé :"));
					estNombre = true;
				} catch (NumberFormatException e) {
					System.out.println("** Veuillez entrer un nombre entier **");
					estNombre = false;
				}
			}
		}

		estNombre = false;
		for (Employe employe : employes) {
			// test si le id existe
			if (employe.getId() == idEmploye) {
				while (!estNombre) {
					try {
						nouvauNPe = Integer.parseInt(recupererLesEntree("Entree le nouveau NPE :"));
						estNombre = true;
					} catch (NumberFormatException e) {
						System.out.println("**Veuillez entrer un entier **");
						estNombre = false;
					}
				}

				if (desassignerEmployeProjet(employe, nouvauNPe)) {

					// modifier l'id
					employe.setNpe(nouvauNPe);
					employes.set(employes.indexOf(employe), employe);

					if (this.resourceService.modifierDonnee("employes", employes)) {
						System.out.println("** Le Npe de " + employe.getNom() + " est modifié avec succes **\n");
						this.menu();
						return true;
					}
				}
			}
		}
		System.out.println("*** L'id entré n'existe pas **\n");
		this.menu();
		return true;
	}

	// Cette fonction permet de desAssignerEmployeProjet
	public boolean desassignerEmployeProjet(Employe employe, int nouveauNpe) throws IOException {

		boolean estNombre = false;
		int choix = 0;

		if (nouveauNpe < employe.getNpe()) {
			System.out.println(
					"*** Le nombre de NPE entrer est inférieur au nombre actuel(" + employe.getNpe() + ") **\n");

			while (!estNombre) {
				try {
					choix = Integer.parseInt(recupererLesEntree("** Entrer 1 pour desassigné : " + employe.getNom() + " à "
							+ (employe.getNpe()- nouveauNpe)  + " projet(s) **"));
					estNombre = true;
				} catch (NumberFormatException e) {
					System.out.println("**Veuillez entrer un entier **");
					estNombre = false;
				}
			}

			if (choix != 1) {
				System.out.println("Le Npe n'est pas modifié");
				menu();
				return false;
			}

			List<EmployeProjet> employeProjets = (List<EmployeProjet>) this.resourceService.lireLesDonnees("employeProjets", EmployeProjet.class);
			List<Projet> projets = (List<Projet>) this.resourceService.lireLesDonnees("projets", Projet.class);

			List<Integer> recupererIdsProjetEmploye = employeProjets.stream().filter(employeProjet -> employeProjet.getIdEmploye() == employe.getId()).map(EmployeProjet::getIdProjet).collect(Collectors.toList());
			projets = projets.stream().filter(_projets -> recupererIdsProjetEmploye.contains(_projets.getIdProjet())).collect(Collectors.toList());

			System.out.println("\n**Choisisez le projet**\n");
			for (Projet projet : projets) {

				System.out.println("" + projet.getIdProjet() + " " + projet.getNomProjet()); 
			}

			String idsProjetDesassigner= recupererLesEntree("Entrer le(s) projet(s) en separant par une virgule");
			List<Integer> recupererEntiers = Arrays.stream(idsProjetDesassigner.split(",")) .map(String::trim).filter(AdminService::estEntier).map(Integer::parseInt).collect(Collectors.toList());
			employeProjets.removeIf(projetSupprimer -> recupererEntiers.contains(projetSupprimer.getIdProjet()) && projetSupprimer.getIdEmploye() == employe.getId());
			
			this.resourceService.modifierDonnee("employeProjets", employeProjets);
		}

		return true;
	}
	
	
	 private static boolean estEntier(String s) {
	        try {
	            Integer.parseInt(s);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
}