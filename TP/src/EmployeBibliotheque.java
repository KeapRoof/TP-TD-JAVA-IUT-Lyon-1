public class EmployeBibliotheque extends MembreBibliotheque{

    private int id;

    public EmployeBibliotheque(String prenom, String nom, int tel, String adresse,int id){
        super(prenom, nom, tel, adresse);
        this.id = id;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void docDisponible(DocBibliotheque d) {
        d.getCatalogue().supdoc(d);
        System.out.println("Le document " + d.getTitre() + " a été supprimé du catalogue");
    }
    
}
