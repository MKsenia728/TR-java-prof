package hw221116.model;

import hw221116.Charity;
import hw221116.Employee;
import hw221116.enums.CharityType;
import hw221116.enums.LeaderPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LeaderEmployee extends Employee implements Charity {
    private String education;
    private LeaderPosition position;

    public LeaderEmployee(String name, String dateOfBirth, String dateOfWork, int salary, LeaderPosition position) {
        super(name, dateOfBirth, dateOfWork, salary);
        this.position = position;
    }

    @Override
    public void workCharity(CharityType charityType) {
        System.out.println("Your charity activity is " + String.valueOf(charityType).toLowerCase());
    }
}
