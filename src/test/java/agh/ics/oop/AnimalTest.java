package agh.ics.oop;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AnimalTest {
    @Test
    public void AnimalTest1() {
        String[] pom = {"f", "b", "k", "p"};
        Animal animal_pom = new Animal();
        OptionsParser optionsParser = new OptionsParser();
        MoveDirection tab[] = optionsParser.parse(pom);
        int m = tab.length;
        for (int i = 0; i < m; i++) {
            MoveDirection temp = tab[i];
            //MoveDirection newMove = MoveDirection.valueOf(temp);
            animal_pom.move(temp);
        }
        Vector2d position = animal_pom.getAnimalPosition();
        MapDirection orientation = animal_pom.getAnimalOrientation();
        String tmp = animal_pom.toString(position, orientation);
        Assertions.assertEquals(tmp, "Pozycja zwierzaka: " + "(2, 2)" + ", jego orientacja: " + "NORTH");

    }
    @Test
    public void AnimalTest2() {
        String[] pom = {"f", "l", "k", "b", "r", "z"};
        Animal animal_pom = new Animal();
        OptionsParser optionsParser = new OptionsParser();
        MoveDirection tab[] = optionsParser.parse(pom);
        int m = tab.length;
        for (int i = 0; i < m; i++) {
            MoveDirection temp = tab[i];
            //MoveDirection newMove = MoveDirection.valueOf(temp);
            animal_pom.move(temp);
        }
        Vector2d position = animal_pom.getAnimalPosition();
        MapDirection orientation = animal_pom.getAnimalOrientation();
        String tmp = animal_pom.toString(position, orientation);
        Assertions.assertEquals(tmp, "Pozycja zwierzaka: " + "(3, 3)" + ", jego orientacja: " + "NORTH");
    }
    @Test
    public void AnimalTest3() {
        String[] pom = {"f", "f", "f", "s", "w", "f"};
        Animal animal_pom = new Animal();
        OptionsParser optionsParser = new OptionsParser();
        MoveDirection tab[] = optionsParser.parse(pom);
        int m = tab.length;
        for (int i = 0; i < m; i++) {
            MoveDirection temp = tab[i];
            //MoveDirection newMove = MoveDirection.valueOf(temp);
            animal_pom.move(temp);
        }
        Vector2d position = animal_pom.getAnimalPosition();
        MapDirection orientation = animal_pom.getAnimalOrientation();
        String tmp = animal_pom.toString(position, orientation);
        Assertions.assertEquals(tmp, "Pozycja zwierzaka: " + "(2, 4)" + ", jego orientacja: " + "NORTH");
    }

}
