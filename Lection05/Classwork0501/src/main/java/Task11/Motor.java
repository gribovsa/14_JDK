package Task11;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Motor extends Thread {
    private String name;
    private int delay;
    private CyclicBarrier cyclicBarrier;

    public Motor(String name, int delay, CyclicBarrier cyclicBarrier) {
        this.name = name;
        this.delay = delay;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay); //имитация процесса движения
            cyclicBarrier.await();   //блокируем поток и ждём, когда финишируют все, потом идём вперёд
            System.out.println(Thread.currentThread().getName() + " финишировал");
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }

    }
}
