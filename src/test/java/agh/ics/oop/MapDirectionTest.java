package agh.ics.oop;
//import static org.junit.Assert.*;

//import agh.ics.oop.MapDirection;
//import agh.ics.oop.Test;
import org.junit.jupiter.api.Assertions;

public class MapDirectionTest {
    //private static MapDirection tmp;
    //public void MapDirection(MapDirection tmp){
    //    this.tmp = tmp;
    //}
    @Test
    static void nextTestN(MapDirection tmp){
        Assertions.assertEquals(MapDirection.EAST, MapDirection.next(tmp));
    }
    @Test
    static void nextTestE(MapDirection tmp){
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.next(tmp));
    }
    @Test
    static void nextTestS(MapDirection tmp){
        Assertions.assertEquals(MapDirection.WEST, MapDirection.next(tmp));
    }
    @Test
    static void nextTestW(MapDirection tmp){
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.next(tmp));
    }
    @Test
    static void previousTestN(MapDirection tmp){
        Assertions.assertEquals(MapDirection.WEST, MapDirection.previous(tmp));
    }
    @Test
    static void previousTestE(MapDirection tmp){
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.previous(tmp));
    }
    @Test
    static void previousTestS(MapDirection tmp){
        Assertions.assertEquals(MapDirection.EAST, MapDirection.previous(tmp));
    }
    @Test
    static void previousTestW(MapDirection tmp){
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.previous(tmp));
    }
    public static void main(String[] args){
        String tmp = args[0];
        //String tmp2 = args[1];
        if(tmp.equals("NORTH")){
            nextTestN(MapDirection.NORTH);
            previousTestN(MapDirection.NORTH);
        }
        else if(tmp.equals("EAST")){
            nextTestE(MapDirection.EAST);
            previousTestE(MapDirection.EAST);
        }
        else if(tmp.equals("SOUTH")){
            nextTestS(MapDirection.SOUTH);
            previousTestS(MapDirection.SOUTH);
        }
        else if(tmp.equals("WEST")){
            nextTestW(MapDirection.WEST);
            previousTestW(MapDirection.WEST);
        }

    }
}

