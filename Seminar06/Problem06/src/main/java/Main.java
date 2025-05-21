import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*todo
    Всего 10 игр, есть статистика побед и неудач - в коллекции Map
    Ключ - номер игры
    Значение - победа или неудача
    Победа - 1
    Неудача - 0
    Проблема: метод подсчёта побед и неудач считает неверно, почему? Как исправить?
 */



public class Main {
    public static void main(String[] args) {
        System.out.println("Статистика побед и неудач: " + generateMap());
        System.out.println("Победы: " + getNumWins(generateMap()));
        System.out.println("Неудачи: " + getNumDefeats(generateMap()));
        System.out.println("Всего игр 10, суммарное количество побед и неудач не равно 10!");
    }




    /**
     * Метод генерации коллекции побед и неудач
     */
    private static HashMap<Integer, Integer> generateMap(){
        HashMap<Integer, Integer> statisticMap = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            statisticMap.put(i, random.nextInt(2));
        }
        return statisticMap;
    }



    /**
     * Метод подсчёта побед
     */
    private static int getNumWins(HashMap<Integer, Integer> statisticMap) {
        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : statisticMap.entrySet()) {
            if (entry.getValue() == 1) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Метод подсчёта неудач
     */
    private static int getNumDefeats(HashMap<Integer, Integer> statisticMap) {
        int counter = 0;
        for (Map.Entry<Integer, Integer> entry : statisticMap.entrySet()) {
            if (entry.getValue() == 0) {
                counter++;
            }
        }
        return counter;
    }
}
