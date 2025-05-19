package Task12;

import java.util.concurrent.locks.ReentrantLock;



public class LockThread implements Runnable{
    ReentrantLock locker;
    static Integer resource = 0;

    public LockThread(ReentrantLock locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        locker.lock(); //устанавливаем блокировку

        try {
            for (int i = 0; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), resource);
                resource++;
                Thread.sleep(100);
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        finally {
            locker.unlock(); //снимаем блокировку
        }
    }
}
