public class DocURL extends DocBibliotheque{
    private String url;
    
    public DocURL(String codearch, String titre, String auteur, int annee, int status, String url){
        super(codearch,titre,auteur,annee,status);
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }

    public String toString(){
        return super.toString() + " " + this.url;
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

}