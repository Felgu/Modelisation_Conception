/**
 * 
 */
package service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	};

	// Cette fonction permet de recuperer nos données en spécifiant la table
	// Ex table : discpline,employe ...
	public List<?> chargerDesDonnées(String nomTable) throws IOException {

		if (tables.containsKey(nomTable)) {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fichierDB.getName());
			return mappingObjet.readValue(inputStream, new TypeReference<Map<String, List<?>>>() {}).get(nomTable);
		}
		return null;
	}

}
