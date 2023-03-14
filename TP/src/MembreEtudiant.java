public class MembreEtudiant extends MembreBibliotheque{
    public MembreEtudiant(String prenom, String nom, int tel, String adresse){
        super(prenom, nom, tel, adresse);
        this.possibiliteEmprunt = 4;
    }
}
