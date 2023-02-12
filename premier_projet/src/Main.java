public class Main {
    public static void main(String[] args) {
    // Creation d'instances
    BienImmobilier Appartement = new BienImmobilier("Appartement", 50, true, true, 1000, 0.1,null,null);
    BienImmobilier Maison = new BienImmobilier("Maison", 100, true, true, 2000, 0.2,null,null);
    // Affichage des attributs
    System.out.println("Bienvenue dans le programme de gestion des biens immobiliers");
    System.out.println("Affichage des attributs");
    System.out.println("La reference de l'appartement est : " + Appartement.getRef());
    System.out.println("La reference de l'appartement est : " + Maison.getRef());
    System.out.println(Appartement.getTaxefonciere());
    System.out.println(Maison.getTaxefonciere());
    // Modification des attributs
    System.out.println("Modification des attributs");
    Appartement.setRef(3);
    Maison.setRef(4);
    System.out.println("La reference de l'appartement est : " + Appartement.getRef());
    System.out.println("La reference de l'appartement est : " + Maison.getRef());
    System.out.println(Appartement.toString());
    int value;
    value = Appartement.compareTaxeFonc(Appartement.getTaxefonciere(), Maison.getTaxefonciere());
    if(value == 1){
        System.out.println("La taxe fonciere de l'appartement est superieure a celle de la maison");
    }
    else if(value == -1){
        System.out.println("La taxe fonciere de l'appartement est inferieure a celle de la maison");
    }
    else{
        System.out.println("La taxe fonciere de l'appartement est egale a celle de la maison");
    }
}
}
