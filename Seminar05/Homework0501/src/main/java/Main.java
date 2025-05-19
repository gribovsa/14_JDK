import java.util.concurrent.Semaphore;

/*todo
        Есть пять философов (потоки), которые могут либо обедать, либо размышлять (ожидание).
    Каждый философ должен пообедать три раза. Каждый прием пищи длиться 500 миллисекунд
    После каждого приема пищи философ должен размышлять.
    Не должно возникнуть общей блокировки.
    Философы не должны есть больше одного раза подряд.
 */

public class Main {

    public static void main(String[] args) {
        int numPhilosophers = 5;
        //Массив философов
        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore table = new Semaphore(numPhilosophers - 1);

        for (int i = 0; i < numPhilosophers; i++) {
            philosophers[i] = new Philosopher(i, table);
            new Thread(philosophers[i]).start();
        }
    }
}
