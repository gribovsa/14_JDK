package Task1;

/**\
 * Первый метод, создаём класс, и наследуем его от Thread
 * переопределяем метод
 */


public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("1 Hello from: " + Thread.currentThread());
    }
}
