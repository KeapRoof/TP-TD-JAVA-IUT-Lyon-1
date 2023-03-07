public class Habitation extends BienImmobilier{
    private double prixreel;
    public Habitation(String Newdescription, int Newsurface, boolean Newlocation, boolean Newvente, double Newprixm2, double Newtximpot, Proprietaire Newproprietaire, Locataire Newlocataire,double prixreel){
        super(Newdescription,Newsurface,Newlocation,Newvente,Newprixm2,Newtximpot,Newproprietaire,Newlocataire);
        this.prixreel = prixreel;
    }

    // Methodes d'acces (getters)
    public double getPrixreel(){
        return this.prixreel;
    }
    // Methodes de modification (setters)
    public void setPrixreel(double Newprixreel){
        this.prixreel = Newprixreel;
    }

    public String toString(){
        return "Habitation: " + this.description + " " + this.surface + " " + this.location + " " + this.vente + " " + this.prixm2 + " " + this.tximpot + " " + this.proprietaire + " " + this.locataire + " " + this.prixreel;
    }
        
}
