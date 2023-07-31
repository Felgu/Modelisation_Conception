/**
 * 
 */
package service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Discipline;

/**
 * Classe pour gérer la persistance JSON 
 */
public class ResourceService {

	private ObjectMapper mappingObjet;
	private File fichierDB; //fichier base de donnee
	private Map<String, List<?>> tables;
	
	
	private String fileName = "src/main/resources/dataBase.json";

	public ResourceService() {
		
		fichierDB =new File(fileName);
		mappingObjet = new ObjectMapper();	
        this.tables = new HashMap<>();	
	}
	
	public  void save(List<?> objects,String tableName) throws IOException{
		tables.put(tableName, objects);
		mappingObjet.writeValue(fichierDB, tables);
	}; 
	
}
