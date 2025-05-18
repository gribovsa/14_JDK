package Task0202;

public class MyProgramState {
    private volatile boolean switcher; // volatile доступна и 1 и 2 потоку
    private volatile boolean finish; // volatile доступна и 1 и 2 потоку



    public boolean isSwitcher() {
        return switcher;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public void setSwitcher(boolean switcher) {
        this.switcher = switcher;
    }
}
