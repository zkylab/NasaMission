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

    /**
     * Triggering to compass manager in order to make movement and store new coordinate
     */
    private void makeMovement() {
        currentCoordinate = cardinalCompassManager.calcualteNewCoordinate(currentCoordinate, currentRotation);
    }

    /**
     * Triggering to compass manager in order to rotate rover
     * @param where (L)eft, (R)ight
     */
    private void rotate(char where) {
        currentRotation = cardinalCompassManager.decideToWhere(currentRotation, where);
    }

    /**
     * Set guide for rover mission
     * @param directions steps of mission, example: LMMMLRRMR
     */
    public void setGuide(String directions) {
        guide = directions.toCharArray();
    }

    /**
     * The controller method which uses coordinate and compass for making movement or rotating.
     */
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

    @Override
    public String toString() {
        String returnPlace = "Coordinate and Compass : " + getCurrentCoordinate().getX()
                + "," +getCurrentCoordinate().getY() + " " + getCurrentRotation();
        return returnPlace;
    }
}
