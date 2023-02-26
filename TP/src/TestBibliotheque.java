import java.util.*;
public class TestBibliotheque {
    private static DocBibliotheque doc1 = new DocBibliotheque("004 178 K20PM", "Introduction a Java", "J.Leblanc", 2015, 0);
    private static DocBibliotheque doc2 = new DocBibliotheque("9674987T248O", "Structure de données", "M.Machin", 2022, 0);
    // TP2
    private static MembreBibliotheque membre1 = new MembreBibliotheque("Haithem", "Hadj Azzem", 0606060606,   "1 rue de la paix");
    private static MembreBibliotheque membre2 = new MembreBibliotheque("Mohamed", "Belkhatir", 0707070707,   "2 rue de la paix");
    private static Scanner ent = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Le code est : " + doc1.getCodearch());
        System.out.println("Le code est : " + doc2.getCodearch());
        System.out.println("Le titre est : " + doc1.getTitre());
        System.out.println("Le titre est : " + doc2.getTitre());
        System.out.println("L'auteur est : " + doc1.getAuteur());
        System.out.println("L'auteur est : " + doc2.getAuteur());
        System.out.println("L'annee est : " + doc1.getAnnee());
        System.out.println("L'annee est : " + doc2.getAnnee());
        System.out.println("Oups il semble que le code de l'auteur soit incorrect");
        doc1.setCodearch("123456789");
        doc2.setCodearch("987654321");
        System.out.println("Voici le bon code est : " + doc1.getCodearch());
        System.out.println("Voici le bon code est : " + doc2.getCodearch());
        System.out.println("Le document 1 est il emprunter ? : " + doc1.est_emprunter());
        // TP2
        doc1.emprunter(membre1);
        System.out.println("Je l'emprunte alors !");
        System.out.println("Le document 1 est il emprunter ? : " + doc1.est_emprunter());
        System.out.println("Le document 1 est il emprunter maintenant ? : " + doc1.est_emprunter());
        System.out.println("Le document 1 est il reserve ? : " + doc1.est_reserve());
        // TP2
        doc1.reserver(membre2);
        System.out.println(doc1.toString());
        System.out.println("Je le reserve alors !");
        System.out.println("Le document 1 est il reserve maintenant? : " + doc1.est_reserve());
        System.out.println("Il est temps de le rendre");
        doc1.rendre();
        System.out.println("Le document 1 est maintenant sur la pile des rendu");
        System.out.println("Le document 1 est il emprunter maintenant ? : " + doc1.est_emprunter());
        System.out.println("La bibliothècaire le remet sur les étagères");
        doc1.remisesuretagere();
        System.out.println("Le document 1 est il emprunter maintenant ? : " + doc1.est_emprunter());

        int choix;
        DocBibliotheque choisis_d;
        MembreBibliotheque choisis_m;
        do{
            System.out.println();
            System.out.println("Veuillez choisir une option");
            System.out.println("0 = Quitter le programme");
            System.out.println("1 = Obtenir le titre d'un doc");
            System.out.println("2 = Obtenir le code archive");
            System.out.println("3 = Obtenir le status d'un doc");
            System.out.println("4 = Emprunter un doc");
            System.out.println("5 = Rendre un doc");
            System.out.println("6 = Remise sur etagère");
            System.out.println("7 = Reserver");
            System.out.println("8 = Annuler reservation");
            System.out.println("9 = Nombre d'emprunt");
            System.out.println("10 = Nombre de doc dans pile");
            System.out.println("11 = Nombre de doc dans section reservation");
            System.out.println("12 = Identité emprunteur");
            System.out.println("13 = Identité reserveur");
            choix = ent.nextInt();
            switch(choix){
                case 0:
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
                    int d = choisis_d.getStatus();
                    if(d == 0){
                        System.out.println("Sur étagère");
                    }
                    else if(d == 1){
                        System.out.println("En cours d'emprunt");
                    }
                    else if(d == 2){
                        System.out.println("Sur pile rendu");
                    }
                    else{
                        System.out.println("Dans section spéciale réservation");
                    }
                    break;
                case 4:
                    choisis_m = choisir_mem();
                    choisis_d = choisir_doc();
                    choisis_d.emprunter(choisis_m);
                    break;
                case 5:
                    choisis_d = choisir_doc();
                    choisis_d.rendre();
                    break;
                case 6:
                    choisis_d = choisir_doc();
                    choisis_d.remisesuretagere();
                    break;
                case 7:
                    choisis_m = choisir_mem();
                    choisis_d = choisir_doc();
                    choisis_d.reserver(choisis_m);
                    break;
                case 8:
                    choisis_m = choisir_mem();
                    choisis_d = choisir_doc();
                    choisis_d.annulerReservation(choisis_m);
                    break;
                case 9:
                    System.out.println("Le nombre de doc emprunter est : " + DocBibliotheque.nbemprunt);
                    break;
                case 10:
                    System.out.println("Le nombre de doc dans la pile de rendu est : " + DocBibliotheque.nbpile);
                    break;
                case 11:
                    System.out.println("Le nombre de doc dans la section reservation est : " + DocBibliotheque.nbreserv);
                    
                case 12:
                    choisis_d = choisir_doc();
                    System.out.println("L'identité de l'emprunteur est : " + choisis_d.getEmprunteur());
                    break;
                case 13:
                    choisis_d = choisir_doc();
                    System.out.println("L'identité du reserveur est : " + choisis_d.getEmprunteur());
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
        System.out.println("1 = doc1  ou 2 = doc2");
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
}
