package phonebook;
/*todo
    сотрудник должен иметь следующие атрибуты:
         ○ Табельный номер
         ○ Номер телефона
         ○ Имя
         ○ Стаж
 */

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private String numberPerson;
    private String numberPhone;
    private String namePerson;
    private String experience;

    public Employee(String numberPerson, String numberPhone, String namePerson, String experience) {
        this.numberPerson = numberPerson;
        this.numberPhone = numberPhone;
        this.namePerson = namePerson;
        this.experience = experience;
        ArrayList<String> employeeInfoList = new ArrayList<>();
        employeeInfoList.add(namePerson);
        employeeInfoList.add(numberPhone);
        employeeInfoList.add(namePerson);
        employeeInfoList.add(experience);
    }

    public String getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(String numberPerson) {
        this.numberPerson = numberPerson;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "ID='" + numberPerson + '\'' +
                ", телефон='" + numberPhone + '\'' +
                ", имя='" + namePerson + '\'' +
                ", стаж='" + experience + '\'' +
                '}';
    }
}
