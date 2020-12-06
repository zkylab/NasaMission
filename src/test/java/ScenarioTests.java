import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ScenarioTests {

    @Test
    public void useCase1Test(){
        Coordinate coordinate = new Coordinate(1,2);
        CardinalCompass cardinalCompass = CardinalCompass.NORTH;
        Rover rover1 = new Rover(coordinate,cardinalCompass,new CardinalCompassManager());
        rover1.setGuide("LMLMLMLMM");
        rover1.doMission();
        assertEquals(CardinalCompass.NORTH,rover1.getCurrentRotation());
        assertEquals(new Coordinate(1,3), rover1.getCurrentCoordinate());
    }

    @Test
    public void useCase2Test(){
        Coordinate coordinate = new Coordinate(3,3);
        CardinalCompass cardinalCompass = CardinalCompass.EAST;
        Rover rover1 = new Rover(coordinate,cardinalCompass,new CardinalCompassManager());
        rover1.setGuide("MMRMMRMRRM");
        rover1.doMission();
        assertEquals(CardinalCompass.EAST,rover1.getCurrentRotation());
        assertEquals(new Coordinate(5,1), rover1.getCurrentCoordinate());
    }
}
