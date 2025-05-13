package phonebook;

/*todo
    Задание 1. Создать справочник сотрудников
     Необходимо:
     ● Создать класс справочник сотрудников, который
    содержит внутри коллекцию сотрудников - каждый
    сотрудник должен иметь следующие атрибуты:
     ○ Табельный номер
     ○ Номер телефона
     ○ Имя
     ○ Стаж
     ● Добавить метод, который ищет сотрудника по стажу
    (может быть список)
     ● Добавить метод, который выводит номер телефона
    сотрудника по имени (может быть список)
     ● Добавить метод, который ищет сотрудника по
    табельному номеру
     ● Добавить метод добавление нового сотрудника в
    справочник
 */

public class Main {


    public static void main(String[] args) {
        Employee employee1 = new Employee("101", "89164747966", "Sergey", "20");
        Employee employee2 = new Employee("102", "89157779966", "Alexey", "5");
        Employee employee3 = new Employee("103", "89031119478", "Dmitriy", "10");
        Employee employee4 = new Employee("104", "89851333289", "Irina", "2");

        Phonebook phonebook = new Phonebook();



        //вызываю метод добавления нового сотрудника
        phonebook.setEmployee(employee1);
        phonebook.setEmployee(employee2);
        phonebook.setEmployee(employee3);
        phonebook.setEmployee(employee4);

        //проверим, что книга заполнена
        System.out.println(phonebook);

        //вызываю метод поиска сотрудника по стажу
        System.out.println(phonebook.getEmployeeWithExperience("20"));

        //вызываю метод поиска номера телефона по имени
        System.out.println(phonebook.getNumberPhoneWithNamePerson("Sergey"));

        //вызываю метод, который ищет сотрудника по табельному номеру
        System.out.println(phonebook.getEmployeeWithNumberPerson("102"));
    }





}
