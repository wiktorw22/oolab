package agh.ics.oop;

import java.util.HashMap;
//import java.util.List;
import java.util.Map;

abstract class AbstractWorldMapLab6 implements IWorldMapAbstract, IPositionChangeObserver {
    protected Map<Vector2d, AnimalLab6Abstract> animals;
    private final int mapWidth;
    private final int mapHeight;
    public AbstractWorldMapLab6(int mapWidth, int mapHeight){
        animals = new HashMap<>();
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
    }
    public Map<Vector2d, AnimalLab6Abstract> getAnimalsHashMap(){
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
    public boolean place(AnimalLab6Abstract animal) {
        if(canMoveTo(animal.getAnimalPosition())){
            animals.put(animal.getAnimalPosition(), animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        return animals.containsKey(position);
    }

    @Override
    public AnimalLab6Abstract objectAt(Vector2d position) {
        if(isOccupied(position)){

            return (animals.get(position));


        }
        return null;
    }
    public String toString(){
        return new MapVisualizerAbstractLab6(this).draw(new Vector2d(0, 0), getMaxPositionOnMap());
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
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        AnimalLab6Abstract animal1 = animals.get(oldPosition);
        //AbstractWorldMapLab6 mapAnimal = animal1.getAnimalMap();
        animals.remove(oldPosition, animal1);
        //AnimalLab6Abstract animal2 = new AnimalLab6Abstract(mapAnimal, newPosition);
        animal1.setAnimalPosition(newPosition);
        animals.put(newPosition, animal1);
    }

}




