import java.util.*;
import java.util.stream.Collectors;

public class MissionManager {
    private Scanner nasaCommunicator = new Scanner(System.in);
    private static MissionManager instance = null;
    private ArrayList<Rover> rovers = new ArrayList<>();
    List<Integer> mapSize = null;

    private MissionManager() {

    }

    /**
     * Creating mission manager instance. All operations can be started in here.
     *
     * @return Mission Manager singleton object
     */
    public static MissionManager getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new MissionManager();
        }
    }

    /**
     * check the rover is on map or not
     *
     * @param coordinate rover's last coordinate
     * @return on map or not
     */
    public boolean checkCoordinate(Coordinate coordinate) {
        return coordinate.getX() < mapSize.get(0) || coordinate.getY() < mapSize.get(1);
    }

    /**
     * Introduction the mission and gathering necessary input values from user.
     * In here, we will store map's size, number of rovers
     *
     * @return number of rovers
     */
    public int prepareForMission() {
        System.out.println("-------------------NASA MARS MISSON-------------------");
        System.out.println("North - N");
        System.out.println("East - E");
        System.out.println("South - S");
        System.out.println("West - W");
        System.out.println("L - Left");
        System.out.println("R - Right");
        System.out.println("M - Middle");
        System.out.println("---------------------------------------------------------");
        System.out.println("You need to specify map's right-top coordinate ex: 3 3\n");

        // Get map's size and convert. Actually it can be done in other easy ways
        // but using stream is very cool.
        String receivedCoordinates = nasaCommunicator.nextLine();
        mapSize = Arrays.stream(receivedCoordinates.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Get number of rovers.
        System.out.println("How many rovers will accomplish this mission? ex: 2");
        int numberOfRovers = nasaCommunicator.nextInt();
        nasaCommunicator.nextLine();
        return numberOfRovers;
    }

    /**
     * Gathering necessary inputs which are related to operational rovers.
     *
     * @param numberOfRovers which specify how many rovers will be used in the special operation
     * @return created rovers that are ready to mission.
     */
    public ArrayList<Rover> roverCreator(int numberOfRovers) {
        // Fill all rovers and their directives
        for (int k = 0; k < numberOfRovers; k++) {
            System.out.println("What is the initial coordinate and compass and of Rover-" + k + ". Ex: 1 2 N");
            String receivedInitialInfo = nasaCommunicator.nextLine();
            System.out.println("You mean = " + receivedInitialInfo);
            String[] recevivedInitalInfoArray = receivedInitialInfo.split(" ");
            Coordinate coordinate = new Coordinate(Integer.parseInt(recevivedInitalInfoArray[0]), Integer.parseInt(recevivedInitalInfoArray[1]));
            char roverInitialCompassLetter = recevivedInitalInfoArray[2].charAt(0);
            CardinalCompass initialRotation = switch (roverInitialCompassLetter) {
                case 'N' -> CardinalCompass.NORTH;
                case 'E' -> CardinalCompass.EAST;
                case 'S' -> CardinalCompass.SOUTH;
                case 'W' -> CardinalCompass.WEST;
                default -> throw new IllegalStateException("Unexpected value: " + roverInitialCompassLetter);
            };
            System.out.println("What is the directions of this mission for Rover-" + k + ". Ex: LLMMLMLM");
            String direction = nasaCommunicator.nextLine();
            Rover rover = new Rover(coordinate, initialRotation, new CardinalCompassManager());
            rover.setGuide(direction);
            rovers.add(rover);
        }
        return rovers;
    }

    public List<Integer> getMapSize() {
        return mapSize;
    }

    public void setMapSize(List<Integer> mapSize) {
        this.mapSize = mapSize;
    }


}
