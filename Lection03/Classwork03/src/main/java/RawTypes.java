public class RawTypes <T> {
    /*Todo
        Сырые типы
        Сырой тип– это имя обобщённого класса или интерфейса без аргументов типа, то
        есть это, фактически, написание идентификатора и вызов конструктора
        обобщённого класса как обычного, без треугольных скобок.
     */

    private T a;

    public RawTypes(T a) {
        this.a = a;
    }

    public static void main(String[] args) {

        // видим много предупреждений среды разработки

        RawTypes rawTypes = new RawTypes(1);
        RawTypes<Integer> intBox = rawTypes;

        RawTypes<Integer> intBox0 = new RawTypes<>(1);
        RawTypes box0 = intBox0;

    }
}
