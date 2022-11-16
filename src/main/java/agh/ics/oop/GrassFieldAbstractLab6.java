package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class GrassFieldAbstractLab6 extends AbstractWorldMapLab6 {
    private final int grassNumber;
    Map<Vector2d, Grass> grasses;
    public GrassFieldAbstractLab6(int mapWidth, int mapHeight, int grassNumber) {
        super(mapWidth, mapHeight); //za te wymiary nalezy przyjac nieskonczonosc!!!
        this.grassNumber = grassNumber; //liczba kepek trawy na mapie/planszy
        grasses = new HashMap<>(); //lista kepek trawy na mapie/planszy
    }
    public int getGrassNumber(){
        return this.grassNumber;
    }
    public boolean isOccupiedGrass(Vector2d position){

       return grasses.containsKey(position);

    }
    public boolean canMoveToGrass(Vector2d position){
        if(position.x >= 0 && position.x <= Math.sqrt((this.grassNumber)*10) && position.y >= 0 && position.y <= Math.sqrt((this.grassNumber)*10)){
            return !this.isOccupiedGrass(position);
        }
        return false;
    }
    public boolean placeGrass(Grass grass){
        if(canMoveToGrass(grass.getPosition())){
            grasses.put(grass.getPosition(), grass);
            return true;
        }
        return false;
    }
    public Grass objectAtGrass(Vector2d position){
        if(isOccupiedGrass(position)){
            return (grasses.get(position));
        }
        return null;
    }

    public Vector2d getMinPositionOnMap(){
        int minX = (int) Double.POSITIVE_INFINITY;
        int minY = (int) Double.POSITIVE_INFINITY;
        for (Grass grass : grasses.values()) {
            minX = Math.min(minX, grass.getPosition().x);
            minY = Math.min(minY, grass.getPosition().y);
        }
        for (AnimalLab6Abstract animal : animals.values()) {
            minX = Math.min(minX, animal.getAnimalPosition().x);
            minY = Math.min(minY, animal.getAnimalPosition().y);
        }
        return new Vector2d(minX, minY);
    }
    public Vector2d getMaxPositionOnMap(){
        int maxX = (int) Double.NEGATIVE_INFINITY;
        int maxY = (int) Double.NEGATIVE_INFINITY;
        for (Grass grass : grasses.values()) {
            maxX = Math.max(maxX, grass.getPosition().x);
            maxY = Math.max(maxY, grass.getPosition().y);
        }
        for (AnimalLab6Abstract animal : animals.values()) {
            maxX = Math.max(maxX, animal.getAnimalPosition().x);
            maxY = Math.max(maxY, animal.getAnimalPosition().y);
        }
        return new Vector2d(maxX, maxY);
    }

}
