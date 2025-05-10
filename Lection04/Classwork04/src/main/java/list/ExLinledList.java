package list;

import java.util.LinkedList;

/**
 * Обобщенный класс
 *  LinkedList<E> представляет структуру данных в виде связанного списка — т.е.
 *  каждый его элемент хранит ссылку на предыдущий и последующий. Также стоит
 *  отметить, что LinkedList имплементирует интерфейс Deque (описание будет в главе
 *  работы с Queue), а значит его можно использовать как двунаправленную очередь.
 */

public class ExLinledList {

    public static void main(String[] args) {
        //Пустой конструктор
        LinkedList<String> linkedList = new LinkedList<>();

        //Создаёт список, в который добавляет все элементы другой коллекции Collection
        LinkedList<String> linkedListFromCollection = new LinkedList<>(linkedList);
    }
}
