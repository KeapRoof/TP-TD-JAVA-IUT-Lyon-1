public class TestBibliotheque {
    public static void main(String[] args){
        DocBibliotheque doc1 = new DocBibliotheque("004 178 K20PM", "Introduction a Java", "J.Leblanc", 2015, 0);
        DocBibliotheque doc2 = new DocBibliotheque("9674987T248O", "Structure de données", "M.Machin", 2022, 0);
        // TP2
        MembreBibliotheque membre1 = new MembreBibliotheque("Haithem", "Hadj Azzem", 0606060606,   "1 rue de la paix");
        MembreBibliotheque membre2 = new MembreBibliotheque("Mohamed", "Belkhatir", 0707070707,   "2 rue de la paix");
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
    }
}