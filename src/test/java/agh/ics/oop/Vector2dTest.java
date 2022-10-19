
package agh.ics.oop;

import org.junit.jupiter.api.Assertions;

public class Vector2dTest {

    @Test
    static void equalsTestTrue(){
        Assertions.assertTrue(new Vector2d(5, 7).equals(new Vector2d(5, 7)));
    }
    @Test
    static void equalsTestFalse(){
        Assertions.assertFalse(new Vector2d(5, 7).equals(new Vector2d(7, 8)));
    }
    @Test
    static void toStringTestTrue(){
        Assertions.assertTrue(new Vector2d(3, 9).toString().equals("(3, 9)"));
    }
    @Test
    static void toStringTestFalse(){
        Assertions.assertFalse(new Vector2d(3, 9).toString().equals("[3, 9]"));
    }
    @Test
    static void precedesTestTrue(){
        Assertions.assertTrue(new Vector2d(1, 2).precedes(new Vector2d(8, 9)));
    }
    @Test
    static void precedesTestFalse(){
        Assertions.assertFalse(new Vector2d(11, 12).precedes(new Vector2d(8, 9)));
    }
    @Test
    static void followsTestTrue(){
        Assertions.assertTrue(new Vector2d(11, 12).follows(new Vector2d(8, 9)));
    }
    @Test
    static void followsTestFalse(){
        Assertions.assertFalse(new Vector2d(1, 2).follows(new Vector2d(8, 9)));
    }
    @Test
    static void upperRightTest(){
        Assertions.assertEquals(new Vector2d(5, 7), new Vector2d(5, 4).upperRight(new Vector2d(2, 7)));
    }
    @Test
    static void lowerLeftTest(){
        Assertions.assertEquals(new Vector2d(2, 6), new Vector2d(2, 8).lowerLeft(new Vector2d(7, 6)));
    }
    @Test
    static void addTest(){
        Assertions.assertEquals(new Vector2d(10,11), new Vector2d(5, 4).add(new Vector2d(5, 7)));
    }
    @Test
    static void subtractTest(){
        Assertions.assertEquals(new Vector2d(2, 3).subtract(new Vector2d(4, 5)), new Vector2d(-2, -2));
    }
    @Test
    static void oppositeTest(){
        Assertions.assertEquals(new Vector2d(-3, -9), new Vector2d(3, 9).opposite());
    }
    public static void main(String[] args) {

        int t1 = Integer.parseInt(args[0]);
        int t2 = Integer.parseInt(args[1]);
        int t3 = Integer.parseInt(args[2]);
        int t4 = Integer.parseInt(args[3]);
        Vector2d tmp1 = new Vector2d(t1, t2);
        Vector2d tmp2 = new Vector2d(t3, t4);

        precedesTestTrue();
        precedesTestFalse();
        followsTestTrue();
        followsTestFalse();
        upperRightTest();
        lowerLeftTest();
        addTest();
        subtractTest();
        oppositeTest();
        equalsTestTrue();
        equalsTestFalse();
        toStringTestTrue();
        toStringTestFalse();
    }
}
