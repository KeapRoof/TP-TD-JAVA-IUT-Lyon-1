import java.util.*;
public class TestBibliotheque {
    private static DocBibliotheque doc1 = new DocBibliotheque("004 178 K20PM", "Introduction a Java", "J.Leblanc", 2015, 0);
    private static DocBibliotheque doc2 = new DocBibliotheque("9674987T248O", "Structure de données", "M.Machin", 2022, 0);
    // TP2
    private static MembreBibliotheque membre1 = new MembreEtudiant("Haithem", "Hadj Azzem", 0606060606,   "1 rue de la paix");
    private static MembreBibliotheque membre2 = new MembrePersonnel("Mohamed", "Belkhatir", 0707070707,   "2 rue de la paix");
    private static MembreBibliotheque membre3 = new MembrePersonnel("Rachid", "Fekir", 0707070707,   "2 rue de la paix");

    private static Scanner ent = new Scanner(System.in);
    //TP4
    private static CatalogueBibliotheque cat1 = new CatalogueBibliotheque();
    private static ListeMembre lis1 = new ListeMembre();
    //TP5
    private static DocBibliotheque cd1 = new CD("004 178 K20PM", "Caméléon", "ZKR",2022, 0, new String[]{"chanson1", "chanson2", "chanson3"});
    private static DocBibliotheque url1 = new DocURL("004 178 K20PM","Thèse de Rachid", "Rachid", 2022, 0, "www.rachid.com","Thèse portant sur la théorie des cordes");
    private static DocBibliotheque livre1 = new Livre("004 882", "Livre de Rachid", "Rachid", 2022, 0,200,69200,"Hatier");
    private static DocBibliotheque cd2 = new CD ("HEHEHE","Zebre","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    private static DocBibliotheque cd3 = new CD ("HEHEHE","Pasteque","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    private static DocBibliotheque cd4 = new CD ("HEHEHE","Banane","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    private static DocBibliotheque cd5 = new CD ("HEHEHE","Pomme","Naps",2022,0,new String[]{"chanson1","chanson2","chanson3"});
    public static void main(String[] args){

        System.out.println("Bienvenue dans la bibliotheque");
        int choix;
        int choix2;
        int choisis_d;
        MembreBibliotheque choisis_m;
        cat1.ajdoc(doc1);
        cat1.ajdoc(doc2);
        lis1.ajmembre(membre1);
        lis1.ajmembre(membre2);
        lis1.ajmembre(membre3);
        cat1.ajdoc(cd1);
        cat1.ajdoc(url1);
        cat1.ajdoc(livre1);
        cat1.ajdoc(cd2);
        cat1.ajdoc(cd3);
        cat1.ajdoc(cd4);
        cat1.ajdoc(cd5);

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
            System.out.println("10 = Nombre de CD");
            System.out.println("11 = Nombre de Livre");
            System.out.println("12 = Obtenir les info d'un membre");
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
                    choisis_d = choixdoc2();
                    cat1.rendredoc(choisis_d);
                    break;
                case 4:
                    choisis_d = choixdoc2();
                    cat1.accesBibliotheque(choisis_d).remisesuretagere();
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
                case 10:
                    System.out.println("Le nombre de CD est : " + TestBibliotheque.compteCD());
                    break;
                case 11:
                    System.out.println("Le nombre de Livre est : " + TestBibliotheque.compteLivre());
                    break;
                case 12:
                    menumem();
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
        int choisis_d;
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
                    choisis_d = choixdoc2();
                    System.out.println("Le tire est : "+ cat1.accesBibliotheque(choisis_d).getTitre());
                break;
                case 2:
                    choisis_d = choixdoc2();
                    System.out.println("Le code archive est : "+ cat1.accesBibliotheque(choisis_d).getCodearch());
                break;
                case 3:
                    choisis_d = choixdoc2();
                    System.out.println("Le status du doc est : " + cat1.accesBibliotheque(choisis_d).trad());
                    break;
                case 4:
                    choisis_d = choixdoc2();
                    System.out.println("L'identité de l'emprunteur est : " + cat1.accesBibliotheque(choisis_d).getEmprunteur());
                    break;
                case 5:
                choisis_d = choixdoc2();
                System.out.println("L'identité du reserveur est : " + cat1.accesBibliotheque(choisis_d).getReserveur());
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

    private static int compteLivre(){
        int compteur = 0;
        for (int i = 0; i < cat1.nbdoc(); i++) {
            if (cat1.accesBibliotheque(i) instanceof Livre) {
                compteur++;
            }
        }
        return compteur;
    }

    private static int compteCD(){
        int compteur = 0;
        for (int i = 0; i < cat1.nbdoc(); i++) {
            if (cat1.accesBibliotheque(i) instanceof CD) {
                compteur++;
            }
        }
        return compteur;
    }

private static void menumem(){
        int choix;
        MembreBibliotheque choisis_m;
        do {
            System.out.println();
            System.out.println("Veuillez choisir une option");
            System.out.println("0 = Sortir du menu membre");
            System.out.println("1 = Obtenir le prenom d'un membre");
            System.out.println("2 = Obtenir le nom d'un membre");
            System.out.println("3 = Obtenir le code d'un membre");
            System.out.println("4 = Obtenir le nombre de doc emprunté");
            choix = ent.nextInt();
            ent.nextLine();
            switch(choix){
                case 0:
                System.out.println("Fin du menu doc !");
                break;
                case 1:
                    choisis_m = choixmembre2();
                    System.out.println("Le prenom : "+ choisis_m.getPrenom());
                break;
                case 2:
                    choisis_m = choixmembre2();
                    System.out.println("Le nom : "+ choisis_m.getNom());
                break;
                case 3:
                    choisis_m = choixmembre2();
                    System.out.println("Le code : " + choisis_m.getNumeroabonne());
                    break;
                case 4:
                    choisis_m = choixmembre2();
                    System.out.println("Le nombre de doc emprunter : " + choisis_m.getnbdocempruntes());
                    break;
                default:
                    break;
                }
            }while(choix != 0);
    }

}
