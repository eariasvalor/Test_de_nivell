package robot_competition.entities;

import robot_competition.Interface.ResistanceEvaluable;

public class AerialRobot extends Robot implements ResistanceEvaluable {
    private int maxAltitude;
    private int flightAutonomy;

    public AerialRobot(String name, String manufacturer, int productionYear, int maxAltitude, int flightAutonomy) {
        super(name, manufacturer, productionYear);
        if (maxAltitude < 0) {
            throw new IllegalArgumentException("The altitude must be greater than o.");
        }
        if (flightAutonomy < 0) {
            throw new IllegalArgumentException("The flight autonomy must be greater than 0.");
        }
        this.maxAltitude = maxAltitude;
        this.flightAutonomy = flightAutonomy;
    }

    public int getMaxAltitude() {
        return maxAltitude;
    }

    public int getFlightAutonomy() {
        return flightAutonomy;
    }

    public void setMaxAltitude(int maxAltitude) {
        this.maxAltitude = maxAltitude;
    }

    public void setFlightAutonomy(int flightAutonomy) {
        this.flightAutonomy = flightAutonomy;
    }

    @Override
    public String getResistanceReport() {
        String result = "This robot can take part in the competition.";

        if(flightAutonomy < 60){
            result = "This robot cannot take part in the competition.";
        }
        return result;
    }

    @Override
    public String getTechnicalDescription() {
        return "Aerial Robot{" +
                "name=" + super.getName() +
                "manufacturer=" + super.getManufacturer() +
                "maxDepth=" + maxAltitude +
                ", propellerSystem=" + flightAutonomy +
                '}';
    }
}
