package _TimeLogV01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.AuthService;
import service.InitTimeLogService; 

public class Main {

	public static void main(String[] args) {
		
		InitTimeLogService initTimeLog = new InitTimeLogService();		
		Main.menuInitiation();	
	}
	
	// Avant la connection 
	public static void menuInitiation() {
		
		AuthService authService = new AuthService();
		
	     System.out.println("Bienvenue sur TimeLog");
	     
	        System.out.println("1. Employe");
	        System.out.println("2. Administrateur");	        
	        System.out.println("0. Quitter\n");
	        
	       //recuper le choix de l'utisateur
	        try {
	        	int nbrChosi = Integer.parseInt(inputOutput ("Veuillez appuyer sur le numéro qui correspond pour vous connectez."));
	        	
	        	switch (nbrChosi) {
	        	
				case 1: authService.seConnecter(false); break;
				
				case 2 : authService.seConnecter(true); break;
				
				case 0 : System.out.println("Au revoir"); break;
				
				default: System.out.println("veuillez entrer un nombre indiqué");
				
	        	}
	        	 
	        } catch (NumberFormatException e) {
	        	System.out.println("veuillez entrer");
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

