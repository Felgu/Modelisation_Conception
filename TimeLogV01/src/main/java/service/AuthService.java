/**
 * 
 */
package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */
public class AuthService {
	
	public void seConnecter(boolean isAdmin) {
	
		if (!isAdmin) {
			this.employe();
		}else {
			this.admin();
		}
	}
	
	private void employe() {
		
		System.out.println("-- Connexion Employe --");
		String id= recupererLesEntree("Entrée votre id");
		String nomUsage= recupererLesEntree("Entrée votre nom d'usager");
		
		System.out.println("La suite Arrive");
	}
	
	private void admin() {
		
		System.out.println("-- Connexion Admin --");
		String id= recupererLesEntree("Entrée votre nom d'usager");
		String nomUsage= recupererLesEntree("Entrée votre mot de passe");
		
		System.out.println("La suite Arrive");
	}
	
	 /**
	  * 
     */
    private static String recupererLesEntree(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Erreur lors de la lecture de la valeur"); 
	    }
	    return returnString;
    }

}
