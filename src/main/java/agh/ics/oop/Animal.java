package agh.ics.oop;

public class Animal {
    public final MapDirection orientation_start = MapDirection.NORTH;
    public final Vector2d position_start = new Vector2d(2, 2);
    private MapDirection orientation;
    private Vector2d position;
    public Animal(){
        this.position = position_start;
        this.orientation = orientation_start;
    }
    public Vector2d getAnimalPosition(){
        return position;
    }
    public MapDirection getAnimalOrientation(){
        return orientation;
    }
    public String toString(Vector2d position, MapDirection orientation){
        return "Pozycja zwierzaka: " + position + ", jego orientacja: " + orientation;
    }
    public boolean isAt(Vector2d position){
        return (this.position.equals(position));
    }
    public void move(MoveDirection direction){
        if(direction.equals(MoveDirection.RIGHT)) {
            orientation = orientation.next(orientation);
        }
        else if (direction.equals(MoveDirection.LEFT)){
            orientation = orientation.previous(orientation);
        }
        else if (direction.equals(MoveDirection.FORWARD)){

            if (orientation.equals(MapDirection.NORTH)){
                if (position.y + 1 < 5) {
                    position = new Vector2d(position.x, position.y + 1);
                }
            }
            else if (orientation.equals(MapDirection.EAST)){
                if (position.x + 1 < 5) {
                    position = new Vector2d(position.x + 1, position.y);
                }
            }
            else if (orientation.equals(MapDirection.SOUTH)){
                if (position.y - 1 >= 0) {
                    position = new Vector2d(position.x, position.y - 1);
                }
            }
            else{
                if (position.x - 1 >= 0) {
                    position = new Vector2d(position.x - 1, position.y);
                }
            }
        }
        else if (direction == MoveDirection.BACKWARD){

            if (orientation.equals(MapDirection.NORTH)){
                if (position.y - 1 >= 0) {
                    position = new Vector2d(position.x, position.y - 1);
                }
            }
            else if (orientation.equals(MapDirection.EAST)){
                if (position.x - 1 >= 0) {
                    position = new Vector2d(position.x - 1, position.y);
                }
            }
            else if (orientation.equals(MapDirection.SOUTH)){
                if (position.y + 1 < 5) {
                    position = new Vector2d(position.x, position.y + 1);
                }
            }
            else{
                if (position.x + 1 < 5) {
                    position = new Vector2d(position.x + 1, position.y);
                }
            }
        }

    }


}
