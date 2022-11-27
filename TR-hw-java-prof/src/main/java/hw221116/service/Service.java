package hw221116.service;

import hw221116.comparators.DateStartWorkComparator;
import hw221116.comparators.PositionNameComparator;
import hw221116.comparators.SalaryNameComparator;
import hw221116.model.Employee;
import hw221116.bd.DataBase;
import hw221116.enums.LeaderPosition;
import hw221116.enums.MiddlePosition;
import hw221116.enums.OrdinaryPosition;
import hw221116.model.LeaderEmployee;
import hw221116.model.MiddleEmployee;
import hw221116.model.OrdinaryEmployee;
import hw221116.staffing.LeaderStaffing;
import hw221116.staffing.MiddleStaffing;
import hw221116.staffing.OrdinaryStaffing;

import java.time.LocalDate;
import java.util.*;

public class Service {

    static DataBase dataBase = new DataBase();

    public void createListEmployee() {

        dataBase.addEmployee(new LeaderEmployee(101, "Ivanov", LocalDate.of(1969,12,12), LocalDate.of(2010,3,1), LeaderPosition.SEO));
        dataBase.addEmployee(new LeaderEmployee(102, "Petrov", LocalDate.of(1975,5,2), LocalDate.of(2010,6,1), LeaderPosition.PA));
        dataBase.addEmployee(new LeaderEmployee(103, "Sidorov", LocalDate.of(1979,5,25), LocalDate.of(2012, 10,12), LeaderPosition.SFO));

        dataBase.addEmployee(new MiddleEmployee(104, "Kuznetcov", LocalDate.of(1980,8,23), LocalDate.of(2017,6,21), MiddlePosition.DESIGNER));
        dataBase.addEmployee(new MiddleEmployee(105, "Belov", LocalDate.of(1985,5,2), LocalDate.of(2020,12,4), MiddlePosition.MANAGER));
        dataBase.addEmployee(new MiddleEmployee(106, "Pirogov", LocalDate.of(1988,5,23), LocalDate.of(2019,9,12), MiddlePosition.ACCOUNTANT));
        dataBase.addEmployee(new MiddleEmployee(110, "Ivanov", LocalDate.of(1984,5,19), LocalDate.of(2014,7,11), MiddlePosition.MANAGER));

        dataBase.addEmployee(new OrdinaryEmployee(107, "Vetrov", LocalDate.of(1995,9,3), LocalDate.of(2018,3,20), OrdinaryPosition.COURIER));
        dataBase.addEmployee(new OrdinaryEmployee(108, "Pupkin", LocalDate.of(1990,7,23), LocalDate.of(2015,4,1), OrdinaryPosition.DRIVER));
        dataBase.addEmployee(new OrdinaryEmployee(109, "Bubkin", LocalDate.of(1970,10,1), LocalDate.of(2017,8,12), OrdinaryPosition.GUARD));
    }
//   MANAGER, ACCOUNTANT, DESIGNER
    public void createListStaffing() {
        dataBase.addStaffing(new LeaderStaffing(5000, LeaderPosition.SEO));
        dataBase.addStaffing(new LeaderStaffing(4000, LeaderPosition.SFO));
        dataBase.addStaffing(new LeaderStaffing(4000, LeaderPosition.VP));
        dataBase.addStaffing(new LeaderStaffing(3800, LeaderPosition.QS_MANAGER));
        dataBase.addStaffing(new LeaderStaffing(3900, LeaderPosition.PR));
        dataBase.addStaffing(new LeaderStaffing(3600, LeaderPosition.HR));
        dataBase.addStaffing(new LeaderStaffing(3500, LeaderPosition.PA));
        dataBase.addStaffing(new LeaderStaffing(3500, LeaderPosition.CAO));

        dataBase.addStaffing(new MiddleStaffing(2800, MiddlePosition.ACCOUNTANT));
        dataBase.addStaffing(new MiddleStaffing(3000, MiddlePosition.MANAGER));
        dataBase.addStaffing(new MiddleStaffing(2600, MiddlePosition.DESIGNER));

        dataBase.addStaffing(new OrdinaryStaffing(900, OrdinaryPosition.GUARD));
        dataBase.addStaffing(new OrdinaryStaffing(1500, OrdinaryPosition.DRIVER));
        dataBase.addStaffing(new OrdinaryStaffing(700, OrdinaryPosition.COURIER));
        dataBase.addStaffing(new OrdinaryStaffing(1100, OrdinaryPosition.LOADER));
    }

    private Employee searchEmployee(int id, List<Employee> employeeList) {
        int i = 0;
        Employee employee = null;
        while (i < employeeList.size() && employee == null) {
            if (employeeList.get(i).getId() == id) employee = employeeList.get(i);
            i++;
        }
        return employee;
    }

    public void changePosition(int id, LeaderPosition newPosition, List<Employee> employeeList) {
        Employee employee = searchEmployee(id, employeeList);
        if (employee != null) {
            LeaderEmployee employee1;
            int index = employeeList.indexOf(employee);
            if (employee instanceof LeaderEmployee) {
                employee1 = ((LeaderEmployee) employee);
                employee1.setPosition(newPosition);
            } else {
                employee1 = new LeaderEmployee(employee.getId(), employee.getName(), employee.getDateOfBirth(), employee.getStartOfWork(), newPosition);
                employee1.setSalary(employee.getSalary());
            }
            dataBase.delEmployee(employee);
            dataBase.addEmployeeIndex(index, employee1);
        } else System.out.println("There is no employee with ID " + id);
    }

