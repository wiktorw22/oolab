package agh.ics.oop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Lab4AbstractTesty {

    @Test
    public void Lab4AbstractTest1() {
        String[] pom = {"f", "b", "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(pom);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        AnimalLab4 animal1 = map.animals.get(0);
        Vector2d res1 = animal1.getAnimalPosition();
        String res11 = animal1.toString(animal1.getAnimalOrientation());
        AnimalLab4 animal2 = map.animals.get(1);
        Vector2d res2 = animal2.getAnimalPosition();
        String res22 = animal2.toString(animal2.getAnimalOrientation());
        Assertions.assertEquals(res1, new Vector2d(2, 3));
        Assertions.assertEquals(res11, "E");
        Assertions.assertEquals(res2, new Vector2d(3, 3));
        Assertions.assertEquals(res22, "W");
    }
    @Test
    public void Lab4AbstractTest2() {
        String[] pom = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(pom);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        SimulationEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        AnimalLab4 animal1 = map.animals.get(0);
        Vector2d res1 = animal1.getAnimalPosition();
        String res11 = animal1.toString(animal1.getAnimalOrientation());
        AnimalLab4 animal2 = map.animals.get(1);
        Vector2d res2 = animal2.getAnimalPosition();
        String res22 = animal2.toString(animal2.getAnimalOrientation());
        Assertions.assertEquals(res1, new Vector2d(2, 0));
        Assertions.assertEquals(res11, "S");
        Assertions.assertEquals(res2, new Vector2d(3, 4));
        Assertions.assertEquals(res22, "N");
    }
}
