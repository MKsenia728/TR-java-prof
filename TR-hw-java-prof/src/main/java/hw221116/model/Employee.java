package hw221116.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
//@AllArgsConstructor
@ToString

public class Employee implements Comparable<Employee>{

    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate startOfWork;
    private int salary;

    public Employee(int id, String name, LocalDate dateOfBirth, LocalDate startOfWork) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.startOfWork = startOfWork;
    }

    public double TakeInsureSum() {
        return salary * 0.1;
    }

    @Override
    public int compareTo(Employee emp) {
        int res = this.name.compareTo(emp.name);
        if (res == 0) {
            res = (this.id - emp.id);
        }
        return res;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
