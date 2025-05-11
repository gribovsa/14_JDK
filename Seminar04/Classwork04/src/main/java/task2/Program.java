package task2;

import java.util.*;

/**
 *  В рамках выполнения задачи необходимо:
 *  ● Создайте коллекцию мужских и женских имен с помощью интерфейса List -
 *    добавьте повторяющиеся значения.
 *  ● Получите уникальный список Set на основании List.
 *  ● Определите наименьший элемент (алфавитный порядок).
 *  ● Определите наибольший элемент (по количеству букв в слове, но в обратном
 *    порядке).
 *  ● Удалите все элементы содержащие букву ‘A’.
 */

public class Program {

    public static HashSet<String> convertListToSet(List<String>list){
        return new HashSet<>(list);
    }

    public static String firstByAlphabet(List<String>list){
        return list.stream().min(Comparator.naturalOrder()).orElse(null);
    }


    public static List<String> minAndMaxLengthNames(List<String>names){
        //в новый List добавим наибольший и наименьший элемент
        List<String>resultNames = new ArrayList<>();
        resultNames.add(names.stream().min(Comparator.comparing(String::length)).orElse(null));
        resultNames.add(names.stream().max(Comparator.comparing(String::length)).orElse(null));
        return resultNames;
    }

    public static List<String> removeNamesByChar(List<String>names, char symbol){
        names.removeIf(element -> element.toLowerCase().contains((String.valueOf(symbol)).toLowerCase()));
        return names;

    }



    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Иван", "Сергей", "Сергей", "Иван", "Александр", "Ирина", "Светлана", "Константин","Алик"));
        System.out.println("HashSet уникальные имена: " + convertListToSet(names));
        System.out.println("Первый по алфавиту: " + firstByAlphabet(names));
        System.out.println("Наименьшее и наибольшее по длине: " + minAndMaxLengthNames(names));
        System.out.println("Удалили имена с буквой А: " + removeNamesByChar(names, 'А'));
    }
}
