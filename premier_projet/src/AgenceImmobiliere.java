class AgenceImmobiliere{
    public static int nb_biens;
    BienImmobilier[] tab = new BienImmobilier[10];

    public boolean ajouterBien(BienImmobilier lebien){
        boolean verite = false;
        int i = 0;
        while(i<10){
            if(tab[i] == null){
                tab[i] = lebien;
                verite = true;
            }
            else{
                i++;
            }
        }
        return verite;
    }

    public void afficherbien(){
        int i = 0;
        while(i<10){
            System.out.println(tab[i]);
            i++;
        }
    }

    public int rechercheref(int ref){
        int index = -1;
        int i = 0;
        while(i<10){
            if(tab[i].getRef() == ref){
                index = i;
            }
            i++;
        }
        return index;
    }

    public int supprimerbien(int Refbien){
            int verite = -1;
            int indexsup = rechercheref(Refbien);
            if(indexsup != -1){
                verite = indexsup;
                tab[indexsup] = null;
                while(indexsup < 10){
                    tab[indexsup] = tab[indexsup+1];
                }
            }
            return verite;
    }
}