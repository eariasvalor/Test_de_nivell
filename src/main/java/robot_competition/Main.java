package robot_competition;

import robot_competition.entities.AerialRobot;
import robot_competition.entities.AquaticRobot;
import robot_competition.entities.Robot;
import robot_competition.entities.TerrestrialRobot;
import robot_competition.enums.PropellerType;
import robot_competition.enums.TractionType;
import robot_competition.service.RobotManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RobotManager robotManager = new RobotManager();
        int maxSpeed = 30;
        String manufacturer = "RoboCorp";

        TerrestrialRobot t40 = new TerrestrialRobot("TankBot", "RoboCorp", 2022, 3, TractionType.TRACKS);
        TerrestrialRobot t60 = new TerrestrialRobot("RunnerX", "RoboCorp", 2023, 60, TractionType.WHEELS);
        AerialRobot airBot = new AerialRobot("SkyDancer", "AeroDynamics", 2023, 120, 65);
        AquaticRobot aquaBot = new AquaticRobot("AquaRunner", "AquaTech", 2021, 400, PropellerType.HELIX);

        robotManager.addRobot(t40);
        robotManager.addRobot(t60);
        robotManager.addRobot(airBot);
        robotManager.addRobot(aquaBot);

        System.out.println("Here are the robots made by " + manufacturer + ":");
        System.out.println(robotManager.filterRobotsByManufacturer(manufacturer).stream()
                .map(Robot::getName)
                .toList());

        System.out.println("Here are the robots faster than " + maxSpeed + " km/h:");
        System.out.println(robotManager.filterTerrestrialRobotBySpeedGreaterThan(maxSpeed).stream()
                .map(Robot::getName)
                .toList());

        System.out.println("This is the technical description of all available robots:");
        robotManager.getRobots().stream()
                .map(Robot::toString)
                .forEach(System.out::println);
    }
}

