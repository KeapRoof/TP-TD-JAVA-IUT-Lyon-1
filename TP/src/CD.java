import java.util.*;
public class CD extends DocBibliotheque{
    private String[] chansons;
    
    public CD(String codearch, String titre, String auteur, int annee, int status, String[] chansons){
        super(codearch,titre,auteur,annee,status);
        this.chansons = chansons;
    }

    public String[] getChansons(){
        return this.chansons;
    }

    public String toString(){
        return super.toString() + " " + Arrays.toString(this.chansons);
    }
}
