package Task0202;

import Task0101.MyThread;

public class MyThread1 extends Thread{
    private MyProgramState state;

    public MyThread1(MyProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        while (!state.isFinish()){
            //поменяли флаг
            state.setSwitcher(!state.isSwitcher());
            System.out.println(Thread.currentThread().getName() + " в состоянии: " + getState()); //вывести текущее состояние потока
            if(!state.isSwitcher()){
                System.out.println("пауза");
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
