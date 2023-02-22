import java.util.*;
public class TestOccupation {
    private static Scanner ent = new Scanner(System.in);
    BienImmobilier object;
    int choix;

    private static BienImmobilier Appartement = new BienImmobilier("Appartement",110,true,false,200,0.2,null,null);
    private static BienImmobilier Maison = new BienImmobilier("Maison",200,true,false,300,0.2,null,null);
    private static Locataire loc1 = new Locataire("Mohamed","Rue de la paix",1000);
    private static Locataire loc2 = new Locataire("Yacine","Rue de la guerre",500);
    private static Proprietaire prop1 = new Proprietaire("Youssef",true,"Bd de la justice",0.1);
    private static Proprietaire prop2 = new Proprietaire("Lakhdar",false,"Bd de la chance",0.2);


    public static void main(String[] args){
        Appartement.setLocataire(loc1);
        Maison.setLocataire(loc2);
        loc1.setOccupe(Appartement);
        loc2.setOccupe(Maison);
        Appartement.setProprietaire(prop1);
        Maison.setProprietaire(prop2);
        int choix;
        BienImmobilier choisis_b;
        Proprietaire choisis_p;
        Locataire choisis_l;

        do{
            System.out.println("Veuillez choisir une option");
            System.out.println("0 = Quitter le programme");
            System.out.println("1 = Obtenir le locataire");
            System.out.println("2 = Obtenir le propriétaire");
            System.out.println("3 = Obtenir Adresse du propriétaire");
            System.out.println("4 = Obtenir le loyer du Locataire");
            choix = ent.nextInt();
            switch(choix){
                case 0:
                    break;
                case 1:
                choisis_b = choisir_bien();
                System.out.println(choisis_b.getLocataire());
                break;
                case 2:
                choisis_b = choisir_bien();
                System.out.println(choisis_b.getProprietaire());
                break;
                case 3:
                    choisis_p = choisir_pro();
                    System.out.println("L'adresse de " + choisis_p.getIdentite()  + " est " + choisis_p.getAdresse());
                    break;
                case 4:
                    choisis_l = choisir_loc();
                    System.out.println("Le loyer de "+ choisis_l.getIdentite() +" est de " + choisis_l.getLoyer());
                default:
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