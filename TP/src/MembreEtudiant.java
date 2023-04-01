import java.util.Scanner;

public class MembreEtudiant extends MembreBibliotheque{
    private static Scanner sc = new Scanner(System.in);


    public MembreEtudiant(String prenom, String nom, int tel, String adresse){
        super(prenom, nom, tel, adresse);
        this.possibiliteEmprunt = 4;
    }

    
    public void docDisponible(DocBibliotheque d){
        if (d instanceof Livre) {
            System.out.println("Le livre " + d.getTitre() + " est disponible.");
        }
        else if (d instanceof CD) {
            System.out.println("Le CD " + d.getTitre() + " est disponible.");
        }
        else if (d instanceof Livre) {
            System.out.println("Le Livre " + d.getTitre() + " est disponible.");
        }
        System.out.println("Voulez-vous l'emprunter? (O/N)");
        String reponse = sc.nextLine();

        if (reponse.equalsIgnoreCase("O")) {
            if (this.nbdocempruntes < this.possibiliteEmprunt) {
                try{
                d.emprunter(this);
                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                }
                this.nbdocempruntes ++;
                System.out.println("Vous avez emprunté " + this.nbdocempruntes + " document(s).");
            }
            else {
                System.out.println("Vous avez atteint votre limite d'emprunt.");
            }
        }
        else if (reponse.equalsIgnoreCase("N")) {
            System.out.println("Merci et à bientôt.");
        }
        else {
            System.out.println("Veuillez répondre par O ou N.");

    }
    
    }
}
