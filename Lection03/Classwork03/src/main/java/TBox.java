public class TBox<T> {

    /*todo
        Целевой тип выражения– это тип данных, который компилятор Java
        ожидает в зависимости от того, в каком месте находится выражение.
     */

    public static final TBox EMPTY_BOX = new TBox<>();
    private T value;

    public TBox() {

    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

     private static <T> TBox<T> emptyBox(){
        return (TBox<T>) EMPTY_BOX;
    }

    public static void main(String[] args) {

        TBox<String> box = TBox.emptyBox();
    }
}
