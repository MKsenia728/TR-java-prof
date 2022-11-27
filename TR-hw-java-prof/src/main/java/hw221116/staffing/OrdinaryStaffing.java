package hw221116.staffing;

import hw221116.enums.OrdinaryPosition;

public class OrdinaryStaffing extends Staffing {
    private OrdinaryPosition position;

    public OrdinaryStaffing(int wageRate, OrdinaryPosition position) {
        super(wageRate);
        this.position = position;
    }

    @Override
    protected int receiveAnnualBonus() {
        return getWageRate();
    }

    public OrdinaryPosition getPosition() {
        return position;
    }

    public void setPosition(OrdinaryPosition position) {
        this.position = position;
    }
}
