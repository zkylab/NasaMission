import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Reach Mission Manager with Singleton and start to operation
        MissionManager missionManager = MissionManager.getInstance();
        // This will get information from operation team lead
        int numberOfRovers = missionManager.prepareForMission();
        ArrayList<Rover> rovers =missionManager.roverCreator(numberOfRovers);

        for (Rover rover: rovers){
            rover.doMission();
            if(missionManager.checkCoordinate(rover.getCurrentCoordinate())){
                System.out.println("The rover went off the map! Mission is uncompleted!");
            }else{
                System.out.println(rover.toString());
            }
        }
    }
}
