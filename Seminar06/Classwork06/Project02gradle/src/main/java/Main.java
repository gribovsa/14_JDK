
/*todo
        В рамках выполнения задачи необходимо:
    ● Создать свой Java Gradle проект;
    ● Добавить зависимость Guava (популярная библиотека от Google, содержащая набор
    утилитарных механизмов). https://mvnrepository.com/artifact/com.google.guava/guava
    ● Воспользоваться утилитарным классом Lists:
    ○ Развернуть список элементов
    ○ Получить лист Character из строки
    ○ Разделить лист на группы по 2 элемента
    ● Воспользоваться утилитарным классом Sets
    ○ Получить итоговый Set из двух коллекций
    ○ Получить итоговый Set из общих элементов двух коллекций
    ○ Получить итоговый Set из непересекающихся элементов двух коллекций
 */


import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        System.out.println(list);
        System.out.println("Развернули: " + Lists.reverse(list));
        System.out.println("Получили лист из строки: " + Lists.charactersOf("hallo"));
        System.out.println("Разделить лист на группы по 2 элемента: " + Lists.partition(list,2));

        List<Integer> list1 = new ArrayList<>(Arrays.asList(5,6,7,8,9,10));

        System.out.println("Объединение двух коллекций: " + Sets.union(Set.copyOf(list), Set.copyOf(list1)));
        System.out.println("Пересечение двух коллекций: " + Sets.intersection(Set.copyOf(list), Set.copyOf(list1)));
        System.out.println("Непересекающихся элементы двух коллекций: " + Sets.symmetricDifference(Set.copyOf(list),
                Set.copyOf(list1)));
    }
}
