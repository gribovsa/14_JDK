package Task6;

/*todo
    Deadlock
 */

public class Main {

    public static void main(String[] args) {
        ObjectToLock objectToLockOne = new ObjectToLock();
        ObjectToLock objectToLockTwo = new ObjectToLock();
        getThread(objectToLockTwo, objectToLockOne);
        getThread(objectToLockOne, objectToLockTwo);

    }

    private static void getThread(ObjectToLock objectToLockOne, ObjectToLock objectToLockTwo){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                objectToLockTwo.stepOne(objectToLockOne);
            }
        }).start();
    }

    static class ObjectToLock{
        public synchronized void  stepOne(ObjectToLock object){
            System.out.println("stepOne: " + Thread.currentThread().getName());
            object.stepTwo(this);
        }

        public synchronized void stepTwo(ObjectToLock object){
            System.out.println("stepTwo: " + Thread.currentThread().getName());
            object.toString();

        }
    }
}


