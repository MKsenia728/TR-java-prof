package hw221116.comparators;

import hw221116.model.Employee;

import java.util.Comparator;

public class DateStartWorkComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee em1, Employee em2) {
        int res = em1.getStartOfWork().compareTo(em2.getStartOfWork());
        if (res == 0) res = em1.getName().compareTo(em2.getName());
        return res;
    }
}
