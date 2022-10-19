package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {

    @Test
    void equalsTestTrue(){
        Assertions.assertEquals(new Vector2d(5, 7), new Vector2d(5, 7));
    }
    @Test
    void equalsTestFalse(){
        Assertions.assertNotEquals(new Vector2d(5, 7), new Vector2d(7, 8));
    }
    @Test
    void toStringTestTrue(){
        Assertions.assertEquals("(3, 9)", new Vector2d(3, 9).toString());
    }
    @Test
    void toStringTestFalse(){
        Assertions.assertNotEquals("[3, 9]", new Vector2d(3, 9).toString());
    }
    @Test
    void precedesTestTrue(){
        Assertions.assertTrue(new Vector2d(1, 2).precedes(new Vector2d(8, 9)));
    }
    @Test
    void precedesTestFalse(){
        Assertions.assertFalse(new Vector2d(11, 12).precedes(new Vector2d(8, 9)));
    }
    @Test
    void followsTestTrue(){
        Assertions.assertTrue(new Vector2d(11, 12).follows(new Vector2d(8, 9)));
    }
    @Test
    void followsTestFalse(){
        Assertions.assertFalse(new Vector2d(1, 2).follows(new Vector2d(8, 9)));
    }
    @Test
    void upperRightTest(){
        Assertions.assertEquals(new Vector2d(5, 7), new Vector2d(5, 4).upperRight(new Vector2d(2, 7)));
    }
    @Test
    void lowerLeftTest(){
        Assertions.assertEquals(new Vector2d(2, 6), new Vector2d(2, 8).lowerLeft(new Vector2d(7, 6)));
    }
    @Test
    void addTest(){
        Assertions.assertEquals(new Vector2d(10,11), new Vector2d(5, 4).add(new Vector2d(5, 7)));
    }
    @Test
    void subtractTest(){
        Assertions.assertEquals(new Vector2d(2, 3).subtract(new Vector2d(4, 5)), new Vector2d(-2, -2));
    }
    @Test
    void oppositeTest(){
        Assertions.assertEquals(new Vector2d(-3, -9), new Vector2d(3, 9).opposite());
    }

}
