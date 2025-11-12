package robot_competition.entities;

import robot_competition.Interface.ResistanceEvaluable;
import robot_competition.enums.TractionType;

public class TerrestrialRobot extends Robot implements ResistanceEvaluable {
    private int maxSpeed;
    private TractionType tractionType;

    public TerrestrialRobot(String name, String manufacturer, int productionYear, int maxSpeed, TractionType tractionType) {
        super(name, manufacturer, productionYear);
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("The speed must be greater than 0.");
        }
        if (tractionType == null) {
            throw new IllegalArgumentException("The traction type is mandatory.");
        }
        this.maxSpeed = maxSpeed;
        this.tractionType = tractionType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public TractionType getTractionType() {
        return tractionType;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setTractionType(TractionType tractionType) {
        this.tractionType = tractionType;
    }

    @Override
    public String getResistanceReport() {
        String result = "This robot can take part in the competition.";
        if(!getTractionType().equals(TractionType.TRACKS)){
            result = "This robot cannot take part in the competition.";
        }
        return result;
    }

    @Override
    public String getTechnicalDescription() {
        return "Terrestrial Robot{" +
                "name=" + super.getName() +
                "manufacturer=" + super.getManufacturer() +
                "maxSpeed=" + maxSpeed +
                ", tractionType=" + tractionType +
                '}';
    }
}
