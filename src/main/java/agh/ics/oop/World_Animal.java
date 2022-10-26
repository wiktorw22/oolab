package agh.ics.oop;

public class World_Animal {
    public static void main(String[] args){
        OptionsParser newParser = new OptionsParser();
        MoveDirection[] moves = newParser.parse(args);
        int m = moves.length;
        Animal animal = new Animal();
        for(int i = 0; i < m; i++){
            MoveDirection temp = moves[i];
            //MoveDirection newMove = MoveDirection.valueOf(temp);
            animal.move(temp);
        }
        Vector2d position = animal.getAnimalPosition();
        MapDirection orientation = animal.getAnimalOrientation();
        String tmp = animal.toString(position, orientation);
        System.out.println(tmp);
    }
}
