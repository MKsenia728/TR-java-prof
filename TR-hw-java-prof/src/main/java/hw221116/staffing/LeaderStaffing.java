package hw221116.staffing;


import hw221116.enums.LeaderPosition;
import lombok.Getter;
import lombok.Setter;


public class LeaderStaffing extends Staffing{

    private LeaderPosition position;

    public LeaderStaffing(int wageRate, LeaderPosition position) {
        super(wageRate);
        this.position = position;
    }

    public LeaderPosition getPosition() {
        return position;
    }

    public void setPosition(LeaderPosition position) {
        this.position = position;
    }


//    @Override
//    protected int receiveAnnualBonus() {
//        return getWageRate() / 100 * 300;
//    }
//
//    @Override
//    protected int receiveQuarterBonus() {
//        return getWageRate() / 100 * 70;
//    }
}
