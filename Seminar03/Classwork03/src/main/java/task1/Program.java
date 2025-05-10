package task1;

import java.awt.*;
import java.io.DataInput;
import java.io.InputStream;

/**
 * Создать обобщённый класс с тремя параметрами (T, V, K).
 * Класс содержит три переменные типа (T, V, K),
 * конструктор, принимающий на вход параметры типа (T, V, K),
 * методы возвращающие значения трёх переменных
 *
 * Создать метод, вызывающий на консоль имена классов для трёх переменных класса.
 * Наложить ограничения на параметры типа:
 * T должен реализовать интерфейс Comparable,
 * V должен реализовать интерфейс DataInput и расширить класс InputStream,
 * К должен расширить класс Number.
 */

public class Program<T extends Comparable<T>, V extends InputStream & DataInput, K extends Number> {
    private T a;
    private V b;
    private K c;

    public Program(T a, V b, K c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public T getA() {
        return a;
    }

    public V getB() {
        return b;
    }

    public K getC() {
        return c;
    }

    public void showClass (){
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());

    }

}
