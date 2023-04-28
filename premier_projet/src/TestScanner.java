import java.io.*;
import java.util.*;

public class TestScanner{

    class MaillonGraphe {
        private String nom;
        private String type;
        private MaillonGraphe suiv;
        private boolean listed;

        MaillonGraphe(String n, String t) {
            nom = n;
            type = t;
            suiv = null;
            listed = false;
        }
    }

public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(new FileReader("C:/Users/Haithem/Desktop/Java/premier_projet/src/liste-successeurs.csv"));  
    sc.useDelimiter(";"); 
    while (sc.hasNext())
        {
            // Put the next token in the string
            String s = sc.next();
            if(s.contains("S")){
                
            }
            System.out.print(sc.next().replaceAll("S",""));  //find and returns the next complete token from this scanner 
            
            System.out.print(" "); 
    }   
    sc.close();

}
}