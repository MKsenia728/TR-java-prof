package hw221116.model;

import hw221116.Employee;
import hw221116.Training;
import hw221116.enums.MiddlePosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MiddleEmployee extends Employee implements Training {
    private MiddlePosition position;
    private int experience;

    public MiddleEmployee(String name, String dateOfBirth, String dateOfWork, int salary, MiddlePosition position, int experience) {
        super(name, dateOfBirth, dateOfWork, salary);
        this.position = position;
        this.experience = experience;
    }

    @Override
    public void trainingType(String courseName) {
        System.out.println("You learn on " + courseName + " course");
    }

    @Override
    public double insureSum() {
        return super.insureSum() * 5;
    }
}
