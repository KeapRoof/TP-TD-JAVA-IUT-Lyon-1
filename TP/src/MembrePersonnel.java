public class MembrePersonnel extends MembreBibliotheque{
    public MembrePersonnel(String prenom, String nom, int tel, String adresse){
        super(prenom, nom, tel, adresse);
        this.possibiliteEmprunt = 8;
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
    }
}
