import java.util.ArrayList;

class CatalogueBibliotheque{
    private ArrayList<DocBibliotheque> catalogue;

    public CatalogueBibliotheque(){
        this.catalogue = new ArrayList<DocBibliotheque>();
    }

    public boolean ajdoc(DocBibliotheque doc){
        boolean verite = false;
        if(this.catalogue.contains(doc) == false && doc != null){
            this.catalogue.add(doc);
            verite = true;
        }
        return verite;
    }

    public boolean supdoc(DocBibliotheque doc){
        boolean verite = false;
        if(this.catalogue.contains(doc)){
            this.catalogue.remove(doc);
            verite = true;
        }
        return verite;
    }

    public DocBibliotheque accesBibliotheque(int index){
        DocBibliotheque val = null;
        if(index >= 0 && index < this.catalogue.size()){
            val = this.catalogue.get(index);
        }
        return val;
    }

    public void affichedoc(){
        for(int i = 0; i < this.catalogue.size(); i++){
            System.out.println( i +". "+ this.catalogue.get(i).getTitre());
        }
        if(this.catalogue.size() < 1){
            System.out.println("Il n'y a rien dans le catalogue");
        }
    }

    public void affichedocemp(){
        int i = 0;
        while(accesBibliotheque(i) != null)
            if(this.catalogue.get(i).getEmprunteur() != null){
                System.out.println(this.catalogue.get(i).getTitre());
            }
            i = i + 1;
    }

    public void affichecardoc(DocBibliotheque doc){
        if(this.catalogue.contains(doc)){
            System.out.println(doc.toString());
        }
        else{
            System.out.println("Désoler nous n'avons pas ce document");
        }
    }

    public boolean emprunterdoc(int index,MembreBibliotheque membre){
        boolean verite = false;
        if(this.accesBibliotheque(index) != null && membre.peutEmprunter()){
            this.catalogue.get(index).emprunter(membre);
            membre.incrementerNbDocEmpruntes();
            verite = true;
        }
        return verite;
    }

    public boolean reservedoc(int index,MembreBibliotheque membre){
        boolean verite = false;
        if(this.accesBibliotheque(index) != null){
            this.catalogue.get(index).reserver(membre);
        }
        return verite;
    }

    public boolean annulresa(int index,MembreBibliotheque membre){
        boolean verite = false;
        if(this.accesBibliotheque(index) != null){
            this.catalogue.get(index).annulerReservation(membre);
            verite = true;
        }
        return verite;
    }

    public boolean rendredoc(int index){
        boolean verite = false;
        if(this.accesBibliotheque(index) != null){
            this.catalogue.get(index).getEmprunteur().decrementerNbDocEmpruntes();
            this.catalogue.get(index).rendre();
            verite = true;
        }
        return verite;
    }

    public int nbdoc(){
        return this.catalogue.size();
    }
}
