public class DocURL extends DocBibliotheque{
    private String url;
    private String desc;

    public DocURL(String codearch, String titre, String auteur, int annee, int status, String url, String desc){
        super(codearch,titre,auteur,annee,status);
        this.url = url;
        this.desc = desc;
    }

    public String getUrl(){
        return this.url;
    }

    public String toString(){
        return super.toString() + " " + this.url + " " + this.desc;
    }

    public boolean emprunter(MembreBibliotheque membre){
        System.out.println("Impossible d'emprunter un document Digital.");
        return false;
    }

    public boolean reserver(MembreBibliotheque membre){
        System.out.println("Impossible de reserver un document Digital.");
        return false;
    }

    public boolean rendre(){
        System.out.println("Impossible de retourner un document Digital.");
        return false;
    }

    public boolean annulerReservation(){
        System.out.println("Impossible d'annuler une reservation pour un document Digital.");
        return false;
    }

    public boolean remisesuretagere(){
        System.out.println("Impossible de remettre un document Digital sur l'etagere.");
        return false;
    }

    public void setStatus(int status){
        System.out.println("Impossible de changer le status d'un document Digital.");
    }

    public void setReserve(boolean reserve){
        System.out.println("Impossible de changer le status de reservation d'un document Digital.");
    }

    public void setEmprunteur(MembreBibliotheque emprunteur){
        System.out.println("Impossible de changer le status d'emprunteur d'un document Digital.");
    }

    public void setReserveur(MembreBibliotheque reserveur){
        System.out.println("Impossible de changer le status de reserveur d'un document Digital.");
    }
}