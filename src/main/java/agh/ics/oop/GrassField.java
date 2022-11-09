package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class GrassField implements IWorldMap {
    private final int grassNumber;
    List<Grass> grasses;
    List<AnimalLab5> animals;
    public GrassField(int grassNumber){
        this.grassNumber = grassNumber; //liczba kepek trawy na mapie/planszy
        grasses = new ArrayList<>(); //lista kepek trawy na mapie/planszy
        animals = new ArrayList<>(); //lista zwierzakow na mapie
    }
    public int getGrassNumber(){
        return this.grassNumber;
    }
    @Override
    public boolean canMoveTo(Vector2d position){
        return !this.isOccupied(position);
    }
    @Override
    public boolean place(AnimalLab5 animal){
        if(canMoveTo(animal.getAnimalPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position){
        for (AnimalLab5 animal : animals) {
            if(animal.getAnimalPosition().equals(position)){
                return true;
            }
        }
        return false;
    }
    @Override
    public AnimalLab5 objectAt(Vector2d position){
        if(isOccupied(position)){
            for (AnimalLab5 animal : animals) {
                if(animal.getAnimalPosition().equals(position)){
                    return animal;
                }
            }
        }
        return null;
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
        for (AnimalLab5 animal : animals) {
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
        for (AnimalLab5 animal : animals) {
            maxX = Math.max(maxX, animal.getAnimalPosition().x);
            maxY = Math.max(maxY, animal.getAnimalPosition().y);
        }
        return new Vector2d(maxX, maxY);
    }


    public String toString(){
        return new MapVisualizerGrass(this).draw(new Vector2d(0, 0), getMaxPositionOnMap());
    }

}
