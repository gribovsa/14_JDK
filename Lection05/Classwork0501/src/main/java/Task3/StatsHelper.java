package Task3;

/*todo
    Параллельный ввод и вывод в консоль
 */

import java.util.Scanner;

public class StatsHelper {

    private static int cnt = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread readThread = new Thread(()->{
            Scanner in = new Scanner(System.in);
            while (in.hasNextLine()){
                String line = in.nextLine();
                cnt++;
            }
        });
        readThread.setDaemon(true);
        readThread.start();



        while (true){
            System.out.println(cnt + " messages inputted by user");
            Thread.sleep(2000);
        }

    }
}
