package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class AnimalLab6Abstract {
    public final MapDirection orientation_start = MapDirection.NORTH;
    private MapDirection orientation;
    private Vector2d position;
    private AbstractWorldMapLab6 animalMap;
    List<IPositionChangeObserver> observers = new ArrayList<>(); //lista obserwatorow
    public AnimalLab6Abstract(AbstractWorldMapLab6 map, Vector2d position){
        this.animalMap = map;
        this.position = position;
        this.orientation = orientation_start;
    }

    public Vector2d getAnimalPosition(){
        return position;
    }
    public void setAnimalPosition(Vector2d newPosition){ this.position = newPosition; } //setter
    public MapDirection getAnimalOrientation(){
        return orientation;
    }
    public AbstractWorldMapLab6 getAnimalMap(){
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
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
