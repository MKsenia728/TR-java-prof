package hw221116;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Employee {

    private String name;
    private String dateOfBirth;
    private String dateOfWork;
    private int salary;

    public double insureSum() {
        return salary * 0.1;
    }

}
