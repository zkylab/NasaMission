import java.util.*;
import java.util.stream.Collectors;

public class MissionManager {
    private TreeMap<String,String> missionInformations = new TreeMap<>();
    private Scanner nasaCommunicator = new Scanner(System.in);

    public void getMissionDirectives(){
        System.out.println("-------------------NASA MARS MISSON-------------------");
        System.out.println("NASA ");
        System.out.println("---------------------------------------------------------");
        System.out.println("You need to specify right-top coordinate ex: 3 3\n");
        String receivedCoordinates = nasaCommunicator.nextLine();
        // Coordinates
        List<Integer> ints = Arrays.stream(receivedCoordinates.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        System.out.println("How many rovers will accomplish this mission? ex: 2");
        int numberOfRovers = nasaCommunicator.nextInt();
        for(int k=0; k<numberOfRovers;k++){
            System.out.println("What is the initial coordinate and of Rover-" + k);
            String receivedInitialInfo = nasaCommunicator.nextLine();
            String[] recevivedInitalInfoArray = receivedInitialInfo.split(" ");
            List<Integer> roverinitialCoord = new ArrayList<>();
            roverinitialCoord.add(Integer.parseInt(recevivedInitalInfoArray[0]));
            roverinitialCoord.add(Integer.parseInt(recevivedInitalInfoArray[1]));

        }
    }

}
