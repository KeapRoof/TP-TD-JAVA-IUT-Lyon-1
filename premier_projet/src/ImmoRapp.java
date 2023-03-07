public class ImmoRapp extends BienImmobilier{
    private double reduc;
    public ImmoRapp(String Newdescription, int Newsurface, boolean Newlocation, boolean Newvente, double Newprixm2, double Newtximpot, Proprietaire Newproprietaire, Locataire Newlocataire,double reduc){
        super(Newdescription,Newsurface,Newlocation,Newvente,Newprixm2,Newtximpot,Newproprietaire,Newlocataire);
        this.reduc = reduc;
    }

    // Methodes d'acces (getters)
    public double getReduc(){
        return this.reduc;
    }
    // Methodes de modification (setters)
    public void setReduc(double Newreduc){
        this.reduc = Newreduc;
    }

    public String toString(){
        return "ImmoRapp: " + this.description + " " + this.surface + " " + this.location + " " + this.vente + " " + this.prixm2 + " " + this.tximpot + " " + this.proprietaire + " " + this.locataire + " " + this.reduc;
    }
}
