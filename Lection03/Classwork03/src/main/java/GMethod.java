public class GMethod<T> {

    private T a;
    private T t;

    public GMethod(T a) {
        this.a = a;

    }

    public T getA() {
        return a;
    }


    public void setA(T a) {
        this.a = a;
    }


    /*todo
        Обобщённые методы
     */
    private <T> void setIfNull(GMethod<T> box, T t) {
        if (box.getA() == null) {
            box.setA(t);
        }
    }

    public static void main(String[] args) {
        GMethod<Integer> gMethod = new GMethod<>(null);
        gMethod.setIfNull(gMethod, 1);
        System.out.println("Результат обобщённого метода: " + gMethod.getA());


        GMethod<Integer> gMethod0 = new GMethod<>(13);
        gMethod0.setIfNull(gMethod0, 2);
        System.out.println("Результат обобщённого метода: " + gMethod0.getA());
    }
}
