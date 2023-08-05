package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
	private Admin admin;
	
	@BeforeEach
    void setUp() { admin = new Admin("admin123", "admin"); }
	
    @Test
    void testModifierNomUtilisateur() {
        // Cas de test où le nouveau nom d'utilisateur n'est pas déjà utilisé par un autre employé
        Employe employe = new Employe("Alphamamadou");
        admin.ajouterEmploye(employe);
        admin.modifierNomUtilisateur(employe, "sowmamad");
        assertEquals("JDoe", employe.getNomUsager());
    }

    @Test
    void testModifierNomUtilisateur_Duplicate() {
        // Cas de test où le nouveau nom d'utilisateur est déjà utilisé par un autre employé
        Employe employe1 = new Employe("mugmad");
        Employe employe2 = new Employe("mugmad");
        admin.ajouterEmploye(employe1);
        admin.ajouterEmploye(employe2);

        // On essaie de changer le nom d'utilisateur de employe1 en "LufungPir" (nomUsager de employe2)
        admin.modifierNomUtilisateur(employe1, "LufungPir");

        // Le nom d'utilisateur de employe1 ne devrait pas avoir changé car "LufungPir" est déjà utilisé
        assertNotEquals("LufungPir", employe1.getNomUsager());
    }


}