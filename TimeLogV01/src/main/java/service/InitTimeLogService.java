/**
 * 
 */
package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import model.Activite;
import model.Admin;
import model.Discipline;
import model.Employe;
import model.EmployeProjet;
import model.Projet;
import model.TauxHoraire;
import model.enums.DisciplineTypes;
import model.DetailProjetDiscipline;

/**
 * Cette d'initiation de projet
 */
public class InitTimeLogService extends ResourceService {

	public InitTimeLogService() throws IOException {
		saveAdmin();
		saveProject();
		saveEmploye();
		saveDiscipline();
		saveDetailProjetDiscipline();
		saveEmployeProjet();
		saveEmployeActivite();
		saveTauxHoraire();
	}

	// 3 project lors du demarage de systeme
	public void saveProject() {
		List<Projet> projets = new ArrayList<>();

		projets.add(new Projet("Projet1"));
		projets.add(new Projet("Projet2"));
		projets.add(new Projet("Projet3"));

		try {
			this.saveInit(projets, "projets");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveTauxHoraire() {

		List<TauxHoraire> tauxHoraires = new ArrayList<>(); 
		
		tauxHoraires.add(new TauxHoraire(20, 25));
		tauxHoraires.add(new TauxHoraire(22, 27));
		tauxHoraires.add(new TauxHoraire(27, 30));

		try {
			this.saveInit(tauxHoraires, "tauxHoraires");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveEmploye() {
		List<Employe> employes = new ArrayList<>();

		employes.add(new Employe("Pires",1));
		employes.add(new Employe("Omar",3));
		employes.add(new Employe("Madona",2));

		try {
			this.saveInit(employes, "employes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveAdmin() {

		List<Admin> admin = new ArrayList<>();

		admin.add(new Admin("admin"));

		try {
			this.saveInit(admin, "admins");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveDiscipline() {

		List<Discipline> disciplines = new ArrayList<>();

		for (DisciplineTypes disciplineTypes : DisciplineTypes.values()) {

			disciplines.add(new Discipline(disciplineTypes.toString()));
		}

		try {
			this.saveInit(disciplines, "disciplines");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveDetailProjetDiscipline() throws IOException {

		List<Projet> projets = (List<Projet>) this.lireLesDonnees("projets", Projet.class);
		List<Discipline> disciplines = (List<Discipline>) this.lireLesDonnees("disciplines", Discipline.class);

		List<DetailProjetDiscipline> detailProjetDisciplines = new ArrayList();
		Random budgetParDiscpline = new Random();

		for (Projet projet : projets) {
			for (Discipline discipline : disciplines) {
				detailProjetDisciplines.add(new DetailProjetDiscipline(projet.getIdProjet(),
						discipline.getIdDiscipline(), budgetParDiscpline.nextInt(100, 200)));
			}
		}

		this.saveInit(detailProjetDisciplines, "detailProjetDisciplines");
	}

	// assigner l'employé au projet
	public void saveEmployeProjet() throws IOException {

		List<Employe> employes = (List<Employe>) this.lireLesDonnees("employes", Employe.class);
		List<Projet> projets = (List<Projet>) this.lireLesDonnees("projets", Projet.class);

		List<EmployeProjet> employeProjets = new ArrayList<>();
		int i ;		
		Random random = new Random(); 
		int projetId=0;
		Set<Integer> usedProjetIds = new HashSet<>(); // Pour stocker les projets déjà utilisés

        for (Employe employe : employes) {
            i = 0;
            usedProjetIds.clear();
            while (i < 2) {
              
                do {
                    projetId = random.nextInt(3) + 1; // Génère un projetId aléatoire entre 1 et 3
                } while (usedProjetIds.contains(projetId)); // Vérifie si le projetId est déjà utilisé
                usedProjetIds.add(projetId); // Marque le projetId comme utilisé
                employeProjets.add(new EmployeProjet(employe.getId(), projetId));
                i++;
            }
        }
        
		this.saveInit(employeProjets, "employeProjets");
	}

	// initiation employe activité
	public void saveEmployeActivite() throws IOException {

		List<EmployeProjet> employeProjets = (List<EmployeProjet>) this.lireLesDonnees("employeProjets",
				EmployeProjet.class);
		List<DetailProjetDiscipline> detailProjetDisciplines = (List<DetailProjetDiscipline>) this
				.lireLesDonnees("detailProjetDisciplines", DetailProjetDiscipline.class);

		List<Activite> activites = new ArrayList();

		int idProjet = 0;
		int idDiscipline = 0;
		int idEmploye = 0;
		int nbrJr = 1;
		long heureTravaille = 1;
		LocalTime heureDebutActivite = LocalTime.of(7, 0, 0);
		LocalDate localDate = LocalDate.now();

		for (EmployeProjet employeProjet : employeProjets) {
			heureDebutActivite = LocalTime.of(7, 0, 0);
			idEmploye = employeProjet.getIdEmploye();
			if (employeProjet.getIdProjet() != idProjet && employeProjet.getIdEmploye() == idEmploye) {
				for (DetailProjetDiscipline detailProjetDiscipline : detailProjetDisciplines) {
					if (employeProjet.getIdProjet() == detailProjetDiscipline.getIdProjet()
							&& detailProjetDiscipline.getIdDiscpline() != idDiscipline) {

						heureDebutActivite = heureDebutActivite.plusHours(1);
						while (nbrJr <= 10) {
							activites.add(new Activite(employeProjet.getIdEmploye(),
									detailProjetDiscipline.getIdDetailProjetDiscipline(),
									localDate.minusDays(nbrJr).toString(), heureDebutActivite.toString(),
									heureDebutActivite.plusHours(1).plusMinutes(heureTravaille).toString()));
							nbrJr++;
						}
						idDiscipline = detailProjetDiscipline.getIdDiscpline();
						localDate = localDate.now();
					}
					nbrJr = 1;

				}

			}
			heureTravaille++;
		}

		this.saveInit(activites, "activites");
	}
}
