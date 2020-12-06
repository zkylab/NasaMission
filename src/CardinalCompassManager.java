public class CardinalCompassManager {
    private CardinalCompass cardinalCompass;
    public CardinalCompassManager(){

    }

    public CardinalCompass decideToWhere(CardinalCompass current, char where){
        int currentCompassIndex = current.ordinal();
        int movement = switch (where) {
            case 'L' -> -1;
            case 'R' -> +1;
            default -> 0;
        };
        int newCompassIndex = currentCompassIndex + movement;
        if(currentCompassIndex + movement < 0){
            newCompassIndex += CardinalCompass.values().length;
        }
        return CardinalCompass.values()[(newCompassIndex) % 4];
    }


    public Coordinate calcualteNewCoordinate(Coordinate cord, CardinalCompass currentRotation){
        switch (currentRotation) {
            case NORTH -> cord.setY(cord.getY() + 1);
            case EAST -> cord.setX(cord.getX() + 1);
            case SOUTH -> cord.setY(cord.getY() - 1);
            case WEST -> cord.setX(cord.getX() - 1);
        }
        return cord;
    }

}
