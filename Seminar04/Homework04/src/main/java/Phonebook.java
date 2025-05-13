package phonebook;

import java.util.ArrayList;

public class Phonebook {

    private Employee employee;
    ArrayList<Employee>arrayListEmployee;

    public Phonebook() {
        arrayListEmployee = new ArrayList<>();
    }



    /**
     * Метод поиска сотрудника по стажу
     */
    public Employee getEmployeeWithExperience(String inExperience) {
        for (Employee emp : arrayListEmployee) {
            if (emp.getExperience().equals(inExperience)){
                System.out.println("Искомый стаж: " + inExperience);
                return emp;
            }
        }
        return null;
    }



    /**
     * Метод, который выводит номер телефона
     * сотрудника по имени
     */

    public String getNumberPhoneWithNamePerson(String inNamePerson){
        for (Employee emp : arrayListEmployee) {
            if(emp.getNamePerson().equals(inNamePerson)){
                System.out.println("Искомое имя: " + inNamePerson);
                return String.format("Получите телефон: %s", emp.getNumberPhone());
            }
        }
        return null;
    }


    /**
     * Метод, который ищет сотрудника по
     * табельному номеру
     */

    public Employee getEmployeeWithNumberPerson(String inNumberPerson){
        for (Employee emp : arrayListEmployee) {
            if(emp.getNumberPerson().equals(inNumberPerson)){
                System.out.println("Искомый табельный номер: " + emp.getNumberPerson());
                return emp;
            }
        }
        return null;
    }


    /**
     * Метод добавления нового сотрудника
     */
    public void setEmployee(Employee employee) {
        arrayListEmployee.add(employee);
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Справочник{" +
                "сотрудники=" + arrayListEmployee +
                '}';
    }
}