    public void changePosition(int id, MiddlePosition newPosition, List<Employee> employeeList) {
        Employee employee = searchEmployee(id, employeeList);
        if (employee != null) {
            MiddleEmployee employee1;
            int index = employeeList.indexOf(employee);

            if (employee instanceof MiddleEmployee) {
                employee1 = ((MiddleEmployee) employee);
                employee1.setPosition(newPosition);
            } else {
                employee1 = new MiddleEmployee(employee.getId(), employee.getName(), employee.getDateOfBirth(), employee.getStartOfWork(), newPosition);
                employee1.setSalary(employee.getSalary());
            }
            dataBase.delEmployee(employee);
            dataBase.addEmployeeIndex(index, employee1);
        } else System.out.println("There is no employee with ID " + id);
    }

    public void changePosition(int id, OrdinaryPosition newPosition, List<Employee> employeeList) {
        Employee employee = searchEmployee(id, employeeList);
        if (employee != null) {
            OrdinaryEmployee employee1;
            int index = employeeList.indexOf(employee);

            if (employee instanceof OrdinaryEmployee) {
                employee1 = ((OrdinaryEmployee) employee);
                employee1.setPosition(newPosition);
            } else {
                employee1 = new OrdinaryEmployee(employee.getId(), employee.getName(), employee.getDateOfBirth(), employee.getStartOfWork(), newPosition);
                employee1.setSalary(employee.getSalary());
            }
            dataBase.delEmployee(employee);
            dataBase.addEmployeeIndex(index, employee1);
        } else System.out.println("There is no employee with ID " + id);
    }

    public void printEmployeeWorkFromYear(int year, List<Employee> employeeList) {
        System.out.println("\n List of Employee are working from " + year + " year: \n");
        for (Employee e :
                employeeList) {
            if (e.getStartOfWork().getYear() == (year)) System.out.println(e);
        }
    }

    public void printEmployeeWithPosition(List<Employee> employeeList) {
        for (Employee e :
                employeeList) {
            if (e instanceof LeaderEmployee) {
                System.out.printf("ID: %-5s name: %-15s position: %-10s salary: %-7s  data start of working : %-11s%n", e.getId(), e.getName(), ((LeaderEmployee) e).getPosition(), e.getSalary(), e.getStartOfWork());
            } else if (e instanceof MiddleEmployee) {
                System.out.printf("ID: %-5s name: %-15s position: %-10s salary: %-7s  data start of working : %-11s%n", e.getId(), e.getName(), ((MiddleEmployee) e).getPosition(), e.getSalary(), e.getStartOfWork());
            } else
                System.out.printf("ID: %-5s name: %-15s position: %-10s salary: %-7s  data start of working : %-11s%n", e.getId(), e.getName(), ((OrdinaryEmployee) e).getPosition(), e.getSalary(), e.getStartOfWork());
        }
    }

    public static void main(String[] args) {
//        Тестирование методов
        Service service = new Service();
        Scanner scanner = new Scanner(System.in);
        List<Employee> employeeList = dataBase.getArrayEmployee();
//        List<Staffing> staffingList = dataBase.getArrayStaffing();

        service.createListStaffing();
        service.createListEmployee();

        service.printEmployeeWithPosition(employeeList);

        System.out.println("Make your choose: \n1 - Change employee position\n2 - Print sort list \n3 - Print employees are working by choose year");
        int choose = scanner.nextInt();
        switch (choose) {
            case 1 -> {
//                service.printEmployeeWithPosition();
                System.out.println("Input ID employee (in base 101 - 109) : ");
                int id = scanner.nextInt();
                System.out.println("Choose level for new position 1 - TOP, 2 - Middle, 3 - Ordinary : ");
                int ch = scanner.nextInt();
                scanner.nextLine();
                switch (ch) {
                    case 1 -> {
                        System.out.println("TOP : " + Arrays.toString(LeaderPosition.values()));
                        String position = scanner.nextLine();
                        try {
                            LeaderPosition enumPosition = LeaderPosition.valueOf(position);
                            service.changePosition(id, enumPosition, employeeList);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Position does not exist");
                        }
                    }
                    case 2 -> {
                        System.out.println(" Middle : " + Arrays.toString(MiddlePosition.values()));
                        String position = scanner.nextLine();
                        try {
                            MiddlePosition enumPosition = MiddlePosition.valueOf(position);
                            service.changePosition(id, enumPosition, employeeList);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Position does not exist");
                        }
                    }
                    case 3 -> {
                        System.out.println(" Ordinary : " + Arrays.toString(OrdinaryPosition.values()));
                        String position = scanner.nextLine();
                        try {
                            OrdinaryPosition enumPosition = OrdinaryPosition.valueOf(position);
                            service.changePosition(id, enumPosition, employeeList);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Position does not exist");
                        }
                    }
                    default -> System.out.println("You do not choose position level");
                }

                service.printEmployeeWithPosition(employeeList);
            }
            case 2 -> {
                System.out.println("select an option to sort : 1 - sort by NAME, 2 - sort by POSITION, 3 - sort by SALARY, 4 - sort by DATE OF START WORKING");
                int sort = scanner.nextInt();
                switch (sort) {
                    case 1 -> Collections.sort(employeeList);
                    case 2 -> employeeList.sort(new PositionNameComparator());
                    case 3 -> employeeList.sort(new SalaryNameComparator());
                    case 4 -> employeeList.sort(new DateStartWorkComparator());
                    default -> System.out.println("Select correct option to sort");
                }
                service.printEmployeeWithPosition(employeeList);
            }
            case 3 -> {
                System.out.println("Enter year : ");
                scanner.nextLine();
                int year = scanner.nextInt();
                service.printEmployeeWorkFromYear(year, employeeList);
            }
            default -> System.out.println("You do not choose action");
        }
        scanner.close();
    }
}

