public class MembrePersonnel extends MembreBibliotheque{
    public MembrePersonnel(String prenom, String nom, int tel, String adresse){
        super(prenom, nom, tel, adresse);
        this.possibiliteEmprunt = 8;
    }

    public void docDisponible(DocBibliotheque d){
        if(d.getReserveur() == this){
            d.setReserveur(null);
            d.setEmprunteur(this);
            this.nbdocempruntes ++;
        }
    }
}
