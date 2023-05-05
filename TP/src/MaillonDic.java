public class MaillonDic{
    

    private Object key;
    private Object value;
    private MaillonDic next;
    
    public MaillonDic(Object key, Object value, MaillonDic next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

    // Getters

    public Object getKey(){
        return this.key;
    }

    public Object getValue(){
        return this.value;
    }

    public MaillonDic getNext(){
        return this.next;
    }

    // Setters

    public void setKey(Object key){
        this.key = key;
    }

    public void setValue(Object value){
        this.value = value;
    }

    public void setNext(MaillonDic next){
        this.next = next;
    }
}
