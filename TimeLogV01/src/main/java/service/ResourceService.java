/**
 * 
 */
package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Projet;

/**
 * Classe pour gérer la persistance(sauvegarde) JSON 
 */
public class ResourceService {

	private ObjectMapper mappingObjet;
	private File fichierDB; // fichier base de la donnee
	private Map<String, List<?>> tables;

	private String fileName = "dataBase.json";

	public ResourceService() {

		fichierDB = new File(fileName);
		mappingObjet = new ObjectMapper();
		this.tables = new HashMap<>();

	}

	// sauvegarder les données
	public void save(List<?> objects, String tableName) throws IOException {
		tables.put(tableName, objects);
		mappingObjet.writeValue(fichierDB, tables);
	}

	// Load the data from the JSON file
	// charger les données des projets à partir du fichier JSON
	public List<?> lireLesDonnees(String nomTable, Class<?> clazz) throws IOException {

		Map<String, List<?>> chargerLesDonees = mappingObjet.readValue(fichierDB,
				new TypeReference<Map<String, List<?>>>() {
				});
		List<?> donnees = chargerLesDonees.get(nomTable);

		// Convertir la liste des objets LinkedHashMap en liste des objets passer en
		// parametre
		List<?> listDonnee = mappingObjet.convertValue(donnees,
				mappingObjet.getTypeFactory().constructCollectionType(List.class, clazz));

		return listDonnee;
	}

	public boolean modifierDonnee(String nomTable,List<?> nouvellesDonnees) throws IOException {
		
		if (nouvellesDonnees == null) {
			throw new IllegalArgumentException("Une erreur s'est produite"); 
		}
		
		 this.tables.put(nomTable, nouvellesDonnees);
		 mappingObjet.writeValue(fichierDB, tables);
		 
		 return true;

	}
	
	 

}
