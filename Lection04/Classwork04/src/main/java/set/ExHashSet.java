package set;

import java.util.HashSet;

/**
 * И так представьте, что у вас есть источник данных, и вам нужно получить уникальный список.
 * Воспользуемся интерфейсом Set — который гарантирует уникальность входящих в коллекцию элементов.
 */

public class Example {

    public static void main(String[] args) {
        //Начальная емкость по умолчанию - 16, коэффициент загрузки - 0,75
        HashSet deaultConstructtor = new HashSet<>();

        //Конструктор с заданной начальной емкостью. Коэффициент загрузки - 0,75
        HashSet constructorWithCapacity = new HashSet(32);

        //Конструктор с заданной начальной емкостью. Коэффициент загрузки
        HashSet constructorWithCapacityFactor = new HashSet(32, 0.6f);

        //Конструктор добавляющий элементы из другой коллекции
        HashSet fromCollection = new HashSet(deaultConstructtor);
    }
}

