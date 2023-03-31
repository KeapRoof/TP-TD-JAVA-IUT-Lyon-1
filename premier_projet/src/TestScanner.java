import java.io.*;
import java.util.Scanner;

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

public static void main(String[] args) throws Exception{
    Scanner sc = new Scanner(new File("C:/Users/Haithem/Desktop/liste-successeurs.csv"), "UTF-8");  
    sc.useDelimiter(";");   //sets the delimiter pattern  
    while (sc.hasNext())  //returns a boolean value  
        {
            if(sc.next().contains("S")) //find and returns the next complete token from this scanner
            {
                
                public static MaillonGraphe sc.next() = new MaillonGraphe("Add", "Sdd");
            }
            System.out.print(sc.next().replaceAll("S",""));  //find and returns the next complete token from this scanner 
            
            System.out.print(" "); 
    }   
    sc.close();  //closes the scanner  

}
}