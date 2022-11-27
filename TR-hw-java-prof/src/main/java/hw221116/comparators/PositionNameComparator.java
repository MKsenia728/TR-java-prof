package hw221116.comparators;

import hw221116.enums.LeaderPosition;
import hw221116.model.Employee;
import hw221116.model.LeaderEmployee;
import hw221116.model.MiddleEmployee;
import hw221116.model.OrdinaryEmployee;

import java.util.Comparator;

public class PositionNameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee em1, Employee em2) {
        int res = 0;

        if (em1 instanceof LeaderEmployee) {
            String em1Position = ((LeaderEmployee) em1).getPosition().toString();
            if (em2 instanceof LeaderEmployee) {
                res = em1Position.compareTo((((LeaderEmployee) em2).getPosition()).toString());
            } else if (em2 instanceof MiddleEmployee) {
                res = em1Position.compareTo((((MiddleEmployee) em2).getPosition()).toString());
            } else res = em1Position.compareTo((((OrdinaryEmployee) em2).getPosition()).toString());

        }

        if (em1 instanceof MiddleEmployee) {
            String em1Position = ((MiddleEmployee) em1).getPosition().toString();
            if (em2 instanceof LeaderEmployee) {
                res = em1Position.compareTo((((LeaderEmployee) em2).getPosition()).toString());
            } else if (em2 instanceof MiddleEmployee) {
                res = em1Position.compareTo((((MiddleEmployee) em2).getPosition()).toString());
            } else res = em1Position.compareTo((((OrdinaryEmployee) em2).getPosition()).toString());

        }

        if (em1 instanceof OrdinaryEmployee) {
            String em1Position = ((OrdinaryEmployee) em1).getPosition().toString();
            if (em2 instanceof LeaderEmployee) {
                res = em1Position.compareTo((((LeaderEmployee) em2).getPosition()).toString());
            } else if (em2 instanceof MiddleEmployee) {
                res = em1Position.compareTo((((MiddleEmployee) em2).getPosition()).toString());
            } else res = em1Position.compareTo((((OrdinaryEmployee) em2).getPosition()).toString());

        }

        if (res == 0) res = em1.getName().compareTo(em2.getName());

        return res;
    }
}
