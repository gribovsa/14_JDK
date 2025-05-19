package Task10;

import java.util.concurrent.CountDownLatch;

public class Car extends Thread{
    private String name;
    private int delay;
    private CountDownLatch latch; //latch - защёлка

    public Car(String name, int delay, CountDownLatch latch) {
        this.name = name;
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay); //имитация процесса движения
            latch.countDown();   //после взводим защёлку
            System.out.println(Thread.currentThread().getName() + " финишировал");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
