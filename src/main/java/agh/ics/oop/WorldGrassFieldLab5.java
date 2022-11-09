package agh.ics.oop;

public class WorldGrassFieldLab5 {
    public static void main(String[] args){

        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngineGrass engine = new SimulationEngineGrass(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
        System.out.println(map.animals.get(0).getAnimalPosition());

    }
}
