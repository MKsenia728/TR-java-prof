package hw221116.service;

import hw221116.Employee;
import hw221116.bd.DataBase;
import hw221116.enums.LeaderPosition;
import hw221116.enums.MiddlePosition;
import hw221116.enums.OrdinaryPosition;
import hw221116.model.LeaderEmployee;
import hw221116.model.MiddleEmployee;
import hw221116.model.OrdinaryEmployee;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Service {

    DataBase dataBase = new DataBase();

    public void createListEmployee() {

        dataBase.addEmployee(new LeaderEmployee(101,"Ivanov", "1970", "2019", 1000, LeaderPosition.SEO));
        dataBase.addEmployee(new LeaderEmployee(102,"Petrov", "1978", "2019", 900, LeaderPosition.PA));
        dataBase.addEmployee(new LeaderEmployee(103,"Sidorov", "1972", "2020", 1000, LeaderPosition.SFO));

        dataBase.addEmployee(new MiddleEmployee(104,"Kuznetcov", "1980", "2015", 600, MiddlePosition.DESIGNER, 4));
        dataBase.addEmployee(new MiddleEmployee(105,"Belov", "1988", "2021", 700, MiddlePosition.MANAGER, 6));
        dataBase.addEmployee(new MiddleEmployee(106,"Pirogov", "1985", "2016", 650, MiddlePosition.ACCOUNTANT, 4));

        dataBase.addEmployee(new OrdinaryEmployee(107,"Vetrov", "1990", "2020", 500, OrdinaryPosition.COURIER));
        dataBase.addEmployee(new OrdinaryEmployee(108,"Pupkin", "1992", "2019", 550, OrdinaryPosition.DRIVER));
        dataBase.addEmployee(new OrdinaryEmployee(109,"Bubkin", "1987", "2021", 500, OrdinaryPosition.GUARD));
    }

    private Employee searchEmployee(int id) {
        int i = 0;
        Employee employee = null;
        while (i < dataBase.ArrayEmployee.size() &&  employee == null) {
            if (dataBase.ArrayEmployee.get(i).getId() == id) employee = dataBase.ArrayEmployee.get(i);
            i++;
        }
        return employee;
    }

    public void changePosition(int id, LeaderPosition newPosition) {
        Employee employee = searchEmployee(id);
        if (employee != null){
            LeaderEmployee employee1;
            int index = dataBase.ArrayEmployee.indexOf(employee);
            if (employee instanceof LeaderEmployee) {
                employee1 = ((LeaderEmployee) employee);
                employee1.setPosition(newPosition);
            } else {
                employee1 = new LeaderEmployee(employee.getId(), employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary(), newPosition);
            }
            dataBase.delEmployee(employee);
            dataBase.addEmployeeIndex(index, employee1);
        } else System.out.println("There is no employee with ID " + id);
    }

    public void changePosition(int id, MiddlePosition newPosition) {
        Employee employee = searchEmployee(id);
        if (employee != null){
            MiddleEmployee employee1;
            int index = dataBase.ArrayEmployee.indexOf(employee);

            if (employee instanceof MiddleEmployee) {
                employee1 = ((MiddleEmployee) employee);
                employee1.setPosition(newPosition);
            } else {
                employee1 = new MiddleEmployee(employee.getId(), employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary(), newPosition, 4);
            }
            dataBase.delEmployee(employee);
            dataBase.addEmployeeIndex(index, employee1);
            System.out.println("Change salary!");
        } else System.out.println("There is no employee with ID " + id);
    }

    public void changePosition(int id, OrdinaryPosition newPosition) {
        Employee employee = searchEmployee(id);
        if (employee != null){
            OrdinaryEmployee employee1;
            int index = dataBase.ArrayEmployee.indexOf(employee);

            if (employee instanceof OrdinaryEmployee) {
                employee1 = ((OrdinaryEmployee) employee);
                employee1.setPosition(newPosition);
            } else {
                employee1 = new OrdinaryEmployee(employee.getId(), employee.getName(), employee.getDateOfBirth(), employee.getDateOfWork(), employee.getSalary(), newPosition);
            }
            dataBase.delEmployee(employee);
            System.out.println(dataBase.ArrayEmployee.size());
            dataBase.addEmployeeIndex(index, employee1);
            System.out.println("Change salary!");
        } else System.out.println("There is no employee with ID " + id);
    }

    public void printListEmployee() {
        for (Employee e:
                dataBase.ArrayEmployee) {
            System.out.println(e);
        }
    }
//    public void printSortEmployee(int field) {
//        List<Employee> printList = null;
//        switch (field) {
////            field name
//            case 1:
//
//            }
//        }
//
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
                System.out.println("ID: " + e.getId() + " name: " + e.getName() + " position: " + ((LeaderEmployee) e).getPosition());
            } else if (e instanceof MiddleEmployee) {
                System.out.println("ID: " + e.getId() + " name: " + e.getName() + " position: " + ((MiddleEmployee) e).getPosition());
            } else System.out.println("ID: " +e.getId() + " name: " + e.getName() + " position: " + ((OrdinaryEmployee) e).getPosition());
        }
    }

    public static void main(String[] args) {
//        Тестирование методов
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);

        service.createListEmployee();

        System.out.println("Make your choose: \n1 - Change employee position\n2 - Print sort list \n3 - Print employees are working by choose year");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
                service.printEmployeeWithPosition();
                System.out.println("Input ID employee (in base 101 - 109) : ");
                int id = scanner.nextInt();
                System.out.println("Choose position 1 - TOP, 2 - Middle, 3 - Ordinary : ");
                int ch = scanner.nextInt();
                scanner.nextLine();
                switch (ch) {
                    case 1 -> {
                        System.out.println("TOP : " + Arrays.toString(LeaderPosition.values()));
                        String position = scanner.nextLine();
                        try {
                            LeaderPosition enumPosition = LeaderPosition.valueOf(position);
                            service.changePosition(id, enumPosition);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Position does not exist");
                        }
                    }
                    case 2 -> {
                        System.out.println(" Middle : " + Arrays.toString(MiddlePosition.values()));
                        String position = scanner.nextLine();
                        try {
                            MiddlePosition enumPosition = MiddlePosition.valueOf(position);
                            service.changePosition(id, enumPosition);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Position does not exist");
                        }
                    }
                    case 3 -> {
                        System.out.println(" Ordinary : " + Arrays.toString(OrdinaryPosition.values()));
                        String position = scanner.nextLine();
                        try {
                            OrdinaryPosition enumPosition = OrdinaryPosition.valueOf(position);
                            service.changePosition(id, enumPosition);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Position does not exist");
                        }
                    }
                    default -> System.out.println("You do not choose position level");
                }

                service.printEmployeeWithPosition();
            }
            case 2 -> System.out.println("Not implemented");
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

