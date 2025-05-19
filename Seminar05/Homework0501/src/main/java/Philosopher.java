import java.util.concurrent.Semaphore;
/**
 * Класс, представляющий философа.
 */
public class Philosopher implements Runnable {
    private int id;
    private Semaphore table;
    private int countEat;


    public Philosopher(int id, Semaphore table) {
        this.id = id;
        this.table = table;
    }

    /**
     * Метод, который философ использует для размышления.
     */
    private void think() {
        System.out.println("Философ " + id + " размышляет");
        try {
            Thread.sleep(500); // Размышляют 500 миллисекунд
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, который философ использует для приема пищи.
     */
    private void eat() {
        countEat++;
        System.out.println("Философ " + id + " ест: " + countEat + " раз");
        try {
            Thread.sleep(500); // имитация процесса обеда
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            think();

            try {
                table.acquire(); // Захват стола (не более чем для четырех философов)
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                table.release(); // Освобождение стола
            }
        }
    }
}

