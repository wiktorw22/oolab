package agh.ics.oop;

public class WorldLab4Abstract {
    public static void main(String[] args){

        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
        System.out.println(map.animals.get(0).getAnimalPosition());

    }
}

