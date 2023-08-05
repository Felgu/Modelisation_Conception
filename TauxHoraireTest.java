package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TauxHoraireTest {

    private TauxHoraire tauxHoraire;

    @BeforeEach
    void setUp() {
        // Créer une instance de TauxHoraire avant chaque test
        tauxHoraire = new TauxHoraire(20.0, 30.0); 
        // tauxHoraireBase = 20.0, tauxHoraireSupplement = 30.0
    }

    @Test
    void testGetTauxHoraireDeBase() {
        double expectedBase = 20.0;
        assertEquals(expectedBase, tauxHoraire.getTauxHoraireDeBase());
    }

    @Test
    void testGetTauxHoraireSupplem() {
        double expectedSupplement = 30.0;
        assertEquals(expectedSupplement, tauxHoraire.getTauxHoraireSupplem());
    }

    @Test
    void testAfficherTaux() {
        String expectedOutput = "\nLe taux horaire de base : 20.0\nLe taux supplementaire : 30.0\n";
        assertEquals(expectedOutput, tauxHoraire.afficherTaux());
    }

}