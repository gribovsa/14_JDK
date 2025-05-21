

/*todo
        Домашнее задание
    В качестве задачи предлагаю вам реализовать код для
    демонстрации парадокса Монти Холла (Парадокс Монти Холла
    — Википедия ) и наглядно убедиться в верности парадокса
    (запустить игру в цикле на 1000 и вывести итоговый счет).
    Необходимо:
    ● Создать свой Java Maven или Gradle проект;
    ● Самостоятельно реализовать прикладную задачу;
    ● Сохранить результат в HashMap<шаг теста, результат>
    ● Вывести на экран статистику по победам и поражениям
 */


import java.util.*;

public class Main {


    private static final Random random = new Random();


    public static void main(String[] args) {
        HashMap<Integer,Integer>statistic = getStatistic();
        System.out.println("Статистика игры: " + statistic);
        System.out.println("Количество побед: " + getNumWins(statistic));
        System.out.println("Количество неудач: " + getNumDefeats(statistic));
        System.out.println("Всего провели: " + (getNumWins(statistic) + getNumDefeats(statistic)) + " игр!");
        System.out.println("Парадокс подтверждается, примерно 2/3 побед, 1/3 поражений.");
    }


    /**
     * Метод генерации приза за дверью.
     * Создаю массив из 3 дверей.
     * За одну из 3 дверей рандомно ставлю приз.
     * Приз автомобиль - 1.
     * Овца за дверью - 0.
     */

    private static int[] generate() {
        int[] doors = new int[]{0, 0, 0};

        int index = random.nextInt(3);
        for (int i = 0; i < 3; i++) {
            doors[index] = 1;
        }
        return doors;
    }

    /**
     * Процесс игры
     * Пусть для определённости игрок всегда выбирает 1-ю дверь.
     * Возвращает true - победа.
     * Возвращает false - неудача
     */
    private static int processGame(int[] doors) {

        int index = random.nextInt(2);

        if (doors[0] == 1) {
            //самая оптимистичная победа - автомобиль за 1й дверью
            return doors[0];

            //ведущий сморит что за дверью 2 и 3
        } else if (doors[1] == 1) {
            //если за 2й дверью автомобиль, то ведущий открывает 3ю дверь с овцой
            //теперь у игрока новый выбор 1 и 2 дверь
            int[] select = {doors[0], doors[1]};
            //игрок рандомно выбирает 1 или 2 дверь
            return select[index];

        } else if (doors[2] == 1) {
            //если за 3й дверью автомобиль, то ведущий открывает 2ю дверь с овцой
            //теперь у игрока новый выбор 1 и 3 дверь
            int[] select = {doors[0], doors[2]};
            //игрок рандомно выбирает 1 или 3 дверь
            return select[index];
        }
        return 100;
    }

    /**
     * Метод получения статистики 1000 игр
     */
    private static HashMap<Integer, Integer> getStatistic() {
        HashMap<Integer, Integer> statisticMap = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            statisticMap.put(i, processGame(generate()));
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
