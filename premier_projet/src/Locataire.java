public class Locataire {
    private String identite;
    private String adresse;
    private double loyer;
    //Liens
    private BienImmobilier occupe;

    public Locataire(String identite, String adresse, double loyer){
        this.identite = identite;
        this.adresse = adresse;
        this.loyer = loyer;
    }

    // Getters
    public String getIdentite(){
        return this.identite;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public double getLoyer(){
        return this.loyer;
    }

    public BienImmobilier getOccupe(){
        return this.occupe;
    }

    // Setters

    public void setIdentite(String identite){
        this.identite = identite;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public void setLoyer(double loyer){
        this.loyer = loyer;
    }

    public String toString(){
        return "Locataire: " + this.identite + " L'adresse est:" + this.adresse + " Le loyer est de : " + this.loyer + " Il occupe le bien : "+ occupe.getDesc();
    }
    
    public void setOccupe(BienImmobilier occupe){
        this.occupe = occupe;
    }
    
    public String taxefoncieredubien(){
        return "La taxe fonciere de l'appartement dans lequel habite " + this.identite + " est de : " + this.occupe.getTaxefonciere();
    }
}
