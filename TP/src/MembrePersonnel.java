public class MembrePersonnel extends MembreBibliotheque{
    public MembrePersonnel(String prenom, String nom, int tel, String adresse){
        super(prenom, nom, tel, adresse);
        this.possibiliteEmprunt = 4;
    }
}
