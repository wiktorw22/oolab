package agh.ics.oop;

public class WorldLab6 {
    public static void main(String[] args){

        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassFieldAbstractLab6 map = new GrassFieldAbstractLab6((int) Double.POSITIVE_INFINITY, (int) Double.POSITIVE_INFINITY, 10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngineGrass engine = new SimulationEngineGrass(directions, map, positions);
        engine.run();
        System.out.println(map.toString());
        //System.out.println(map.animals.get(0).getAnimalPosition());
        System.out.println(map.animals.get(new Vector2d(2, 0)).getAnimalPosition());
    }
}

