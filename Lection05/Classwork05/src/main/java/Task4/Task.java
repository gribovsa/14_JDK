package Task4;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable {

    private int value;
    private CountDownLatch cdl; //примитив синхронизации

    public Task(int left) {
        this.value = left;
    }

    public int getValue() {
        return value;
    }

    public synchronized void inc(){ //синхронизация ресурса
        //synchronized(Task.class) //тоже самое
        value++;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown(); //происходит уменьшение countDown
    }


}
