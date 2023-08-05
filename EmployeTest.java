package model;
import static org.junit.Assert.assertEquals;
import java.sql.Date;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class EmployeTest {

    private Employe employe;

    @Before
    public void setUp() {
        employe = new Employe("Mugisha madonna");
    }

    @Test
    public void testSetAndGetPoste() {
        employe.setPoste("Développeur Java");
        assertEquals("Développeur Java", employe.getPoste());
    }

    @Test
    public void testSetAndGetNas() {
        employe.setNas("123456789");
        assertEquals("123456789", employe.getNas());
    }

    @Test
    public void testSetAndGetDateEmbauche() {
        LocalDate dateEmbauche = LocalDate.of(2022, 7, 21);
        employe.setDateEmbauche(Date.valueOf(dateEmbauche));
        assertEquals(Date.valueOf(dateEmbauche), employe.getDateEmbauche());
    }

    @Test
    public void testSetAndGetDateDepart() {
        LocalDate dateDepart = LocalDate.of(2024, 12, 31);
        employe.setDateDepart(Date.valueOf(dateDepart));
        assertEquals(Date.valueOf(dateDepart), employe.getDateDepart());
    }

    @Test
    public void testSetAndGetTauxHoraire() {
        TauxHoraire tauxHoraire = new TauxHoraire(25.0, 30.0);
        employe.setTauxHoraire(tauxHoraire);
        assertEquals(tauxHoraire, employe.getTauxHoraire());
    }

    /*
    @Test
    public void testAjouterEtRetirerProjet() {
        Projet projet = new Projet("Projet A", 1);
        employe.ajouterProjet(projet);
        assertEquals(projet, employe.getProjetAssignes().get(0));

        employe.retirerProjetAssigne(projet);
        assertNull(employe.getProjetAssignes());
    }
    */
}

