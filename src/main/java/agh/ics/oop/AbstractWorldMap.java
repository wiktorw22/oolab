package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMapAbstract {
    protected List<AnimalLab5Abstract> animals;
    private final int mapWidth;
    private final int mapHeight;
    public AbstractWorldMap(int mapWidth, int mapHeight){
        animals = new ArrayList<>();
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }
    public List<AnimalLab5Abstract> getAnimalsArray(){
        return animals; //getter
    }
    public int getMapWidth(){
        return mapWidth; //getter
    }
    public int getMapHeight(){
        return mapHeight; //getter
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x >= 0 && position.x < mapWidth && position.y >= 0 && position.y < mapHeight){
            return !this.isOccupied(position);
        }
        return false;
    }

    @Override
    public boolean place(AnimalLab5Abstract animal) {
        if(canMoveTo(animal.getAnimalPosition())){
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (AnimalLab5Abstract animal : animals) {
            if(animal.getAnimalPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public AnimalLab5Abstract objectAt(Vector2d position) {
        if(isOccupied(position)){
            for (AnimalLab5Abstract animal : animals) {
                if(animal.getAnimalPosition().equals(position)){
                    return animal;
                }
            }
        }
        return null;
    }
    public String toString(){
        return new MapVisualizerAbstract(this).draw(new Vector2d(0, 0), getMaxPositionOnMap());
    }
    abstract Vector2d getMaxPositionOnMap();

    abstract int getGrassNumber();
    abstract boolean isOccupiedGrass(Vector2d position);
    abstract boolean canMoveToGrass(Vector2d position);
    abstract boolean placeGrass(Grass grass);
    abstract Grass objectAtGrass(Vector2d position);
    abstract Vector2d getMinPositionOnMap();
    //abstract Vector2d getMaxPositionOnMap();
    //public String toString(){return new MapVisualizerGrass(this).draw(new Vector2d(0, 0), getMaxPositionOnMap());


}




