public class Proprietaire{
    private String identite;
    private boolean ressec;
    private String adresse;
    private double tximpot;

    public Proprietaire(String identite, boolean ressec, String adresse, double tximpot){
        this.identite = identite;
        this.ressec = ressec;
        this.adresse = adresse;
        this.tximpot = calculImpot(tximpot);
    }

    // Getters

    public String getIdentite(){
        return this.identite;
    }

    public boolean getRessec(){
        return this.ressec;
    }

    public String getAdresse(){
        return this.adresse;
    }

    public double getTximpot(){
        return this.tximpot;
    }

    // Setters

    public void setIdentite(String identite){
        this.identite = identite;
    }

    public void setRessec(boolean ressec){
        this.ressec = ressec;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public void setTximpot(double tximpot){
        this.tximpot = tximpot;
    }

    public String toString(){
        return "Proprietaire: " + this.identite + " " + this.ressec + " " + this.adresse + " " + this.tximpot;
    }

    private double calculImpot(double valeur){
        if (this.ressec == false){
            valeur = 0;
        }
        return valeur;
    }
}