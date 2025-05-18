package Task1;
/*todo
    Создать поток можно 2 способами
    1. создав класс наследник от родителя Thread, переопределив метод run
    2. имплементировав метод run от интерфейса Runnable
 */

public class Main {

    public static void main(String[] args)throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        //1 способ
        for (int i = 0; i < 3; i++) {
            MyThread thread  = new MyThread(); //start - запуск
            thread.start();
            thread.join(); //устанавливает очерёдность потоков (пока поток не завершится следующий не создам)
        }

        //2 способ
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new MyRunnable()); //start - запуск
            thread.start();
            thread.join();
        }

        //2 способ через лямбду
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                System.out.println("3 Hello from: " + Thread.currentThread());
            }).start();
        }
    }
}
