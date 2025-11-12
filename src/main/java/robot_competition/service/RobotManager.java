package robot_competition.service;

import robot_competition.entities.Robot;
import robot_competition.entities.TerrestrialRobot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RobotManager {
    List<Robot> robots = new ArrayList<>();

    public void addRobot(Robot robot) {
        if (robot == null) {
            throw new IllegalArgumentException("The robot cannot be null.");
        }
        robots.add(robot);
    }

    public List<Robot> getRobots() {
        return Collections.unmodifiableList(robots);
    }

    public List<Robot> filterTerrestrialRobotBySpeedGreaterThan(int speed){
        return robots.stream()
                .filter(robot -> robot instanceof TerrestrialRobot terrestrialRobot
                        && terrestrialRobot.getMaxSpeed() > speed)
                .toList();
    }

    public List<Robot> filterRobotsByManufacturer(String manufacturer){
        return robots.stream()
                .filter(robot ->robot.getManufacturer().equalsIgnoreCase(manufacturer))
                .toList();
    }

    public String getAllTechnicalDescription(){
        return robots.stream()
                .map(robot -> robot.getTechnicalDescription())
                .toString();
    }

}
