package task3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * В рамках выполнения задачи необходимо:
 * ● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя
 * значение.
 * ● Найдите человека с самым маленьким номером телефона.
 * ● Найдите номер телефона человека чье имя самое большое в алфавитном порядке.
 */

public class Program {

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("89164447733", "Sergey");
        phoneBook.put("89164447734", "Ivan");
        phoneBook.put("89114447734", "Peter");
        phoneBook.put("89144487734", "Elen");

        System.out.println(findByMinPhoneNumber(phoneBook));
        System.out.println(findByMaxAlphabetName(phoneBook));
    }

    public static String findByMinPhoneNumber(Map<String, String> phoneBook) {
        /*
        Метод collect() принимает в качестве параметра специальный объект — коллектор (collector).
        Этот объект вычитывает все данные из потока, преобразует их к определённой коллекции и возвращает её.
        Collectors.toSet() — один из встроенных методов класса Collectors, который позволяет преобразовать
        элементы потока в тип Set. При использовании этого метода из потока удаляются дублирующиеся элементы.
         */

        //Создадим множество Set и положим туда все телефонные номера в формате Long
        Set<Long> numbers = phoneBook.keySet().stream().map(element -> Long.valueOf(element)).collect(Collectors.toSet());

        //Найдём минимальный номер
        long number = numbers.stream().min(Comparator.naturalOrder()).get();

        //Зная номер - ключ, найдем уже в Map владельца
        String person = phoneBook.get(String.valueOf(number));
        return String.format("Наименьший номер: %s, владелец: %s", number, person);

    }

    public static String findByMaxAlphabetName(Map<String, String> phonebook) {
        //Создадим множество, в котором будем хранить ключ + значение

        Set<Map.Entry<String,String>>elements = phonebook.entrySet();
        Map.Entry<String, String> name = elements.stream().max((entry1,entry2) -> entry1.getValue().compareTo(entry2.getValue())).get();
        //Map.Entry<String, String> name = elements.stream().max(Comparator.comparing(Map.Entry::getValue)).get(); та же запись
        return String.format("Наибольшее имя в алфавитном порядке: %s, номер телефона: %s", name.getValue(), name.getKey());

    }

}




