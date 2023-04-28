import java.util.*;

public class TESTPERF {
    
    //Tableau de 100000 DocBibliotheque
    public static DocBibliotheque[] tab = new DocBibliotheque[100000];
    public static DocBibliotheque[] tabT = new DocBibliotheque[100000];

    //Ajout de 100000 DocBibliotheque(CD) dans le tableau
    public static void ajoutCD(){
        for(int i = 0; i < 100000; i++){
            tab[i] = new CD("CD"+i,"Auteur"+i,null, 60, i, null);
        }
    }

    public static List listA = new ArrayList<DocBibliotheque>();
    public static List listL = new LinkedList<DocBibliotheque>();

    // Evaluation du temps d'execution de la methode add() de ArrayList
    public static void addArrayList(){
        long startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            listA.add(tab[i]);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Ajout : ArrayList : "+duration+" ns");
    }

    // Evaluation du temps d'execution de la methode add() de LinkedList
    public static void addLinkedList(){
        long startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            listL.add(tab[i]);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Ajout : LinkedList : "+duration+" ns");
    }

    public static void addTab(){
        long startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            tabT[i] = tab[i];
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Ajout : Tableau : "+duration+" ns");
    }

    public static void SearchValArrayList(DocBibliotheque doc){
        long startTime = System.nanoTime();
        listA.contains(doc);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Recherche : ArrayList : "+duration+" ns");
    }
    
    public static void SearchValLinkedList(DocBibliotheque doc){
        long startTime = System.nanoTime();
        listL.contains(doc);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Recherche : LinkedList : "+duration+" ns");
    }

    public static void SearchValTab(DocBibliotheque doc){
        long startTime = System.nanoTime();
        for(int i = 0; i < 100000; i++){
            if(tabT[i] == doc){
                break;
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Recherche : Tableau : "+duration+" ns");
    }

    public static void main(String[] args){
        ajoutCD();
        addArrayList();
        addLinkedList();
        addTab();
        SearchValArrayList(tab[50000]);
        SearchValLinkedList(tab[50000]);
        SearchValTab(tab[50000]);
    }
}
