package hw221116.model;

import hw221116.interfaces.Training;
import hw221116.enums.MiddlePosition;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MiddleEmployee extends Employee implements Training {
    private MiddlePosition position;
    private int experience;

    public MiddleEmployee(int id, String name, LocalDate dateOfBirth, LocalDate startOfWork, MiddlePosition position) {
        super(id, name, dateOfBirth, startOfWork);
        this.position = position;
    }

    @Override
    public void trainingType(String courseName) {
        System.out.println("You learn on " + courseName + " course");
    }


    @Override
    public double TakeInsureSum() {
        return super.TakeInsureSum() * 5;
    }
}
