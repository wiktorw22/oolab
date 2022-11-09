package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassFieldAbstract extends AbstractWorldMap {
    private final int grassNumber;
    List<Grass> grasses;
    public GrassFieldAbstract(int mapWidth, int mapHeight, int grassNumber) {
        super(mapWidth, mapHeight); //za te wymiary nalezy przyjac nieskonczonosc!!!
        this.grassNumber = grassNumber; //liczba kepek trawy na mapie/planszy
        grasses = new ArrayList<>(); //lista kepek trawy na mapie/planszy
    }
    public int getGrassNumber(){
        return this.grassNumber;
    }
    public boolean isOccupiedGrass(Vector2d position){
        for (Grass grass : grasses) {
            if(grass.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    public boolean canMoveToGrass(Vector2d position){
        if(position.x >= 0 && position.x <= Math.sqrt((this.grassNumber)*10) && position.y >= 0 && position.y <= Math.sqrt((this.grassNumber)*10)){
            return !this.isOccupiedGrass(position);
        }
        return false;
    }
    public boolean placeGrass(Grass grass){
        if(canMoveToGrass(grass.getPosition())){
            grasses.add(grass);
            return true;
        }
        return false;
    }
    public Grass objectAtGrass(Vector2d position){
        if(isOccupiedGrass(position)){
            for (Grass grass : grasses) {
                if(grass.getPosition().equals(position)){
                    return grass;
                }
            }
        }
        return null;
    }

    public Vector2d getMinPositionOnMap(){
        int minX = (int) Double.POSITIVE_INFINITY;
        int minY = (int) Double.POSITIVE_INFINITY;
        for (Grass grass : grasses) {
            minX = Math.max(minX, grass.getPosition().x);
            minY = Math.max(minY, grass.getPosition().y);
        }
        for (AnimalLab5Abstract animal : animals) {
            minX = Math.max(minX, animal.getAnimalPosition().x);
            minY = Math.max(minY, animal.getAnimalPosition().y);
        }
        return new Vector2d(minX, minY);
    }
    public Vector2d getMaxPositionOnMap(){
        int maxX = (int) Double.NEGATIVE_INFINITY;
        int maxY = (int) Double.NEGATIVE_INFINITY;
        for (Grass grass : grasses) {
            maxX = Math.max(maxX, grass.getPosition().x);
            maxY = Math.max(maxY, grass.getPosition().y);
        }
        for (AnimalLab5Abstract animal : animals) {
            maxX = Math.max(maxX, animal.getAnimalPosition().x);
            maxY = Math.max(maxY, animal.getAnimalPosition().y);
        }
        return new Vector2d(maxX, maxY);
    }

}
