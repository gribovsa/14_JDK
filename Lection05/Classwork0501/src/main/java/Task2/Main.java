package Task2;

/*todo
    Пример запуска и синхронизации двух параллельных потоков
 */

public class Main {
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTak("["));
        Thread tak = new Thread(new TicTak("]"));
        // tic.setDaemon(true); //делаем потоки сервисными, при завершении программы завершается процесс
        // tak.setDaemon(true);
        tic.start();
        tak.start();
    }
}
