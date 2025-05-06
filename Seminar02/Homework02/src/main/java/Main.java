public class Main {


    private static Couple couple;

    /*todo
        Реализуйте простой обобщённый класс, такой как пара или кортеж. Затем создайте обобщенный метод,
        который работает с этим классом.
        Например, вы можете создать метод, который принимает пару и возвращает их сумму или конкатенацию.
     */
    public static void main(String[] args) {

        //введите любые два числа int или String в любом порядке
        couple = new Couple<>(1, "1");
        System.out.println("Сумма: " + couple.getSum()); //получим сумму
        System.out.println("Конкатенация: " + couple.getConcat()); //получим конкатенацию
    }
}
