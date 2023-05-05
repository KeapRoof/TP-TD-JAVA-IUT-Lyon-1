public class Dictionaire<E extends Comparable<E>,T>{

    private MaillonDic first;

    public Dictionaire(){
        first = null;
    }

    public MaillonDic getFirst(){
        return this.first;
    }

    public MaillonDic search(E key){
        MaillonDic current = first;
        while(current != null){
            if(current.getKey().equals(key)){
                return current;
            }
            current = current.getNext();
        }
        return current;
    }
    
    public void add(E key, T value){
        MaillonDic current = first;
        MaillonDic previous = null;
        if(current == null){
            first = new MaillonDic(key, value, null);
        }
        else{
            while(current != null && (((Comparable<E>) current.getKey()).compareTo(key)) < 0){
                previous = current;
                current = current.getNext();
            }
            MaillonDic newMaillon = new MaillonDic(key, value, current);
            previous.setNext(newMaillon);  
        }
    }

    public Object value(E key){
        MaillonDic current = first;
        while(current != null){
            if(current.getKey().equals(key)){
                return current.getValue();
            }
            current = current.getNext();
        }
        return null;
    }
    
    }