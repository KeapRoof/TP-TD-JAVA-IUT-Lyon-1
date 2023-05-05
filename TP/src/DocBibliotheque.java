
public class DocBibliotheque implements Comparable<DocBibliotheque> {
    private String codearch;
    private String titre;
    private String auteur;
    private int annee;
    private int status;
    private boolean reserve;
    // TP2
    public static int nbemprunt = 0;
    public static int nbpile = 0;
    public static int nbreserv = 0;
    private MembreBibliotheque emprunteur;
    private MembreBibliotheque reserveur;
    private CatalogueBibliotheque catalogue;

    public DocBibliotheque(String codearch, String titre, String auteur, int annee, int status){
        this.codearch = codearch;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.status = status;
        this.reserve = false;
        // TP2
        this.emprunteur = null;
        this.reserveur = null;
        this.catalogue = null;
    }

    // TP2    
    public  MembreBibliotheque getEmprunteur(){
        MembreBibliotheque val;
        if(this.emprunteur == null){
            val = null;
        }
        else{
           val = this.emprunteur;
        }
        return val;
    }
    // TP2
    public MembreBibliotheque getReserveur(){
        MembreBibliotheque val;
        if(this.reserveur == null){
            val = null;
        }
        else{
           val = this.reserveur;
        }
        return val;
    }

    public int getStatus(){
        return this.status;
    }

    public String getCodearch(){
        return this.codearch;
    }

    public String getTitre(){
        return this.titre;
    }

    public String getAuteur(){
        return this.auteur;
    }

    public int getAnnee(){
        return this.annee;
    }

    public CatalogueBibliotheque getCatalogue(){
        return this.catalogue;
    }

    // TP2
    public String toString(){
        return 
        "le code du doc est " + this.codearch + 
        " le titre est " + this.titre + 
        " l'auteur est " + this.auteur +
        " l'année est " + this.annee ;
    }

    public void setCodearch(String codearch){
        this.codearch = codearch;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setAnnee(int annee){
        this.annee = annee;
    }

    public void setStatus(int status){
        this.status = status;
    }

    public void setReserve(boolean reserve){
        this.reserve = reserve;
    }

    public void setEmprunteur(MembreBibliotheque emprunteur){
        this.emprunteur = emprunteur;
    }

    public void setReserveur(MembreBibliotheque reserveur){
        this.reserveur = reserveur;
    }

    public void setCatalogue(CatalogueBibliotheque catalogue){
        this.catalogue = catalogue;
    }

    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = pile reservation
    public boolean emprunter(MembreBibliotheque emprunteur) throws ExceptionDoc {
        boolean verite = false;
        if(emprunteur != null){
            if (this.status == 0){
                // TP2
                this.emprunteur = emprunteur;
                this.status = 1;
                // TP2
                nbemprunt ++;
                System.out.println("Un emprunt a été effectué");
                verite = true;
            }
            else if(this.status == 3){
                if(this.reserveur == emprunteur){
                    this.emprunteur = emprunteur;
                    this.reserveur = null;
                    this.status = 1;
                    this.reserve = false;
                    nbreserv --;
                    nbemprunt ++;
                    verite = true;
                    System.out.println("Un emprunt a été effectué");
                }
                else{
                    throw new ExceptionDoc();
                }
            }
            else{
                throw new ExceptionDoc();
            }
        }
        else{
            throw new ExceptionDoc();
        }
        return verite;
}
    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = Pile reservation
    public boolean reserver(Notifiable reserveurpot) throws ExceptionReservation {
        boolean verite = false;
        if(reserveurpot != null  && this.emprunteur != reserveurpot){
            if(this.reserveur == null){
                if(this.getStatus() == 1){
                    this.reserveur = (MembreBibliotheque) reserveurpot;
                    verite = true;
                    this.reserve = true;
                    System.out.println("Un reservation a été effectué");
                }
                else{
                    throw new ExceptionReservation();
                }
            }
            else{
                throw new ExceptionReservation();
            }
        }
        else{
            throw new ExceptionReservation();
        }
        return verite;
    }

    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = Section reservation
    public boolean rendre() throws RetourException{
        boolean verite = false;
        if (this.status == 1 && this.reserve == false){
            this.status = 2;
            // TP2
            this.emprunteur = null;
            nbemprunt --;
            nbpile ++;
            verite = true;
            System.out.println("Un retour a été effectué");
        }
        else if (this.status == 1 && this.reserve == true){
            this.status = 3;
            // TP2
            this.emprunteur = null;
            // Notifier le membre
            this.reserveur.docDisponible(this);
            nbemprunt --;
            nbreserv ++;
            verite = true;
            System.out.println("Un retour a été effectué");
        }
        else{
            throw new RetourException();
        }
        return verite;
    }
    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = se reservation
    public boolean annulerReservation(Notifiable annuleur){
        boolean verite = false;
        if(annuleur != null){
            if (this.reserve == true){
                if((MembreBibliotheque)annuleur  == this.reserveur){
                    if(this.status == 1){
                        this.reserve = false;
                        // TP2
                        this.reserveur = null;
                        verite = true;
                        nbreserv --;
                        System.out.println("Une reservation a été annulé");
                    }
                    else if(this.status == 3){
                        this.reserve = false;
                        this.status = 2;
                        this.reserveur = null;
                        nbreserv --;
                        nbpile ++;
                        verite = true;
                        System.out.println("Une reservation a été annulé");
                    }
                }
            }
        }
        return verite;
    }
    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = Pile reservation
    public boolean remisesuretagere(){
        boolean verite = false;
        if (this.status == 2){
            this.status = 0;
            // TP2
            nbpile --;
            verite = true;
            System.out.println("Un document a été remis sur les étagères");
        }
        return verite;
    }

    public boolean est_emprunter(){
        boolean verite = false;
        if (this.status == 1){
            verite = true;
        }
        else if (this.status == 0){
            verite = false;
        }
        return verite;
    }

    public boolean est_reserve(){
        boolean verite = false;
        if (this.reserve == true){
            verite = true;
        }
        else if (this.reserve == false){
            verite = false;
        }
        return verite;
    }

    public  String trad(){
        int d = this.getStatus();
        String trad;
        if(d == 0){
            trad = "Sur étagère";
        }
        else if(d == 1){
            trad = "En cours d'emprunt";
        }
        else if(d == 2){
            trad = "Sur pile rendu";
        }
        else{
            trad = "Dans section spéciale réservation";
        }
        return trad;
    }

    public int compareTo(DocBibliotheque doc){
        int val;
        val = this.getCodearch().compareTo(doc.getCodearch());
        return val;
    }


}
