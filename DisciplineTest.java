package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DisciplineTest {
	private Discipline discipline;
	
	@BeforeEach
	void setUp() {
		discipline = new Discipline("Design1");
	}
	@Test
	void testIdDiscipline() {
		int expectedId = 1;
		assertEquals(expectedId, discipline.getIdDiscipline());
	}

	@Test
	void testGetNom() {
		String expectedNom = "Design1";
		assertEquals(expectedNom, discipline.getNom());
	}

	@Test
	void testSetIdDiscipline() {
		int newId = 77;
		discipline.setIdDiscipline(newId);
		assertEquals(newId, discipline.getIdDiscipline());
	}


	@Test
	void testSetNom() {
		String newNom = "Nouvelle discipline";
		discipline.setNom(newNom);
		assertEquals(newNom, discipline.getNom());
	}
}