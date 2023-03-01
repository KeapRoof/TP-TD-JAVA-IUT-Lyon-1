import java.util.ArrayList;

class CatalogueBibliotheque{
    private ArrayList<DocBibliotheque> catalogue;

    public CatalogueBibliotheque(){
        this.catalogue = new ArrayList<DocBibliotheque>();
    }

    public boolean ajdoc(DocBibliotheque doc){
        boolean verite = false;
        if(this.catalogue.contains(doc)){
            verite = false;
        }
        else{
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
        else{
            verite = false;
        }
        return verite;
    }

    public DocBibliotheque accesBibliotheque(int index){
        if(index < this.catalogue.size()-1){
            return this.catalogue.get(index);
        }
        else{
            return null;
        }
    }

    public void affichedoc(){
        for(int i = 0; i < this.catalogue.size(); i++){
            System.out.println(this.catalogue.get(i).getTitre());
        }
        if(this.catalogue.size() < 1){
            System.out.println("Il n'y a rien dans le catalogue");
        }
    }

    public void affichedocemp(){
        for(int i = 0; i < this.catalogue.size(); i++){
            if(this.catalogue.get(i).getEmprunteur() != null){
                System.out.println(this.catalogue.get(i).getTitre());
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

    public boolean emprunterdoc(int index,MembreBibliotheque membre){
        boolean verite = false;
        if(index < this.catalogue.size()-1){
            if(this.catalogue.get(index).getEmprunteur() == null){
                this.catalogue.get(index).setEmprunteur(membre);
                verite = true;
            }
            else{
                verite = false;
            }
        }
        else{
            verite = false;
        }
        return verite;
    }

    public boolean reservedoc(int index,MembreBibliotheque membre){
        boolean verite = false;
        if(index < this.catalogue.size()-1){
            if(this.catalogue.get(index).getReserveur() == null){
                this.catalogue.get(index).setReserveur(membre);
                verite = true;
            }
            else{
                verite = false;
            }
        }
        else{
            verite = false;
        }
        return verite;
    }

    public boolean annulresa(int index,MembreBibliotheque membre){
        boolean verite = false;
        if(index < this.catalogue.size()-1){
            if(this.catalogue.get(index).getReserveur() == membre){
                this.catalogue.get(index).setReserveur(null);
                verite = true;
            }
            else{
                verite = false;
            }
        }
        else{
            verite = false;
        }
        return verite;
    }
}
