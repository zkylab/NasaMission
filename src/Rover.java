public class Rover {
    private Coordinate currentCoordinate;


    private CardinalCompass currentRotation;
    private CardinalCompassManager cardinalCompassManager;
    private char[] guide;

    public Rover(Coordinate currentCoordinate, CardinalCompass currentRotation, CardinalCompassManager cardinalCompassManager) {
        this.currentCoordinate = currentCoordinate;
        this.currentRotation = currentRotation;
        this.cardinalCompassManager = cardinalCompassManager;
        guide = null;
    }

    private void makeMovement() {
        currentCoordinate = cardinalCompassManager.calcualteNewCoordinate(currentCoordinate, currentRotation);
    }

    private void rotate(char where) {
        currentRotation = cardinalCompassManager.decideToWhere(currentRotation, where);
    }

    public void setGuide(String directions) {
        guide = directions.toCharArray();
    }

    public void doMission() {
        for (char c : guide) {
            if (c == 'M') {
                makeMovement();
            } else {
                rotate(c);
            }
        }
    }

    public CardinalCompass getCurrentRotation() {
        return currentRotation;
    }

    public Coordinate getCurrentCoordinate() {
        return currentCoordinate;
    }
}
