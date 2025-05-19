package Task10;

/*todo
        CountDownLatch — это счетчик значение которого уменьшается каждый раз, когда
    поток использует счетчик (поток при этом блокируется). Когда значение счетчика
    будет равно нулю, все заблокированные потоки будут одновременно запущены.
    - Для уменьшения числа в счетчике вызывается метод countDown(). После вызова этого метода
    поток продолжает свое выполнение.
    - Метод await() используют для блокировки потока.
 */

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3); // создаём на 3 защёлки
        new Car("Car-1", 3000, latch).start();
        new Car("Car-2", 2000, latch).start();
        new Car("Car-3", 1000, latch).start();
        //Ждём три потока
        latch.await(); //все три защёлки сработали, идём дальше
        System.out.println(Thread.currentThread().getName() + " финишировали все");

    }


}
