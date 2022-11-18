package hw221116.model;

import hw221116.Employee;
import hw221116.Training;
import hw221116.enums.OrdinaryPosition;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class OrdinaryEmployee extends Employee implements Training {

    private OrdinaryPosition position;

    public OrdinaryEmployee(String name, String dateOfBirth, String dateOfWork, int salary, OrdinaryPosition position) {
        super(name, dateOfBirth, dateOfWork, salary);
        this.position = position;
    }

    @Override
    public void trainingType(String gumName) {
        System.out.println("You go to the " + gumName + " gum");
    }

    @Override
    public double insureSum() {
        return super.insureSum() * 10;
    }
}
