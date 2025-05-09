public class KVBox <K,V>{
    private K key;
    private V value;

    public KVBox(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void showType(){
        System.out.printf("Type of key is: %s, key = %s, " + "Type of value is: %s, key = %s\n",
                key.getClass().getName(), getKey(),
                value.getClass().getName(), getValue());
    }

    public static void main(String[] args) {
        KVBox <Integer, String> kvBox = new KVBox<>(1, "World");
        KVBox <Float, Character> newkvBox = new KVBox<>(1.1f, 'w');
        kvBox.showType();
        newkvBox.showType();
    }
}
