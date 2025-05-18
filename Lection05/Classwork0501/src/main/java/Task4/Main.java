package Task4;

/*todo
    Пример синхронизации потоков
    проблема консистентности
 */

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Task task = new Task(0);
        //примитив синхронизации, который ждёт на этой строчке, пока не выполнятся метод run в классе Task
        CountDownLatch cdl = new CountDownLatch(3);
        task.setCdl(cdl); //передаём его в класс task
        //создаём три потока
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
        cdl.await(); //в этой строчке программа ждёт, пока все 3 потока не финишируют

        System.out.println(task.getValue());

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + "ms.");






    }
}

