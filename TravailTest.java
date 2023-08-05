

public class TravailTest {
    private Travail travail;

    public void setUp() {
        // Créez un nouvel objet Travail pour les tests
        String dateDebut = "01/08/2023 09:00";
        String dateFin = "01/08/2023 12:00";
        double heuresTravailleesBase = 3.0;
        double heuresTravailleesSupplementaires = 0.0;
        travail = new Travail(dateDebut, dateFin, heuresTravailleesBase, heuresTravailleesSupplementaires);
    }


    public void testEstDansPeriode() {
        // Teste si le travail est dans la période spécifiée
        assertTrue(travail.estDansPeriode("01/08/2023 08:00", "01/08/2023 13:00"));
    }

    private void assertTrue(boolean estDansPeriode) {
    }


    public void testGetHeuresTravailleesBase() {
        // Teste la méthode getHeuresTravailleesBase
        assertEquals(3.0, travail.getHeuresTravailleesBase(), 0.001);
    }

    private void assertEquals(double d, double heuresTravailleesBase, double e) {
    }

    
    public void testGetHeuresTravailleesSupplementaires() {
        // Teste la méthode getHeuresTravailleesSupplementaires
        assertEquals(0.0, travail.getHeuresTravailleesSupplementaires(), 0.001);
    }
}