public class ImmoComm extends BienImmobilier{
    private int usage;
    
    public ImmoComm(String Newdescription, int Newsurface, boolean Newlocation, boolean Newvente, double Newprixm2, double Newtximpot, Proprietaire Newproprietaire, Locataire Newlocataire,int usage){
        super(Newdescription,Newsurface,Newlocation,Newvente,Newprixm2,Newtximpot,Newproprietaire,Newlocataire);
        this.usage = usage;
    }

    // Methodes d'acces (getters)
    public int getUsage(){
        return this.usage;
    }
    // Methodes de modification (setters)
    public void setUsage(int Newusage){
        this.usage = Newusage;
    }

    public String toString(){
        return "ImmoComm: " + this.description + " " + this.surface + " " + this.location + " " + this.vente + " " + this.prixm2 + " " + this.tximpot + " " + this.proprietaire + " " + this.locataire + " " + this.usage;
    }
}
