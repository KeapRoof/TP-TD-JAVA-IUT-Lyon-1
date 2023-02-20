public class BienImmobilier{
    // Attributs
    private static int nbreBienImmobilier = 0;
    private int reference;
    private String description;
    private int surface;
    private boolean location;
    private boolean vente;
    private double prixm2;
    private double tximpot;
    private double taxefonciere;
    // Lien avec les autres classes
    private Proprietaire proprietaire;
    private Locataire locataire;


    // Constructeur
    public BienImmobilier(String Newdescription, int Newsurface, boolean Newlocation, boolean Newvente, double Newprixm2, double Newtximpot, Proprietaire Newproprietaire, Locataire Newlocataire){
        nbreBienImmobilier ++;
        int temp = nbreBienImmobilier;
        this.reference = temp;
        this.description = Newdescription;
        this.surface = Newsurface;
        this.location = Newlocation;
        this.vente = Newvente;
        this.prixm2 = Newprixm2;
        this.tximpot = Newtximpot;
        this.taxefonciere = calcTaxeFonc();
        this.proprietaire = Newproprietaire;
        this.locataire = Newlocataire;
    }
    // Methodes d'acces (getters)
    public int getRef(){
        return this.reference;
    }
    public String getDesc(){
        return this.description;
    }
    public int getSurface(){
        return this.surface;
    }
    public boolean getLoc(){
        return this.location;
    }
    public boolean getVente(){
        return this.vente;
    }
    public double getPrixm2(){
        return this.prixm2;
    }
    public double getTximpot(){
        return this.tximpot;
    }
    public double getTaxefonciere(){
        return  this.taxefonciere;
    }
    public Proprietaire getProprietaire(){
        return this.proprietaire;
    }
    public String getLocataire(){
        return this.locataire.getIdentite();
    }
    // Methodes de modification (setters)
    public void setRef(int Newreference){

        this.reference = Newreference;
    }
    public void setDesc(String Newdescription){
        this.description = Newdescription;
    }
    public void setSurface(int Newsurface){
    if(Newsurface < 0){
            System.out.println("La surface ne peut pas etre negative");
    }
    else{
        this.surface = Newsurface;
    }
    }
    public void setLoc(boolean Newlocation){
        this.location = Newlocation;
    }
    public void setVente(boolean Newvente){
        this.vente = Newvente;
    }
    public void setPrixm2(double Newprixm2){
        if(Newprixm2 == 0){
            System.out.println("Le prix au m2 ne peut pas etre nul");
        }
        else if(Newprixm2 > 0){
            this.prixm2 = Newprixm2;
        }
        else{
            System.out.println("Le prix au m2 ne peut pas etre negatif");
        }
    }
    public void setTximpot(double Newtximpot){
        if(Newtximpot < 0){
            System.out.println("Le taux d'impot ne peut pas etre negatif");
        }
        else if(Newtximpot > 1){
            System.out.println("Le taux d'impot ne peut pas etre superieur a 1");
        }
        else{
            this.tximpot = Newtximpot;
        }
        this.tximpot = Newtximpot;
    }
    public void setTaxefonciere(double Newtaxefonciere){
        this.taxefonciere = Newtaxefonciere;
    }

    public void setProprietaire(Proprietaire Newproprietaire){
        this.proprietaire = Newproprietaire;
    }
    public void setLocataire(Locataire Newlocataire){
        this.locataire = Newlocataire;
    }
    public String toString(){
        return "BienImmobilier [reference=" + this.reference + ", description=" + description + ", surface=" + surface + ", location=" + location + ", vente=" + vente + ", prixm2=" + prixm2 + ", tximpot=" + tximpot + ", taxefonciere=" + taxefonciere + 
        ", proprietaire=" + proprietaire.getIdentite() + ", locataire=" + locataire.getIdentite() +"]";
    }
    private double calcTaxeFonc(){
        /*  
         * Le cout de sa taxe fonciere est obtenue en multipliant
         * la surface le tarif au m2 et le nombre de mois de l'annee
         * On retient ensuite 50% de cette somme
         * Puis on multiplie par le taux d'impot
         */
        double taxe;
        double loyertheorique = this.surface * this.prixm2 * 12;
        double retenue = loyertheorique * 0.50;
        double abbatement = retenue * 0.50;
        double revenu_cadastral = abbatement * this.tximpot;
        taxe = Math.round((revenu_cadastral*100)/100);
        return taxe;
    }

    /*
     * Comparaison de la taxe fonciere de deux biens immobiliers
     * Return 1 si t1 > t2
     * Return -1 si t1 < t2
     * Return 0 si t1 = t2
     */
    public int compareTaxeFonc(double t1, double t2){
        if(t1 > t2){
            return 1;
        }
        else if(t1 < t2){
            return -1;
        }
        else{
            return 0;
        }
    }
}
