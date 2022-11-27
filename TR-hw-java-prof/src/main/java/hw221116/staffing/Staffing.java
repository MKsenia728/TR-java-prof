package hw221116.staffing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor

public class Staffing {
    private int wageRate;

    protected int receiveAnnualBonus() {
        return 0;
    }

    protected int receiveQuarterBonus() {
        return 0;
    }


}
