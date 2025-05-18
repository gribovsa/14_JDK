package Task0101;

public class MyThread extends Thread {
    private Friend friend1;
    private Friend friend2;

    public MyThread(Friend friend1, Friend friend2) {
        this.friend1 = friend1;
        this.friend2 = friend2;
    }

    @Override
    public void run() {
        friend1.bow(friend2);
    }
}
