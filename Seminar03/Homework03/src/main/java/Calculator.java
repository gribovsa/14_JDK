public class Calculator {
    private static Number a;
    private static Number b;


    private static <T extends Number> double sum(T a, T b) {
        return a.doubleValue() +  b.doubleValue();

    }

    private static <T extends Number> double subtract(T a, T b) {
        return  a.doubleValue() -  b.doubleValue();
    }

    private static <T extends Number> double multiply(T a, T b) {

        return  a.doubleValue() *  b.doubleValue();

    }

    private static <T extends Number> double divide(T a, T b) {
        if ( b.doubleValue() == 0) {
            throw new ArithmeticException("Аргумент b не должен быть 0");
        }
        return  a.doubleValue() /  b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println(Calculator.sum(3.000001, 3.000001f));
        System.out.println(sum(1,2));
        System.out.println(subtract(10.0000000001, 3.0000000001));
        System.out.println(subtract(10,5.00001f));
        System.out.println(multiply(3.001, 3.001));
        System.out.println(divide(9.999999999999999999, 3));
        System.out.println(divide(9.999999999999999999, 0)); //ошибка
    }
}
