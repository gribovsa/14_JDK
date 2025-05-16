package Task5;

public class TicTak implements Runnable {
    private final String bracket;
    private final Object monitor;

    public TicTak(String bracket) {
        this.bracket = bracket;
        this.monitor = TicTak.class;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                System.out.print(bracket);
                try {
                    Thread.sleep(300);
                    //сделаем так, чтобы потоки чередовались [][][][][][][][][][][][][][][][]
                    monitor.notify(); //инструкция разбудить 2 й поток
                    monitor.wait();   //а сам усни
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
