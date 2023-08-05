import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Travail {
    private Date dateDebut;
    private Date dateFin;
    private double heuresTravailleesBase;
    private double heuresTravailleesSupplementaires;

    // Constructeur de la classe Travail
    public Travail(String dateDebut, String dateFin, double heuresTravailleesBase, double heuresTravailleesSupplementaires) {
      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
      try {
        this.dateDebut = dateFormat.parse(dateDebut);
        this.dateFin = dateFormat.parse(dateFin);
      } catch (ParseException e) {
        e.printStackTrace();
      }
      this.heuresTravailleesBase = heuresTravailleesBase;
      this.heuresTravailleesSupplementaires = heuresTravailleesSupplementaires;
    }

  public boolean estDansPeriode(String dateDebutPeriode, String dateFinPeriode) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    try {
      Date periodeDebut = dateFormat.parse(dateDebutPeriode);
      Date periodeFin = dateFormat.parse(dateFinPeriode);
      // Vérifier si le travail a été effectué pendant la période spécifiée
      return (dateDebut.compareTo(periodeDebut) >= 0 && dateFin.compareTo(periodeFin) <= 0);
    } catch (ParseException e) {
        e.printStackTrace();
      return false;
    }
    }

  // Méthode pour obtenir les heures travaillées de base
  public double getHeuresTravailleesBase() {
    return heuresTravailleesBase;
  }

  // Méthode pour obtenir les heures supplémentaires travaillées
  public double getHeuresTravailleesSupplementaires() {
    return heuresTravailleesSupplementaires;
  }
}
