import java.util.ArrayList;

public class ListeMembre {
    ArrayList<MembreBibliotheque> listeMembre;

    public ListeMembre() {
        listeMembre = new ArrayList<MembreBibliotheque>();
    }

    public boolean ajmembre(MembreBibliotheque membre) {
        boolean verite = false;
        if (listeMembre.contains(membre)) {
            verite = false;
        } else {
            listeMembre.add(membre);
            verite = true;
        }
        return verite;
    }

    public MembreBibliotheque accesmembre(int num){
        // Renvoie l'identite du membre si il existe
        for(int i = 0; i < listeMembre.size(); i++){
            if(listeMembre.get(i).getNumeroabonne() == num){
                return listeMembre.get(i);
            }
        }
        return null;
    }

    public void affichecarmem(){
        for(int i = 0; i < listeMembre.size(); i++){
            System.out.println( i +" = "+ listeMembre.get(i).getNom());
        }
    }

    public void affichecarmem(int num){
        for(int i = 0; i < listeMembre.size(); i++){
            if(listeMembre.get(i).getNumeroabonne() == num){
                System.out.println(listeMembre.get(i).getNom());
            }
        }
    }

    public MembreBibliotheque renvoimem(int index){
        if(index <= this.listeMembre.size()-1){
            return this.listeMembre.get(index);
        }
        else{
            return null;
        }
    }
}