public class Couple<T> {

    private final T a;
    private final T b;

    public Couple(T a, T b) {
        this.a = a;
        this.b = b;
    }


    public int getSum() {
        return Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b));
    }

    public String getConcat() {
        return (String.valueOf(a)) + (String.valueOf(b));
    }
}
