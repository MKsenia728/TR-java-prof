package hw221116.model;

import hw221116.interfaces.Charity;
import hw221116.enums.CharityType;
import hw221116.enums.LeaderPosition;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LeaderEmployee extends Employee implements Charity, Comparable<Employee> {
    private String education;
    private LeaderPosition position;

    public LeaderEmployee(int id, String name, LocalDate dateOfBirth, LocalDate startOfWork, LeaderPosition position) {
        super(id, name, dateOfBirth, startOfWork);
        this.position = position;
    }


    @Override
    public void workCharity(CharityType charityType) {
        System.out.println("Your charity activity is " + String.valueOf(charityType).toLowerCase());
    }
}
