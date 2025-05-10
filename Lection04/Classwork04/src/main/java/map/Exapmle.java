package map;

import java.util.Map;

/**
 * Интерфейс Map<K,V> представляет отображение (словарь), где каждый элемент
 * представляет пару "ключ-значение". Map гарантирует, что все ключи уникальны.
 * Такие коллекции облегчают поиск элемента V, если нам известен ключ —
 * уникальный идентификатор объекта K.
 */

public class Exapmle {

    public static void main(String[] args) {
        Map<String, Integer> map = Map.of("Hello", 1, "World", 2);

        //fo each
        for (var entry : map.entrySet()) {
            System.out.print(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();

        for (String s : map.keySet()) {
            System.out.print(s + ": " + map.get(s));
        }
        System.out.println();
        //Stream
        map.forEach((k, v) -> System.out.print(k + ": " + v));
    }

}
