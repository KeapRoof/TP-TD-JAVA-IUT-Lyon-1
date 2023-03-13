public class Terrain extends BienImmobilier{
    private double viable;
    private double taxefonciere;
    private static final Locataire base = null;

    public Terrain(String Newdescription, int Newsurface, boolean Newlocation, boolean Newvente, double Newprixm2, double Newtximpot, Proprietaire Newproprietaire, Locataire Newlocataire,double viable){
        super(Newdescription,Newsurface,Newlocation,Newvente,Newprixm2,Newtximpot,Newproprietaire,Newlocataire);
        this.viable = viable;
        this.locataire = base;
        this.setTaxefonciere(calcTaxeFonc());
    }

    private double calcTaxeFonc(){
        double taxe;
        double loyertheorique = this.surface * this.prixm2 * 12;
        taxe = loyertheorique * 0.25 + 10*this.surface;
        return taxe;
    }

    // Methodes d'acces (getters) 
    public double getViable(){
        return this.viable;
    }
    // Methodes de modification (setters)
    public void setViable(double Newviable){
        this.viable = Newviable;
    }

    public String toString(){
        return "Terrain: " + this.description + " " + this.surface + " " + this.location + " " + this.vente + " " + this.prixm2 + " " + this.tximpot + " " + this.proprietaire + " " + this.locataire + " " + this.viable + " " + this.taxefonciere;
    }

    public void setLocataire(Locataire Newlocataire){
        this.locataire = null;
    }
}
