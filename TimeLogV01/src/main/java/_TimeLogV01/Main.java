package _TimeLogV01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import service.AuthService;
import service.InitTimeLogService; 

public class Main {
	public static void main(String[] args) throws IOException {
		try {
			 new InitTimeLogService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		Main.menuInitiation();	
	}
	
	// Avant la connection 
	public static void menuInitiation() throws IOException {
		
		AuthService authService = new AuthService();
		
	     System.out.println("\n ################### \t-- !!! Bienvenue sur TimeLog !!! -- \t ####################\n");
	     
	        System.out.println("\t1. Employe");
	        System.out.println("\t2. Administrateur");	        
	        System.out.println("\t0. Quitter\n");
	        
	       //recuper le choix de l'utisateur
	        try {
	        	int nbrChosi = Integer.parseInt(inputOutput ("Veuillez appuyer sur le numéro qui correspond pour vous connectez: "));
	        	
	        	switch (nbrChosi) {
	        	
				case 1: authService.seConnecter(false); break;
				
				case 2 : authService.seConnecter(true); break;
				
				case 0 : System.out.println("Au revoir"); break;
				
				default: System.out.print("Veuillez entrer un nombre indiqué au menu: "); menuInitiation();
				
	        	}
	        	 
	        } catch (NumberFormatException e) {
	        	System.out.println("Erreur d'entrée veuillez entrer un nombre indiqué au menu");
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