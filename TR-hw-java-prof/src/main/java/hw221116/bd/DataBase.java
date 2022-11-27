package hw221116.bd;

import hw221116.model.Employee;
import hw221116.model.LeaderEmployee;
import hw221116.model.MiddleEmployee;
import hw221116.model.OrdinaryEmployee;
import hw221116.staffing.LeaderStaffing;
import hw221116.staffing.MiddleStaffing;
import hw221116.staffing.OrdinaryStaffing;
import hw221116.staffing.Staffing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DataBase {
    private List<Employee> ArrayEmployee = new LinkedList<>();
    private List<Staffing> ArrayStaffing = new ArrayList<>();

    public void addStaffing(Staffing staffing) {
        ArrayStaffing.add(staffing);
    }

    public void addEmployee(Employee employee) {
        fillSalaryByPosition(employee);
        ArrayEmployee.add(employee);
    }

    private void fillSalaryByPosition(Employee employee) {
        if (employee instanceof LeaderEmployee) {
            for (Staffing st : ArrayStaffing) {
                if (st instanceof LeaderStaffing)
                    if (((LeaderStaffing) st).getPosition().equals(((LeaderEmployee) employee).getPosition()))
                        employee.setSalary(st.getWageRate());
            }
        } else if (employee instanceof MiddleEmployee) {
            for (Staffing st : ArrayStaffing) {
                if (st instanceof MiddleStaffing)
                    if (((MiddleStaffing) st).getPosition().equals(((MiddleEmployee) employee).getPosition()))
                        employee.setSalary(st.getWageRate());
            }
        } else if (employee instanceof OrdinaryEmployee) {
            for (Staffing st : ArrayStaffing) {
                if (st instanceof OrdinaryStaffing)
                    if (((OrdinaryStaffing) st).getPosition().equals(((OrdinaryEmployee) employee).getPosition()))
                        employee.setSalary(st.getWageRate());
            }
        }
    }


    public void addEmployeeIndex(int index, Employee employee) {
        fillSalaryByPosition(employee);
        ArrayEmployee.add(index, employee);
    }

    public void delEmployee(Employee employee) {
        ArrayEmployee.remove(employee);
    }

    public void clearEmployee() {
        ArrayEmployee.clear();
    }

    public List<Employee> getArrayEmployee() {
        return ArrayEmployee;
    }

    public void setArrayEmployee(List<Employee> arrayEmployee) {
        ArrayEmployee = arrayEmployee;
    }

    public List<Staffing> getArrayStaffing() {
        return ArrayStaffing;
    }

    public void setArrayStaffing(List<Staffing> arrayStaffing) {
        ArrayStaffing = arrayStaffing;
    }
}
