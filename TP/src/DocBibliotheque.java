public class DocBibliotheque {
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

    // TP2
    public String toString(){
        return 
        "le code du doc est " + this.codearch + 
        " le titre est " + this.titre + 
        " l'auteur est " + this.auteur +
        " l'année est " + this.annee +
        " l'emprunteur est " + this.emprunteur.getNom() +
        " le reserveur est " + this.reserveur.getNom() ;
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


    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = pile reservation
    public boolean emprunter(MembreBibliotheque emprunteur){
        boolean verite = false;
        if (this.status == 0){
            // TP2
            this.emprunteur = emprunteur;
            this.status = 1;
            // TP2
            nbemprunt ++;
            verite = true;
        }
        else if(this.status == 3){
            if(this.reserveur == emprunteur){
            // TP2
            this.emprunteur = emprunteur;
            this.status = 1;
            this.reserve = false;
            // TP2
            nbreserv --;
            nbemprunt ++;
            verite = true;
            }
        }
        return verite;
    }
    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = Pile reservation
    public boolean reserver(MembreBibliotheque reserveur){
        boolean verite = false;
        if(this.reserve == true){
            System.out.println("Le document est deja reserve");
        }
        else if(this.status == 0){
            System.out.println("Vous pouvez allez l'emprunter directement");
        }
        else{
            if(this.status == 2){
                this.reserve = true;
                this.status = 3;
                // TP2
                this.reserveur = reserveur;
                nbpile --;
                nbreserv ++;
                verite = true;
            }
            else{
                if(reserveur != this.emprunteur){
                    this.reserve = true;
                    // TP2
                    this.reserveur = reserveur;
                    nbreserv ++;
                    verite = true;
                }
            }   
        }
        return verite;
    }

    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = Section reservation
    public boolean rendre(){
        boolean verite = false;
        if (this.status == 1 && this.reserve == false){
            this.status = 2;
            // TP2
            this.emprunteur = null;
            nbemprunt --;
            nbpile ++;
            verite = true;
        }
        else if (this.status == 1 && this.reserve == true){
            this.status = 3;
            // TP2
            this.emprunteur = null;
            nbemprunt --;
            nbreserv ++;
            verite = true;
        }
        return verite;
    }
    // 0 = sur les étagères
    // 1 = emprunter
    // 2 = sur la pile des rendu
    // 3 = se reservation
    public boolean annulerReservation(MembreBibliotheque annuleur){
        boolean verite = false;
        if (this.reserve = true){
            if(annuleur == this.reserveur){
                if(this.status == 1){
                    this.reserve = false;
                    // TP2
                    this.reserveur = null;
                    nbreserv --;
                    verite = true;
                }
                else{
                    this.reserve = false;
                    this.status = 2;
                    // TP2
                    this.reserveur = null;
                    nbreserv --;
                    nbpile ++;
                    verite = true;
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
        if (this.status == 3){
            this.status = 0;
            // TP2
            nbpile --;
            verite = true;
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
}
