/**
 * 
 */
package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Employe;
import model.Projet;
import model.Utilisateur;

/**
 *  Cette d'initiation de projet
 */
public class InitTimeLog extends ResourceService {
	
	

	public InitTimeLog() {
		super();
		saveProject();
		saveEmploye();
	}

	//3 project lors du demarage de systeme	
	public void saveProject() {
		List<Projet> projets = new ArrayList<>();
		
		projets.add(new Projet("Projet1"));
		projets.add(new Projet("Projet2"));
		projets.add(new Projet("Projet3"));
		
		try {
			this.save(projets, "projets");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveEmploye() {
		List<Employe> employes = new ArrayList<>();
		List<Utilisateur> utilisateurs = new ArrayList<>();
		 
		
		employes.add(new Employe("Pires"));
		employes.add(new Employe("Omar"));
		employes.add(new Employe("Madona"));
		
		try {
			this.save(employes, "employes");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
