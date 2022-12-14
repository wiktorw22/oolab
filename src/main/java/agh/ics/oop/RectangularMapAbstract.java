package agh.ics.oop;

abstract class RectangularMapAbstract extends AbstractWorldMapLab6 {

    public RectangularMapAbstract(int mapWidth, int mapHeight) {
        super(mapWidth, mapHeight);
    }
    public Vector2d getMaxPositionOnMap(){
        return new Vector2d(this.getMapWidth() - 1, this.getMapHeight() - 1);
    }
}



