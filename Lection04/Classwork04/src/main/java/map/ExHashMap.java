package map;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * И так, HashMap — структура из пар «ключ-значение» — или динамический массив
 * ключей. Каждый элемент массива — это bucket (корзина), в каждом из которых
 * хранится связанные списки со значением Map.Entry (если корзина пустая то
 * связанный список будет состоять из одного элемента, а ссылаться этот элемент
 * будет на null). Количество корзин может меняться со временем (по умолчанию их 16
 * и каждыйразихколичествоувеличиваетсявдвараза).
 */


public class ExHashMap {

    private ArrayList<LinkedList<Integer>> map;

    private int capacity;

    public ExHashMap() {
        capacity = 100;
        map = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            map.add(new LinkedList<>());
        }
    }

    public void pet(Integer key, Integer value) {
        int code = key.hashCode() % capacity;
        LinkedList<Integer> list = map.get(code);
        if (!list.contains(value)) {
            list.add(value);
        }
    }

}
