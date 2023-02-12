import java.util.ArrayList;

public class DocBibliotheque {
    private String codearch;
    private String titre;
    private String auteur;
    private int annee;
    private int status;
    private boolean reserve;
    public  ArrayList<String> pile = new ArrayList<String>();
    public static int nbemprunt = 0;

    public DocBibliotheque(String codearch, String titre, String auteur, int annee, int status){
        this.codearch = codearch;
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.status = status;
        this.reserve = false;
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

    public ArrayList<String> getpile(){
        return this.pile;
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

    public boolean emprunter(){
        boolean verite = true;
        if (this.status == 0){
            this.status = 1;
        }
        else if (this.reserve == false){
            this.reserve = true;
            this.status = 1;
        }
        else if(this.status == 1){
            verite = false;
        }
        return verite;
    }

    public boolean rendre(){
        boolean verite = true;
        if (this.status == 1){
            pile.add(this.codearch);
        }
        else if (this.status == 0){
            verite = false;
        }
        return verite;
    }

    public boolean annulerReservation(){
        boolean verite = true;
        if (this.reserve == true){
            this.reserve = false;
        }
        else if(this.status == 1){
            this.status = 0;
            verite = false;
        }
        return verite;
    }

    public boolean remisesuretagere(){
        boolean verite = true;
        if (this.status == 1){
            this.status = 0;
            pile.remove(this.codearch);
        }
        else if (this.status == 0){
            verite = false;
        }
        return verite;
    }

    public boolean est_emprunter(){
        boolean verite = true;
        if (this.status == 1){
            verite = true;
        }
        else if (this.status == 0){
            verite = false;
        }
        return verite;
    }

    public boolean est_reserve(){
        boolean verite = true;
        if (this.reserve == true){
            verite = true;
        }
        else if (this.reserve == false){
            verite = false;
        }
        return verite;
    }

    public void reserver(){
        if (this.reserve == false){
            this.reserve = true;
        }
    }

    public boolean estVide(){
        boolean verite = true;
        if (pile.isEmpty()){
            verite = true;
        }
        else if (!pile.isEmpty()){
            verite = false;
        }
        return verite;
    }
}
