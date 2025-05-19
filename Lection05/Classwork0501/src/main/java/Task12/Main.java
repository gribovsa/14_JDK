package Task12;

/*todo
        Сегодня мы рассмотрим одну из реализаций интерфейса Lock — ReentrantLock. Он
    позволяет одному и тому же потоку вызывать метод lock, даже если он его вызывал
    ранее, без освобождения блокировки.
 */

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock locker = new ReentrantLock(); //создаём lock
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LockThread(locker));
            thread.start(); //запускаем 5 потоков
            thread.join();  //основной поток ждёт завершения, прежде чем перейти к следующему, при этом запускаем потоки поочерёдно
        }
    }
}
