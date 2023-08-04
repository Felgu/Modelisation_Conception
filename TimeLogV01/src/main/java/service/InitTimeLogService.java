/**
 * 
 */
package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Admin;
import model.Discipline;
import model.Employe;
import model.Projet;
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

	public void saveEmploye() {
		List<Employe> employes = new ArrayList<>();

		employes.add(new Employe("Pires"));
		employes.add(new Employe("Omar"));
		employes.add(new Employe("Madona"));

		try {
			this.saveInit(employes,"employes");
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
		 
		 List<DetailProjetDiscipline> detailProjetDisciplines= new ArrayList();
		 Random budgetParDiscpline = new Random();
		
		 
		 for (Projet projet : projets) {
			 for (Discipline discipline : disciplines) {
				detailProjetDisciplines.add(new DetailProjetDiscipline(projet.getIdProjet(), discipline.getIdDiscipline(), budgetParDiscpline.nextInt(1000, 99999)));
			}
		}
		 
		 this.saveInit(detailProjetDisciplines, "detailProjetDisciplines");
	 }
}
