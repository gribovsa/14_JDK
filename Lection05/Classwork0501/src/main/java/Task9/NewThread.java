package Task9;

import java.util.concurrent.Exchanger;

public class NewThread implements Runnable{
    Exchanger<String>exchanger;
    String message;
    String name;

    public NewThread(Exchanger<String> exchanger, String message, String name) {
        this.exchanger = exchanger;
        this.message = message;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            message = exchanger.exchange(message);
            System.out.println(name + " получил: " + message);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
