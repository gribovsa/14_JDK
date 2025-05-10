package task2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Описать собственную коллекцию - список на основе массива.
 * Коллекция должна иметь возможность хранить любые типы данных,
 * иметь методы добавления и удаления элементов
 */

public class Program {
    private Object[] array;
    private int size;

    public Program(int length) {
        this.array = new Object[length];
    }

    public <T> void addElement(T element) {

        array[size++] = element;

        if (size >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

    }

    public <T> void delElement(T element) {
        for (int i = 0; i < size; i++) {    //перебираем массив по заполненным элементам
            if (array[i].equals(element)) { //находим нужный элемент
                for (int j = i; j < size - 1; j++) { //перебираем оставшиеся элементы с последнего заполненного
                    array[j] = array[j + 1]; //сдвигаем каждый оставшийся элемент
                }
            }
        }
    }

    public Object[] getArray() {
        return array;
    }

    public static void main(String[] args) {
        Program program = new Program(10);
        program.addElement("Строка1");
        program.addElement("Строка2");
        program.addElement("Строка3");
        program.addElement("Строка4");
        program.addElement("Строка5");
        program.addElement(1);
        program.addElement(1.0f);
        program.addElement(1.0d);
        program.addElement('a');
        program.addElement('b');
        program.addElement('c');
        program.addElement('d');
        program.addElement('e');
        System.out.println(Arrays.toString(program.getArray()));
        program.delElement('a');
        System.out.println(Arrays.toString(program.getArray()));
    }

}




