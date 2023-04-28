import java.util.*;

class CatalogueBibliotheque{
    private List<DocBibliotheque> catalogue;

    public CatalogueBibliotheque(){
        this.catalogue = new LinkedList<DocBibliotheque>();
    }

    public boolean ajdoc(DocBibliotheque doc){
        boolean verite = false;
        if(this.catalogue.contains(doc) == false && doc != null){
            this.catalogue.add(doc);
            doc.setCatalogue(this);
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
        Iterator<DocBibliotheque> it = this.catalogue.iterator();
        int i = 0;
        if(this.catalogue.isEmpty()){
            System.out.println("Le catalogue est vide");
        }
        while(it.hasNext()){
            DocBibliotheque doc = it.next();
            System.out.println( i +" = "+ doc.getTitre());
            i = i + 1;
        }
    }

    public void affichedocemp(){
        Iterator<DocBibliotheque> it = this.catalogue.iterator();
        while(it.hasNext()){
            DocBibliotheque doc = it.next();
            if(doc.getEmprunteur() != null){
                System.out.println(doc.getTitre());
            }
        }
    }

    public void affichecardoc(DocBibliotheque doc){
        if(this.catalogue.contains(doc)){
            System.out.println(doc.toString());
        }
        else{
            System.out.println("Désoler nous n'avons pas ce document");
        }
    }

    public boolean emprunterdoc(int index,MembreBibliotheque membre) throws ExceptionDoc{
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
            try{
                this.catalogue.get(index).reserver(membre);
            }
            catch (ExceptionReservation e) {
                System.out.println(e.getMessage());
            }
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

    public boolean rendredoc(int index) throws RetourException{
        boolean verite = false;
        if(this.accesBibliotheque(index) != null && this.catalogue.get(index).getEmprunteur() != null){
                this.catalogue.get(index).getEmprunteur().decrementerNbDocEmpruntes();
                this.catalogue.get(index).rendre();
                verite = true;
        }
        return verite;
    }

    public int nbdoc(){
        return this.catalogue.size();
    }

    public int compteLivre(){
        int compteur = 0;
        Iterator<DocBibliotheque> it = this.catalogue.iterator();
        while(it.hasNext()){
            DocBibliotheque doc = it.next();
            if(doc instanceof Livre){
                compteur = compteur + 1;
            }
        }
        return compteur;
    }

    public int compteCD(){
        int compteur = 0;
        for (DocBibliotheque i : this.catalogue){
            if (i instanceof CD) {
                compteur++;
            }
        }
        return compteur;
    }
}
