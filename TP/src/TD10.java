import java.util.*;

import javax.print.Doc;

public class TD10 {

    private static DocBibliotheque cd1 = new CD("004 178 K20PM", "Caméléon", "ZKR",2022, 0, new String[]{"chanson1", "chanson2", "chanson3"});
    private static DocBibliotheque url1 = new DocURL("004 178 K20PM","Thèse de Rachid", "Rachid", 2022, 0, "www.rachid.com","Thèse portant sur la théorie des cordes");
    private static DocBibliotheque livre1 = new Livre("004 882", "Livre de Rachid", "Rachid", 2022, 0,200,69200,"Hatier");
    private static DocBibliotheque cd2 = new CD ("HEHEHE","Zebre","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    private static DocBibliotheque cd3 = new CD ("HOHOHO","Pasteque","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    private static DocBibliotheque cd4 = new CD ("HEZHEZ","Banane","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    private static DocBibliotheque cd5 = new CD ("AZEHE","Pomme","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
  
 
    public static void main(String args[]){
        Comparator<DocBibliotheque> comp = new ComparateurDoc();
        Set set = new TreeSet<DocBibliotheque>(comp);
        Map map = new HashMap<Integer,String>();
        Map map2 = new TreeMap<Integer,String>();
        //Set

        //Map
        map.put(1,"un");
        map.put(2,"deux");
        map.put(3,"trois");
        map.put(6,"six");
        map.put(4,"quatre");
        map.put(5,"cinq");

        //Affichage
        System.out.println("Affichage de la map");
        Set set2 = map.entrySet();
        Iterator it2 = set2.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next().toString());
        }
    
    }
}
