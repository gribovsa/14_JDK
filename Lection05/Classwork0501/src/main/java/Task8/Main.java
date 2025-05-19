package Task8;

/*todo
    Semaphore - примитив синхронизации
    Semaphore один из примитивов синхронизации, позволяющий определить N
    потоков, которым позволено исполнять критическую секцию кода. Когда создается
    Semaphore, в конструктор передается количество разрешенных потоков (пропуск).
    Представьте, что вам нужно реализовать приложение для контроля количества
    свободных мест на парковке - если места на парковке закончились, то остальные
    машины должны ждать пока место не освободится.
    - два метода acquire, release
 */

import java.util.concurrent.Semaphore;

public class Main {

    private static Integer count = Integer.valueOf(0);

    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2);

        new Thread(new CountThread(sem)).start();
        new Thread(new CountThread(sem)).start();
        new Thread(new CountThread(sem)).start();

    }

    static class CountThread implements Runnable {
        Semaphore sem;

        public CountThread(Semaphore sem) {
            this.sem = sem;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " ожидает разрешение");
                sem.acquire(); //метод захвата семафора - и получение разрешения у семафора двигаться вперёд

                for (int i = 0; i < 5; i++) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    Thread.sleep(100);

                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName() + " освобождает разрешение");
            sem.release(); //метод освобождения у семафора
        }
    }
}
