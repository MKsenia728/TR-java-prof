package hw221116.service;

import hw221116.Employee;
import hw221116.bd.DataBase;
import hw221116.enums.LeaderPosition;
import hw221116.enums.MiddlePosition;
import hw221116.enums.OrdinaryPosition;
import hw221116.model.LeaderEmployee;
import hw221116.model.MiddleEmployee;
import hw221116.model.OrdinaryEmployee;

import java.util.Scanner;

public class Service {

    DataBase dataBase = new DataBase();

    public void createListEmployee(Employee employee) {
        dataBase.addEmployee(employee);
    }

    public void createListEmployeeSortSalary(Employee employee) {
        dataBase.addSortSalary(employee);
    }

    public void changePosition(Employee employee, LeaderPosition newPosition) {
        LeaderEmployee employee1;
        int index = dataBase.ArrayEmployee.indexOf(employee);
        if (employee instanceof LeaderEmployee) {
            employee1 = ((LeaderEmployee) employee);
            employee1.setPosition(newPosition);
        } else {
            employee1 = new LeaderEmployee(employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary(), newPosition);
        }
        dataBase.delEmployee(employee);
        dataBase.addEmployeeIndex(index, employee1);
        System.out.println("Change salary!");
    }

    public void changePosition(Employee employee, MiddlePosition newPosition) {
        MiddleEmployee employee1;
        int index = dataBase.ArrayEmployee.indexOf(employee);

        if (employee instanceof MiddleEmployee) {
            employee1 = ((MiddleEmployee) employee);
            employee1.setPosition(newPosition);
        } else {
            employee1 = new MiddleEmployee(employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary(), newPosition, 4);
        }
        dataBase.delEmployee(employee);
        dataBase.addEmployeeIndex(index, employee1);
        System.out.println("Change salary!");
    }

    public void changePosition(Employee employee, OrdinaryPosition newPosition) {
        OrdinaryEmployee employee1;
        int index = dataBase.ArrayEmployee.indexOf(employee);

        if (employee instanceof OrdinaryEmployee) {
            employee1 = ((OrdinaryEmployee) employee);
            employee1.setPosition(newPosition);
        } else {
            employee1 = new OrdinaryEmployee(employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary(), newPosition);
        }
        dataBase.delEmployee(employee);
        dataBase.addEmployeeIndex(index, employee1);
        System.out.println("Change salary!");
    }

    public void printEmployeeSortSalary() {

        System.out.println("\nList of Employees sorted by salary: \n");
        for (Employee e :
                dataBase.ArraySalary) {
            System.out.println(e);
        }
    }

    public void printEmployeeWorkFromYear(String year) {
        System.out.println("\n List of Employee are working from " + year + " year: \n");
        for (Employee e :
                dataBase.ArrayEmployee) {
            if (e.getDateOfWork().equals(year)) System.out.println(e);
        }
    }

    public void printEmployeeWithPosition() {
        for (Employee e :
                dataBase.ArrayEmployee) {
            if (e instanceof LeaderEmployee) {
                System.out.println("Name: " + e.getName() + " position: " + ((LeaderEmployee) e).getPosition());
            } else if (e instanceof MiddleEmployee) {
                System.out.println("Name: " + e.getName() + " position: " + ((MiddleEmployee) e).getPosition());
            } else System.out.println("Name: " + e.getName() + " position: " + ((OrdinaryEmployee) e).getPosition());
        }
    }
    
    public static void main(String[] args) {

//        Тестирование методов

        Service service = new Service();

        LeaderEmployee l1 = new LeaderEmployee("Ivanov", "1970", "2019", 1000, LeaderPosition.SEO);
        LeaderEmployee l2 = new LeaderEmployee("Petrov", "1978", "2019", 900, LeaderPosition.PA);
        LeaderEmployee l3 = new LeaderEmployee("Sidorov", "1972", "2020", 1000, LeaderPosition.SFO);
        service.createListEmployee(l1);
        service.createListEmployee(l2);
        service.createListEmployee(l3);

        service.createListEmployeeSortSalary(l1);
        service.createListEmployeeSortSalary(l2);
        service.createListEmployeeSortSalary(l3);

        MiddleEmployee m1 = new MiddleEmployee("Kuznetcov", "1980", "2015", 600, MiddlePosition.DESIGNER, 4);
        MiddleEmployee m2 = new MiddleEmployee("Belov", "1988", "2021", 700, MiddlePosition.MANAGER, 6);
        MiddleEmployee m3 = new MiddleEmployee("Pirogov", "1985", "2016", 650, MiddlePosition.ACCOUNTANT, 4);
        service.createListEmployee(m1);
        service.createListEmployee(m2);
        service.createListEmployee(m3);

        service.createListEmployeeSortSalary(m1);
        service.createListEmployeeSortSalary(m2);
        service.createListEmployeeSortSalary(m3);

        OrdinaryEmployee o1 = new OrdinaryEmployee("Vetrov", "1990", "2020", 500, OrdinaryPosition.COURIER);
        OrdinaryEmployee o2 = new OrdinaryEmployee("Pupkin", "1992", "2019", 550, OrdinaryPosition.DRIVER);
        OrdinaryEmployee o3 = new OrdinaryEmployee("Bubkin", "1987", "2021", 500, OrdinaryPosition.GUARD);
        service.createListEmployee(o1);
        service.createListEmployee(o2);
        service.createListEmployee(o3);

        service.createListEmployeeSortSalary(o1);
        service.createListEmployeeSortSalary(o2);
        service.createListEmployeeSortSalary(o3);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Make your choose: \n1 - Change employee position\n2 - Print list employees sorted by salary\n3 - Print employees are working by choose year");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                service.printEmployeeWithPosition();
                System.out.println("------- Change " + l2.getName() + "-------------------------");
                service.changePosition(l2, OrdinaryPosition.GUARD);
                service.printEmployeeWithPosition();
            }
            case 2 -> service.printEmployeeSortSalary();
            case 3 -> {
                System.out.println("Enter year (BD has 2015,2016,2019,2020,2021): ");
                scanner.nextLine();
                String year = scanner.nextLine();
                service.printEmployeeWorkFromYear(year);
            }
            default -> System.out.println("You do not choose action");
        }
        scanner.close();

    }
}

