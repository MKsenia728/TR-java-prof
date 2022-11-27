package hw221116.model;

import hw221116.interfaces.Training;
import hw221116.enums.OrdinaryPosition;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter

public class OrdinaryEmployee extends Employee implements Training {

    private OrdinaryPosition position;

    public OrdinaryEmployee(int id, String name, LocalDate dateOfBirth, LocalDate startOfWork, OrdinaryPosition position) {
        super(id, name, dateOfBirth, startOfWork);
        this.position = position;
    }

    @Override
    public void trainingType(String gumName) {
        System.out.println("You go to the " + gumName + " gum");
    }

    @Override
    public double TakeInsureSum() {
        return super.TakeInsureSum() * 10;
    }
}
