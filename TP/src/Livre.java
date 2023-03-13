public class Livre extends DocBibliotheque{
    private int nbPages;
    private int isbn;
    private String Editeur;
    
    public Livre(String codearch, String titre, String auteur, int annee, int status, int nbPages, int isbn, String Editeur){
        super(codearch,titre,auteur,annee,status);
        this.nbPages = nbPages;
        this.isbn = isbn;
        this.Editeur = Editeur;
    }

    public int getNbPages(){
        return this.nbPages;
    }

    public int getIsbn(){
        return this.isbn;
    }

    public String getEditeur(){
        return this.Editeur;
    }

    public String toString(){
        return super.toString() + " " + this.nbPages + " " + this.isbn + " " + this.Editeur;
    }

    
}
