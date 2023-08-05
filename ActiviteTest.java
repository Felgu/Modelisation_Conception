package model;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

class ActiviteTest {

    private Activite activite;
    private Projet projet;
    private Discipline discipline;

    @BeforeEach
    void setUp() {
        // Créer une instance de Projet et Discipline pour les tests
        projet = new Projet("Projet_Test", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(7)));
        discipline = new Discipline("Informatique");

        // Créer une instance d'Activite avant chaque test
        activite = new Activite(projet, discipline, LocalTime.now(), LocalTime.now().plusHours(4));
    }

    @Test
    void testGetProjet() {
        assertEquals(projet, activite.getProjet());
    }

    @Test
    void testSetProjet() {
        Projet newProjet = new Projet("Nouveau Projet", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now().plusDays(14)));
        activite.setProjet(newProjet);
        assertEquals(newProjet, activite.getProjet());
    }

    @Test
    void testGetDiscipline() {
        assertEquals(discipline, activite.getDiscipline());
    }

    @Test
    void testSetDiscipline() {
        Discipline newDiscipline = new Discipline("Nouvelle Discipline");
        activite.setDiscipline(newDiscipline);
        assertEquals(newDiscipline, activite.getDiscipline());
    }

    @Test
    void testGetDebutTravail() {
        LocalTime expectedDebutTravail = LocalTime.now();
        assertEquals(expectedDebutTravail, activite.getDebutTravail());
    }

    @Test
    void testSetDebutTravail() {
        LocalTime newDebutTravail = LocalTime.of(9, 0); // 9:00 AM
        activite.setDebutTravail(newDebutTravail);
        assertEquals(newDebutTravail, activite.getDebutTravail());
    }

    @Test
    void testGetFinTravail() {
        LocalTime expectedFinTravail = LocalTime.now().plusHours(4);
        assertEquals(expectedFinTravail, activite.getFinTravail());
    }

    @Test
    void testSetFinTravail() {
        LocalTime newFinTravail = LocalTime.of(14, 0); // 2:00 PM
        activite.setFinTravail(newFinTravail);
        assertEquals(newFinTravail, activite.getFinTravail());
    }

}