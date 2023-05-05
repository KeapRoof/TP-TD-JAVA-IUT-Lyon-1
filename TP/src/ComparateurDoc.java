import java.util.*;

public class ComparateurDoc implements Comparator<DocBibliotheque>{
    
    public int compare(DocBibliotheque d1,DocBibliotheque d2){
        int res;
        res = d1.getTitre().compareTo(d2.getTitre());
        return res;
    }
}
