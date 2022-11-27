package hw221116.staffing;

import hw221116.enums.MiddlePosition;

public class MiddleStaffing extends Staffing{
    private MiddlePosition position;

    public MiddleStaffing(int wageRate, MiddlePosition position) {
        super(wageRate);
        this.position = position;
    }


    @Override
    protected int receiveAnnualBonus() {
        return getWageRate() / 100 * 150;
    }

    @Override
    protected int receiveQuarterBonus() {
        return getWageRate() / 100 * 50;
    }

    public MiddlePosition getPosition() {
        return position;
    }

    public void setPosition(MiddlePosition position) {
        this.position = position;
    }
}
