package list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Сам ArrayList на самом деле является обычным массивом, обернутым в интерфейс
 *  List. Когда мы добавляем в коллекцию новый элемент, а размер массива не
 *  позволяет нам этого сделать происходит следующее:
 *  Создается новый массив размер которого больше текущего в1.5раза
 *  Элементы старого массива копируются в новый с сохранением позиции
 *  добавляется новый элемент к массиву в конец.
 */

public class ExArrayList {
    public static void main(String[] args) {

        Collection<Integer> collection = List.of(1, 2, 3, 4, 5);

        ArrayList<Integer> list = new ArrayList<>(collection);
        list.get(1);
        list.set(0, 100);
        list.contains(1);
    }
}
