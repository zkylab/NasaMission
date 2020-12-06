import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MissionManagerTests {

    @Test
    public void checkCoordinateTestInsideMap(){
        List<Integer> mapCoordinates = new ArrayList<>();
        mapCoordinates.add(5);
        mapCoordinates.add(8);
        Coordinate roverCoordinate = new Coordinate(2,3);
        MissionManager missionManager = MissionManager.getInstance();
        missionManager.setMapSize(mapCoordinates);
        assertTrue(missionManager.checkCoordinate(roverCoordinate));
    }

    @Test
    public void checkCoordinateTestOutsideMap(){
        List<Integer> mapCoordinates = new ArrayList<>();
        mapCoordinates.add(7);
        mapCoordinates.add(9);
        Coordinate roverCoordinate = new Coordinate(10,73);
        MissionManager missionManager = MissionManager.getInstance();
        missionManager.setMapSize(mapCoordinates);
        assertFalse(missionManager.checkCoordinate(roverCoordinate));
    }

    @Test
    public void checkCoordinateTestZeroBothMapSize(){
        List<Integer> mapCoordinates = new ArrayList<>();
        mapCoordinates.add(0);
        mapCoordinates.add(0);
        Coordinate roverCoordinate = new Coordinate(10,73);
        MissionManager missionManager = MissionManager.getInstance();
        missionManager.setMapSize(mapCoordinates);
        assertFalse(missionManager.checkCoordinate(roverCoordinate));
    }

    @Test
    public void checkCoordinateTestZeroXSideMapSize(){
        List<Integer> mapCoordinates = new ArrayList<>();
        mapCoordinates.add(0);
        mapCoordinates.add(10);
        Coordinate roverCoordinate = new Coordinate(2,4);
        MissionManager missionManager = MissionManager.getInstance();
        missionManager.setMapSize(mapCoordinates);
        assertFalse(missionManager.checkCoordinate(roverCoordinate));
    }

    @Test
    public void checkCoordinateTestZeroYSideMapSize(){
        List<Integer> mapCoordinates = new ArrayList<>();
        mapCoordinates.add(10);
        mapCoordinates.add(0);
        Coordinate roverCoordinate = new Coordinate(2,4);
        MissionManager missionManager = MissionManager.getInstance();
        missionManager.setMapSize(mapCoordinates);
        assertFalse(missionManager.checkCoordinate(roverCoordinate));
    }
}
