public class TauxHoraire {
  //les attributs
  private double tauxHoraireBase;
  private double tauxHoraireSupplement;

  //le constructeur
  public TauxHoraire(double tauxHoraireBase, double tauxHorairesupplem){
    this.tauxHoraireBase = tauxHoraireBase;
    this.tauxHoraireSupplement = tauxHorairesupplem;
  }
  
  //les getters et setters
  public double getTauxHoraireBase(){
    return tauxHoraireBase;
  }
  public double getTauxHoraireSupplem(){
    return tauxHoraireSupplement;
  }

  public void setTauxHoraireBase(double tauxHoraireBase){
    this.tauxHoraireBase = tauxHoraireBase;
  }
  public void setTauxHoraireSupplem(double tauxHoraireSupplement){
    this.tauxHoraireSupplement = tauxHoraireSupplement;
  }

  public String afficherTaux(){
    return "\nLe taux horaire de base : "+ tauxHoraireBase+" \nLe taux supplementaire : "+tauxHoraireSupplement+"\n";
  }
}