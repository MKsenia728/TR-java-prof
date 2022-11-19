package hw221116.bd;

import hw221116.Employee;

import java.util.LinkedList;
import java.util.List;

public class DataBase {
    public List<Employee> ArrayEmployee = new LinkedList<>();

    public void addEmployee(Employee employee) {
        ArrayEmployee.add(employee);
    }

    public void addEmployeeIndex(int index, Employee employee) {
        ArrayEmployee.add(index, employee);
    }

    public void delEmployee(Employee employee) {
        ArrayEmployee.remove(employee);
    }

    public void clearEmployee() {
        ArrayEmployee.clear();
    }

}
