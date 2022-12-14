/*
package agh.ics.oop;

public class AnimalLab5Abstract {
    public final MapDirection orientation_start = MapDirection.NORTH;
    private MapDirection orientation;
    private Vector2d position;
    private AbstractWorldMap animalMap;
    public AnimalLab5Abstract(AbstractWorldMap map, Vector2d position){
        this.animalMap = map;
        this.position = position;
        this.orientation = orientation_start;
    }

    public Vector2d getAnimalPosition(){
        return position;
    }
    public MapDirection getAnimalOrientation(){
        return orientation;
    }
    public AbstractWorldMap getAnimalMap(){
        return animalMap;
    }
    public String toString(MapDirection orientation){
        String res = null;
        switch (orientation) {
            case NORTH -> {
                res = "N";
            }
            case EAST -> {
                res = "E";
            }
            case SOUTH -> {
                res = "S";
            }
            case WEST -> {
                res = "W";
            }
        }
        return res;
    }

    public boolean isAt(Vector2d position){
        return (this.position.equals(position));
    }
    public void move(MoveDirection direction) {
        boolean temp = false;
        Vector2d newPosition = position;
        switch (direction) {
            case LEFT -> orientation = orientation.previous(orientation);
            case RIGHT -> orientation = orientation.next(orientation);
            case BACKWARD -> {
                newPosition = position.subtract(orientation.toUnitVector(orientation));
                temp = animalMap.canMoveTo(newPosition);
            }
            case FORWARD -> {
                newPosition = position.add(orientation.toUnitVector(orientation));
                temp = animalMap.canMoveTo(newPosition);
            }
        }
        if((direction == MoveDirection.BACKWARD || direction == MoveDirection.FORWARD) && temp) {

            this.position = newPosition;

        }

    }

}

 */
