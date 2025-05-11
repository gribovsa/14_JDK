package task1;

import java.util.*;

/**
 *  В рамках выполнения задачи необходимо:
 *  ● Создайте коллекцию мужских и женских имен с помощью интерфейса List.
 *  ● Отсортируйте коллекцию в алфавитном порядке.
 *  ● Отсортируйте коллекцию по количеству букв в слове.
 *  ● Разверните коллекцию.
 */

public class Program {

    public static void sortByAlphabet(List<String>list){
        Collections.sort(list);
        System.out.println(list);
    }

    public static void sortByLength(List<String>list){
        list.sort(Comparator.comparing(String::length));
        System.out.println(list);
    }

    public static void reversList(List<String>list){
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void main(String[] args) {
        List<String>names =  new ArrayList<>(Arrays.asList("Иван", "Сергей","Сергей", "Иван", "Александр","Ирина","Светлана"));
        System.out.println(names);
        sortByAlphabet(names);
        sortByLength(names);
        reversList(names);
    }
}
