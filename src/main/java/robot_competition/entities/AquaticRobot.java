package robot_competition.entities;

import robot_competition.enums.PropellerType;

public class AquaticRobot extends Robot {
    private int maxDepth;
    private PropellerType propellerType;

    public AquaticRobot(String name, String manufacturer, int productionYear, int maxDepth, PropellerType propellerType) {
        super(name, manufacturer, productionYear);
        if (maxDepth < 0) {
            throw new IllegalArgumentException("The depth must be greater than 0");
        }
        if (propellerType == null) {
            throw new IllegalArgumentException("The propeller type is mandatory.");
        }
        this.maxDepth = maxDepth;
        this.propellerType = propellerType;
    }

    public int getMaxDepth() {
        return maxDepth;
    }

    public PropellerType getPropellerType() {
        return propellerType;
    }

    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    public void setPropellerType(PropellerType propellerType) {
        this.propellerType = propellerType;
    }

    @Override
    public String getTechnicalDescription() {
        return "Aquatic Robot{" +
                "name=" + super.getName() +
                "manufacturer=" + super.getManufacturer() +
                "maxDepth=" + maxDepth +
                ", propellerSystem=" + propellerType +
                '}';
    }
}
