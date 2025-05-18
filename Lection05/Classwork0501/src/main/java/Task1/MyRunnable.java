package Task1;

/**
 * Второй метод, создаём класс и в нем  реализуем метод от
 * интерфейса Runnable
 */

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("2 Hello from: " + Thread.currentThread());

    }
}
