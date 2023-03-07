import java.util.*;

import javax.print.Doc;

public class TestBibliotheque {
    private static DocBibliotheque doc1 = new DocBibliotheque("004 178 K20PM", "Introduction a Java", "J.Leblanc", 2015, 0);
    private static DocBibliotheque doc2 = new DocBibliotheque("9674987T248O", "Structure de données", "M.Machin", 2022, 0);
    // TP2
    private static MembreBibliotheque membre1 = new MembreBibliotheque("Haithem", "Hadj Azzem", 0606060606,   "1 rue de la paix");
    private static MembreBibliotheque membre2 = new MembreBibliotheque("Mohamed", "Belkhatir", 0707070707,   "2 rue de la paix");
    private static MembreBibliotheque membre3 = new MembreBibliotheque("Rachid", "Fekir", 0707070707,   "2 rue de la paix");

    private static Scanner ent = new Scanner(System.in);
    //TP4
    private static CatalogueBibliotheque cat1 = new CatalogueBibliotheque();
    private static ListeMembre lis1 = new ListeMembre();
    public static void main(String[] args){

        System.out.println("Bienvenue dans la bibliotheque");
        int choix;
        int choix2;
        DocBibliotheque choisis_d;
        MembreBibliotheque choisis_m;
        cat1.ajdoc(doc1);
        cat1.ajdoc(doc2);
        lis1.ajmembre(membre1);
        lis1.ajmembre(membre2);
        lis1.ajmembre(membre3);

        do{
            System.out.println();
            System.out.println("Veuillez choisir une option");
            System.out.println("0 = Quitter le programme");
            System.out.println("1 = Obtenir les info d'un doc");
            System.out.println("2 = Emprunter un doc");
            System.out.println("3 = Rendre un doc");
            System.out.println("4 = Remise sur etagère");
            System.out.println("5 = Reserver");
            System.out.println("6 = Annuler reservation");
            System.out.println("7 = Nombre d'emprunt");
            System.out.println("8 = Nombre de doc dans pile");
            System.out.println("9 = Nombre de doc dans section reservation");
            choix = ent.nextInt();
            switch(choix){
                case 0:
                    System.out.println("Fin du programme !");
                    System.exit(0);
                    break;
                case 1:
                    menudoc();
                break;
                case 2:
                    choisis_m = choixmembre2();
                    choix2 = choixdoc2();
                    cat1.emprunterdoc(choix2, choisis_m);
                    break;
                case 3:
                    choisis_d = choisir_doc();
                    choisis_d.rendre();
                    break;
                case 4:
                    choisis_d = choisir_doc();
                    choisis_d.remisesuretagere();
                    break;
                case 5:
                    choisis_m = choixmembre2();
                    choix2 = choixdoc2();
                    cat1.reservedoc(choix2, choisis_m);
                    break;
                case 6:
                    choisis_m = choixmembre2();
                    choix2 = choixdoc2();
                    cat1.annulresa(choix2, choisis_m);
                    break;
                case 7:
                    System.out.println("Le nombre de doc emprunter est : " + DocBibliotheque.nbemprunt);
                    break;
                case 8:
                    System.out.println("Le nombre de doc dans la pile de rendu est : " + DocBibliotheque.nbpile);
                    break;
                case 9:
                    System.out.println("Le nombre de doc dans la section reservation est : " + DocBibliotheque.nbreserv);
                    break;
                default:
                    break;
            }
        }
        while (choix != 0);
}

private static DocBibliotheque choisir_doc(){
    DocBibliotheque c = null;
    int opt;
    do{
        System.out.println();
        System.out.println("1 = doc1  ou 2 = doc2");
        opt = ent.nextInt();
        ent.nextLine();
        switch(opt){
            case 1: 
                c = doc1;
                break;
            case 2:
                c = doc2;
                break;
            default:
                System.out.println("Option invalide !");
        }
    } while(opt != 1 && opt !=2);
    return c;
}

private static MembreBibliotheque choisir_mem(){
    MembreBibliotheque c = null;
    int opt;
    do{
        System.out.println();
        System.out.println("1 = membre1  ou 2 = membre2");
        opt = ent.nextInt();
        ent.nextLine();
        switch(opt){
            case 1: 
                c = membre1;
                break;
            case 2:
                c = membre2;
                break;
            default:
                System.out.println("Option invalide !");
        }

    } while(opt != 1 && opt !=2);
    return c;
}

private static void menudoc(){
        int choix;
        DocBibliotheque choisis_d;
        do {
            System.out.println();
            System.out.println("Veuillez choisir une option");
            System.out.println("0 = Sortir du menu doc");
            System.out.println("1 = Obtenir le titre d'un doc");
            System.out.println("2 = Obtenir le code archive");
            System.out.println("3 = Obtenir le status d'un doc");
            System.out.println("4 = Identité emprunteur");
            System.out.println("5 = Identité reserveur");
            choix = ent.nextInt();
            ent.nextLine();
            switch(choix){
                case 0:
                System.out.println("Fin du menu doc !");
                break;
                case 1:
                    choisis_d = choisir_doc();
                    System.out.println("Le tire est : "+ choisis_d.getTitre());
                break;
                case 2:
                    choisis_d = choisir_doc();
                    System.out.println("Le code archive est : "+ choisis_d.getCodearch());
                break;
                case 3:
                    choisis_d = choisir_doc();
                    System.out.println("Le status du doc est : " + choisis_d.trad());
                    break;
                case 4:
                    choisis_d = choisir_doc();
                    System.out.println("L'identité de l'emprunteur est : " + choisis_d.getEmprunteur());
                    break;
                case 5:
                choisis_d = choisir_doc();
                System.out.println("L'identité du reserveur est : " + choisis_d.getReserveur());
                    break;
                default:
                    break;
                }
            }while(choix != 0);
    }

    private static int choixdoc2(){
        int choix;
        DocBibliotheque choix_d;
        do{
            cat1.affichedoc();
            System.out.println();
            System.out.println("Veuillez choisir l'index du doc(0 pour quitter)");
            choix = ent.nextInt();
            ent.nextLine();
            choix_d = cat1.accesBibliotheque(choix);
        }while (choix_d == null);
        return choix;
    }

    private static MembreBibliotheque choixmembre2(){
        int choix;
        MembreBibliotheque choisis_m;
        do{
            lis1.affichecarmem();;
            System.out.println();
            System.out.println("Veuillez choisir l'index du membre");
            choix = ent.nextInt();
            ent.nextLine();
            choisis_m = lis1.renvoimem(choix);
        }while (choisis_m == null);
        return choisis_m;
    }
}
