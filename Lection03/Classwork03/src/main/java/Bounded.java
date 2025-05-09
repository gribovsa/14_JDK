import com.sun.source.tree.Scope;

import java.io.Serializable;

public class Bounded<V extends Number> {

    /*todo
        Bounded type parameters
        Bounded type parameters позволяют ограничить типы данных, которые могут быть
        использованы в качестве параметров. Использование bounded type parameters в
        Java является хорошей практикой, которая позволяет более точно определить
        используемые типы данныхиобеспечиваетболеебезопасныйичитаемыйкод.
     */

    private V value;

    public Bounded(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Bounded<Integer> integerBounded = new Bounded<>(1);
        //Bounded<String> stringBounded= new Bounded<>("Строка"); //ругается
        //Bounded<Integer> integerBounded1 = new Bounded<>("Cтрока") //ругается
    }

    //public class Bounded<V extends Number & Serializable & Scope> -
    // можно ограничивать тип (при этом тип наследуя от одного класса и нескольких интерфейсов)
}
