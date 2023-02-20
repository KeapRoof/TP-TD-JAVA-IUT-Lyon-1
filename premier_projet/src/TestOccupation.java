public class TestOccupation {
    public static void main(String[] args){
        BienImmobilier Appartement = new BienImmobilier("Appartement",110,true,false,200,0.2,null,null);
        BienImmobilier Maison = new BienImmobilier("Maison",200,true,false,300,0.2,null,null);
        Locataire loc1 = new Locataire("Mohamed","Rue de la paix",1000);
        Locataire loc2 = new Locataire("Yacine","Rue de la guerre",500);
        Proprietaire prop1 = new Proprietaire("Youssef",true,"Bd de la justice",0.1);
        Proprietaire prop2 = new Proprietaire("Lakhdar",false,"Bd de la dance",0.2);

        Appartement.setLocataire(loc1);
        Maison.setLocataire(loc2);
        loc1.setOccupe(Appartement);
        loc2.setOccupe(Maison);

        Appartement.setProprietaire(prop1);
        Maison.setProprietaire(prop2);
    
        System.out.println(Appartement.toString());

        System.out.println(Maison.toString());
        // La taxe fonciere de l'appartement dans lequel habite loc1 est de :

        System.out.println(loc1.toString());
        System.out.println(loc2.toString());

        System.out.println(loc1.taxefoncieredubien());

        System.out.println(Appartement.getLocataire());
    }
}
