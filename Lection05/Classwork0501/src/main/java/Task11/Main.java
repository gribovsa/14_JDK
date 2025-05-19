package Task11;

/*todo
        CyclicBarrier работает аналогично CountDownLatch, но есть несколько отличий:
    вместо методов countDown() и await() используется один метод await(), после
    вызова которого поток блокируется (если число не равно нулю);
    класс CyclicBarrier можно использовать повторно. Как только значение
    счетчика становится равным нулю, оно восстанавливается, и объект класса
    можно использовать заново;
    как только значение счетчика стало равным нулю, у вас есть возможность
    выполнить дополнительный метод имплементирующий интерфейс runnable,
    который может быть передан в конструктор CyclicBarrier.
    В качестве примера можно привести приложение для паромной переправы — пока
    паром не будет заполнен машины на 100% он не должен начинать движение.
 */

import Task10.Car;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);



        new Motor("Car-1", 3000, cyclicBarrier).start();
        new Motor("Car-2", 2000, cyclicBarrier).start();
        new Motor("Car-3", 1000, cyclicBarrier).start();

        System.out.println(Thread.currentThread().getName() + " финишировали все");
    }

}
