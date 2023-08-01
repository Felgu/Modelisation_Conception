package _TimeLogV01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import service.InitTimeLogService; 

public class Main {

	public static void main(String[] args) {
		
		InitTimeLogService initTimeLog = new InitTimeLogService();
		
		Main.menuInitiation();	
	}
	
	// Avant la connection 
	public static void menuInitiation() {
		
		
		
		
	     System.out.println("Bienvenu sur TimeLog");
	     
	        System.out.println("1. Employe");
	        System.out.println("3. Administrateur");	        
	        System.out.println("0. Quitter\n");
	        
	       //recuper le choix de l'utisateur
	        try {
	        	int nbrChosi = Integer.parseInt(inputOutput ("Veuillez appuyer sur le numéro qui correspond pour vous connectez."));
	        	
	        	if (nbrChosi >= 0 && nbrChosi <=6) {
			         
	        	} else {
	        		System.out.println("veuillez entrer un numéro de 0 - 6");
	            	 
	        	}
	        } catch (NumberFormatException e) {
	        	System.out.println("veuillez entrer un numéro de 0 - 6");
	        	menuInitiation();
	        }
	}  
	
	
	  /**
     * * Passe une invite à l'utilisateur et renvoie l'utilisateur spécifié
     * string.
     * @param message
     * @return String
     */
    private static String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value"); 	    }
	    return returnString;
    }

}

