import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Scanner nasaCommunicator = new Scanner(System.in);
        Coordinate coordinate1 = new Coordinate(3, 3);
        CardinalCompass cardinalCompass = CardinalCompass.EAST;
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        Rover r1 = new Rover(coordinate1, cardinalCompass, cardinalCompassManager);
        String movements = "MMRMMRMRRM";
        r1.setGuide(movements);
        r1.doMission();
        Coordinate cord1 = r1.getCurrentCoordinate();
        System.out.println(cord1.getX() + "," + cord1.getY() + "-" + r1.getCurrentRotation());

    }


}
