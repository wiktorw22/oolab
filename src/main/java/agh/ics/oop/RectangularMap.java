package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int mapWidth;
    private final int mapHeight;
    List<AnimalLab4> animals;
    public RectangularMap(int mapWidth, int mapHeight){
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        animals = new ArrayList<>();
    }
    public List<AnimalLab4> getAnimalsArray(){
        return animals; //getter
    }
    public int getMapWidth(){
        return this.mapWidth;
    }
    public int getMapHeight(){
        return this.mapHeight;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x >= 0 && position.x < mapWidth && position.y >= 0 && position.y < mapHeight){
            return !this.isOccupied(position);
        }
        return false;
    }

    @Override
    public boolean place(AnimalLab4 animal) {
        if(canMoveTo(animal.getAnimalPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (AnimalLab4 animal : animals) {
            if(animal.getAnimalPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public AnimalLab4 objectAt(Vector2d position) {
        if(isOccupied(position)){
            for (AnimalLab4 animal : animals) {
                if(animal.getAnimalPosition().equals(position)){
                    return animal;
                }
            }
        }
        return null;
    }
    public String toString(){
        return new MapVisualizer(this).draw(new Vector2d(0, 0), new Vector2d(mapWidth - 1, mapHeight - 1));
    }
}
