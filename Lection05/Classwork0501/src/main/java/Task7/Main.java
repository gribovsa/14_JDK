package Task7;
/*todo
    ThreadLocal - локальные переменные потоков
 */

public class Main {
    private static Integer counter =0 ;
    public static void main(String[] args) {
        new Thread(new ThreadTask()).start();
        new Thread(new ThreadTask()).start();
    }

    public static class ThreadTask implements Runnable {
        ThreadLocal<Integer> threadCounter = new ThreadLocal<>();
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                counter++;
                if (threadCounter.get()!=null){
                    threadCounter.set(threadCounter.get() + 1);
                }else {
                    threadCounter.set(0);
                }
            }
            System.out.println("Counter: " + counter);
            System.out.println("threadLocalCounter: " + threadCounter.get());

        }
    }
}
