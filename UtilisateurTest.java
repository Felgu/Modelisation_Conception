package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

class UtilisateurTest {
	private Utilisateur utilisateur;
	private final ByteArrayOutputStream capteur = new ByteArrayOutputStream();
	
	@Before
	void setUp() {
		utilisateur = new Utilisateur("Omar Chabane");
		System.setOut(new PrintStream(capteur));
	}
	@After
	public void tearDown() {
		System.setOut(System.out);
	}
	@Test
	void seConnecterAdmin() {
		utilisateur.seConnecter("ochabane", "admin", true);
		assertEquals("Connexion reussi en tant qu'administrateur.", capteur.toString().trim());
	}
	@Test
	void seConnecterEmploye() {
		utilisateur.seConnecter("lpirez", "pirez", false);
		assertEquals("Connexion reussi en tant qu'employe.", capteur.toString().trim());
	}
	@Test
	void seConnecterhacker() {
		utilisateur.seConnecter("jamalaa", "admin", false);
		assertEquals("Nom/password d'utilisateur incorrect.", capteur.toString().trim());
	}
	@Test
	void testGetNom() {
	    assertEquals("John Doe", utilisateur.getNom());
	}
	@Test
	void testGetId() {
		assertEquals("Omar Chabane", utilisateur.getId());
	}

	@Test
	void testSetId() {
		utilisateur.setId(2);
	     assertEquals(2, utilisateur.getId());
	}

	@Test
	void testGetNomUsager() {
		assertEquals("ochab", utilisateur.getNomUsager());
	}

	@Test
	void testSetNomUsager() {
		utilisateur.setNomUsager("mmadon");
        assertEquals("ochab", utilisateur.getNomUsager());
	}
	@Test
	public void testSeConnecterAdmin() {
		utilisateur.seConnecter("omchab", "admin123", true);
	        }

	 @Test
	 public void testSeConnecterNonAdmin() {
	    utilisateur.seConnecter("johndoe", "password", false);
	 }

	 @Test
	 public void testSeConnecterIncorrectUser() {
	    utilisateur.seConnecter("janedoe", "password", false);
	 }

	  @Test
	  public void testEquals() {
	        Utilisateur autreUtilisateur = new Utilisateur("Lufungali pirez", 1, "lpirez");
	        assertTrue(utilisateur.equals(autreUtilisateur));
	  }

	  @Test
	  public void testNotEquals() {
	      Utilisateur autreUtilisateur = new Utilisateur("George mamadou", 2, "gmamado");
	      assertFalse(utilisateur.equals(autreUtilisateur));
	  }
}