import java.util.*;
public class TestOccupation {
    private static Scanner ent = new Scanner(System.in);
    BienImmobilier object;
    int choix;

    private static AgenceImmobiliere agence1 = new AgenceImmobiliere();
    private static BienImmobilier Appartement = new BienImmobilier("Appartement",110,true,false,200,0.2,null,null);
    private static BienImmobilier Maison = new BienImmobilier("Maison",200,true,false,300,0.2,null,null);
    private static Locataire loc1 = new Locataire("Mohamed","9 Rue de la paix",1000);
    private static Locataire loc2 = new Locataire("Yacine","5 Rue de la guerre",500);
    private static Proprietaire prop1 = new Proprietaire("Youssef",true,"2 Bd de la justice",0.1);
    private static Proprietaire prop2 = new Proprietaire("Lahkdar",false,"3 Bd de la chance",0.2);


    public static void main(String[] args){
        Appartement.setLocataire(loc1);
        Maison.setLocataire(loc2);
        loc1.setOccupe(Appartement);
        loc2.setOccupe(Maison);
        Appartement.setProprietaire(prop1);
        Maison.setProprietaire(prop2);
        agence1.ajouterBien(Appartement);
        agence1.ajouterBien(Maison);
        agence1.afficherbiens();
        agence1.supprimerbien(0);
        System.out.println("Après suppression du bien 0");
        agence1.afficherbiens();

        
        int choix;
        BienImmobilier choisis_b;
        Proprietaire choisis_p;
        Locataire choisis_l;
        String nom;
        do{
            System.out.println();
            System.out.println("Veuillez choisir une option");
            System.out.println("0 = Quitter le programme");
            System.out.println("1 = Obtenir le locataire");
            System.out.println("2 = Obtenir le propriétaire");
            System.out.println("3 = Obtenir Adresse du propriétaire");
            System.out.println("4 = Obtenir le loyer du Locataire");
            System.out.println("5 = Changer nom Locataire");
            System.out.println("6 = Changer nom Proprio");
            System.out.println("7 = Obtenir reference bien");
            System.out.println("8 = Affiche les biens de l'agence");
            System.out.println("Que souhaitez vous faire ?");
            choix = ent.nextInt();
            switch(choix){
                case 0:
                    System.out.println("Fin du programme !");
                    System.exit(0);
                    break;
                case 1:
                choisis_b = choisir_bien();
                System.out.println("Le locataire du bien est : " + choisis_b.getLocataire());
                break;
                case 2:
                choisis_b = choisir_bien();
                System.out.println("Le propriétaire est : "+ choisis_b.getProprietaire());
                break;
                case 3:
                    choisis_p = choisir_pro();
                    System.out.println("L'adresse de " + choisis_p.getIdentite() + " est " + choisis_p.getAdresse());
                    break;
                case 4:
                    choisis_l = choisir_loc();
                    System.out.println("Le loyer de "+ choisis_l.getIdentite() +" est de " + choisis_l.getLoyer());
                    break;
                case 5:
                    choisis_l = choisir_loc();
                    System.out.println("Entrez le nom du nouveaux loc");
                    nom = ent.nextLine();
                    choisis_l.setIdentite(nom);
                    System.out.println("Le nom du locataire a était changé");
                    break;
                case 6:
                    choisis_p = choisir_pro();
                    System.out.println("Entrez le nom du nouveaux loc");
                    nom = ent.nextLine();
                    choisis_p.setIdentite(nom);
                    System.out.println("Le nom du locataire a était changé");
                    break;
                case 7:
                    choisis_b = choisir_bien();
                    System.out.println("La réference du bien est : "+choisis_b.getRef());
                    break;
                case 8:
                    agence1.afficherbiens();
                    break;
                default:
                    System.err.println("Veuillez choisir une action correcte");
                    break;
            }
        } 
        while (choix != 0);
}

private static BienImmobilier choisir_bien(){
    BienImmobilier c = null;
    int opt;
    do{
        System.out.println("1 = Appartement  ou 2 = Maison");
        opt = ent.nextInt();
        ent.nextLine();
        switch(opt){
            case 1: 
                c = Appartement;
                break;
            case 2:
                c = Maison;
                break;
            default:
                System.out.println("Option invalide !");
        }

    } while(opt != 1 && opt !=2);
    return c;
}

private static Locataire choisir_loc(){
    Locataire c = null;
    int opt;
    do{
        System.out.println("1 = Mohamed  ou 2 = Yacine");
        opt = ent.nextInt();
        ent.nextLine();
        switch(opt){
            case 1: 
                c = loc1;
                break;
            case 2:
                c = loc2;
                break;
            default:
                System.out.println("Option invalide !");
        }

    } while(opt != 1 && opt !=2);
    return c;
}

private static Proprietaire choisir_pro(){
    Proprietaire c = null;
    int opt;
    do{
        System.out.println("1 = Youcef  ou 2 = Lahkdar");
        opt = ent.nextInt();
        ent.nextLine();
        switch(opt){
            case 1: 
                c = prop1;
                break;
            case 2:
                c = prop2;
                break;
            default:
                System.out.println("Option invalide !");
        }

    } while(opt != 1 && opt !=2);
    return c;
}


}