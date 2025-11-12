package robot_competition.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robot_competition.entities.AerialRobot;
import robot_competition.entities.AquaticRobot;
import robot_competition.entities.Robot;
import robot_competition.entities.TerrestrialRobot;
import robot_competition.enums.PropellerType;
import robot_competition.enums.TractionType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotManagerTest {
    RobotManager robotManager = new RobotManager();
    List<Robot> robots = new ArrayList<>();

    @BeforeEach
    void setUp() {

        TerrestrialRobot t40 = new TerrestrialRobot("TankBot", "RoboCorp", 2022, 3, TractionType.TRACKS);
        TerrestrialRobot t60 = new TerrestrialRobot("RunnerX", "RoboCorp", 2023, 60, TractionType.WHEELS);
        AerialRobot airBot = new AerialRobot("SkyDancer", "AeroDynamics", 2023, 120, 65);
        AquaticRobot aquaBot = new AquaticRobot("AquaRunner", "AquaTech", 2021, 400, PropellerType.HELIX);

        robotManager.addRobot(t40);
        robotManager.addRobot(t60);
        robotManager.addRobot(airBot);
        robotManager.addRobot(aquaBot);
    }

    @Test
    void addNullRobotsThrowsException() {
        try {
            robotManager.addRobot(null);
            System.out.println("Exception not thrown)");
        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }
        System.out.println();
    }

    @Test
    void filterRobotsByMaxSpeed50() {

        List<Robot> filteredRobots = robotManager.robots.stream()
                .filter(robot -> robot instanceof TerrestrialRobot terrestrialRobot
                        && terrestrialRobot.getMaxSpeed() > 50)
                .toList();

       assertEquals(filteredRobots, robotManager.robots.get(1));

    }




}