import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardinalCompassManagerTest {

    @Test
    public void decideToWhereFromNorthToLeftTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        CardinalCompass current = CardinalCompass.NORTH;
        char toRotate = 'L';
        assertEquals(CardinalCompass.WEST,cardinalCompassManager.decideToWhere(current,toRotate));
    }

    @Test
    public void decideToWhereFromNorthToRightTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        CardinalCompass current = CardinalCompass.NORTH;
        char toRotate = 'R';
        assertEquals(CardinalCompass.EAST, cardinalCompassManager.decideToWhere(current,toRotate));
    }

    @Test(expected = IllegalStateException.class)
    public void decideToWhereFromNorthToNowhereTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        CardinalCompass current = CardinalCompass.NORTH;
        char toRotate = 'Z';
        cardinalCompassManager.decideToWhere(current,toRotate);
    }

    @Test
    public void calculateNewCoordinateGoEastTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        Coordinate coordinate = new Coordinate(1,2);
        CardinalCompass cardinalCompass = CardinalCompass.EAST;
        Coordinate returnedCoordinate = cardinalCompassManager.calcualteNewCoordinate(coordinate,cardinalCompass);
        assertEquals(new Coordinate(2,2), returnedCoordinate);
    }

    @Test
    public void calculateNewCoordinateGoWestTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        Coordinate coordinate = new Coordinate(1,2);
        CardinalCompass cardinalCompass = CardinalCompass.WEST;
        Coordinate returnedCoordinate = cardinalCompassManager.calcualteNewCoordinate(coordinate,cardinalCompass);
        assertEquals(new Coordinate(0,2), returnedCoordinate);
    }

    @Test
    public void calculateNewCoordinateGoNorthTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        Coordinate coordinate = new Coordinate(1,2);
        CardinalCompass cardinalCompass = CardinalCompass.NORTH;
        Coordinate returnedCoordinate = cardinalCompassManager.calcualteNewCoordinate(coordinate,cardinalCompass);
        assertEquals(new Coordinate(1,3), returnedCoordinate);
    }

    @Test
    public void calculateNewCoordinateGoSouthTest(){
        CardinalCompassManager cardinalCompassManager = new CardinalCompassManager();
        Coordinate coordinate = new Coordinate(1,2);
        CardinalCompass cardinalCompass = CardinalCompass.SOUTH;
        Coordinate returnedCoordinate = cardinalCompassManager.calcualteNewCoordinate(coordinate,cardinalCompass);
        assertEquals(new Coordinate(1,1), returnedCoordinate);
    }
}
