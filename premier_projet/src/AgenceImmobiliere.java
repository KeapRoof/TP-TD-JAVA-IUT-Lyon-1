class AgenceImmobiliere{
    private int nb_biens;
    private BienImmobilier[] tab;
    private static final int MAX = 10;

    public AgenceImmobiliere(){
        this.nb_biens = 0;
        //Atribut tableau de BienImmobilier de taille 10 vide
        this.tab = new BienImmobilier[MAX];
    }

    private int longueur(){
        int i = this.tab.length;
        return i;
    }

    public boolean ajouterBien(BienImmobilier lebien){
        boolean verite = false;
        int i = 0;
        boolean doublon = false;
        while(i<MAX && verite == false && doublon == false){    
            if(tab[i] == null){
                tab[i] = lebien;
                verite = true;
                this.nb_biens++;
                System.out.println("Bien ajouté");
            }
            else if(tab[i] == lebien){
                System.out.println("Ce bien est déjà dans l'agence");
                doublon = true;
            }
            else{
                i++;
            }
        }
        return verite;
    }
    
    public void afficherbiens(){
        int i = 0;
        while(i<nb_biens){
            if(tab[i] != null){
                System.out.println("--------------------");
                System.out.println(tab[i].toString());
                System.out.println("--------------------");
            }
            i++;
        }
    }
    

    // renvoie le nombre de biens de l'agence
    public int getNb_biens(){
        return this.nb_biens;
    }


    // renvoie l'index du bien dont la référence est passée en paramètre sinon -1

    public int rechercheref(int ref){
        int index = -1;
        int i = 0;
        while(i<nb_biens){
            if(tab[i] != null){            
                if(tab[i].getRef() == ref){
                    index = i;
                }
            }   
            i++;
        }
        return index;
    }

    public int supprimerbien(int Refbien){
            int verite = -1;
            int indexsup = rechercheref(Refbien);
            int size = this.longueur();
            if(indexsup != -1){
                verite = indexsup;
                tab[indexsup] = null;
                while(indexsup < size-1){
                    tab[indexsup] = tab[indexsup+1];
                    indexsup++;
                }
                tab[size-1] = null;
            }
            return verite;
    }

}