package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MapDirectionTest {

    @Test
    void nextTestN(){
        Assertions.assertEquals(MapDirection.EAST, MapDirection.next(MapDirection.NORTH));
    }
    @Test
    void nextTestE(){
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.next(MapDirection.EAST));
    }
    @Test
    void nextTestS(){
        Assertions.assertEquals(MapDirection.WEST, MapDirection.next(MapDirection.SOUTH));
    }
    @Test
    void nextTestW(){
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.next(MapDirection.WEST));
    }
    @Test
    void previousTestN(){
        Assertions.assertEquals(MapDirection.WEST, MapDirection.previous(MapDirection.NORTH));
    }
    @Test
    void previousTestE(){
        Assertions.assertEquals(MapDirection.NORTH, MapDirection.previous(MapDirection.EAST));
    }
    @Test
    void previousTestS(){
        Assertions.assertEquals(MapDirection.EAST, MapDirection.previous(MapDirection.SOUTH));
    }
    @Test
    void previousTestW(){
        Assertions.assertEquals(MapDirection.SOUTH, MapDirection.previous(MapDirection.WEST));
    }

}

