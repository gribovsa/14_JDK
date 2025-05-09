package fruit;


import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> { //все классы имплементирующие интерфейс являются его наследниками
    private final List<T> container;

    //конструктор
    public Box() {
        container = new ArrayList<>();
    }

    //возвратить фрукт по индексу
    public T get(int index) {
        return container.get(index);
    }

    //добавить фрукт
    public void add(T fruit){
        container.add(fruit);
    }

    //взвесить всю коробку
    public float getWeightBox(){
        return container.get(0).getWeight()*container.size(); //берем вес фрукта через интерфейс и умножаем на кол-во
    }

    //сравнить текущую с другой коробкой неизвестно чего <?>
    public boolean compare(Box<?>with){
        return getWeightBox() == with.getWeightBox();
    }



    public void print() {
        System.out.println(getWeightBox());
    }

    //пересыпать коробку в другую
    //ограничение по снизу родителю, те пересыпать можем только в род объект - коробку фруктов
    //в коробку яблок коробку груш пересыпать нельзя
    public void transferTo(Box<? super T> destination){
        destination.container.addAll(container);
        this.container.clear();
    }

    @Override
    public String toString() {
        return  container.toString();
    }
}
