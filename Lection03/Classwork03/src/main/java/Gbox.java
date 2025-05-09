public class Gbox<T> {

    /*Todo
        Параметризированный тип
     */
    private final T a;

    public Gbox(T a) {
        this.a = a;
    }

    public T getA() {
        return a;
    }

    public String showType() {
        return a.getClass().getName();
    }



    public static void main(String[] args) {
        Gbox<String> stringBox = new Gbox<>("Hello!");
        System.out.println(stringBox.getA());
        System.out.println("Type is: " + stringBox.showType() + ", with value: " + stringBox.getA());


        Gbox<Integer> integerGbox = new Gbox<>(20);
        System.out.println(integerGbox.getA());
        System.out.println("Type is: " + integerGbox.showType() + ", with value: " + integerGbox.getA());
    }
}
