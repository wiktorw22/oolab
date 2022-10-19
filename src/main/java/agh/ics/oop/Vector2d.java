package agh.ics.oop;

//public class Main {
//public static void main(String[] args) {
//System.out.println("Hello world!");
//}
//}

import java.util.Objects;

public class Vector2d {

    public static void main(String[] args) {

        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        //System.out.println(toUnitVector());

    }
    final public int x;
    final public int y;
    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    boolean precedes(Vector2d other){
        if(this.x <= other.x && this.y <= other.y){
            return true;
        }
        return false;
    }
    boolean follows(Vector2d other){
        if(this.x >= other.x && this.y >= other.y){
            return true;
        }
        return false;
    }
    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }
    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }
    public Vector2d upperRight(Vector2d other){
        int max_x;
        int max_y;
        if(this.x > other.x){
            max_x = this.x;
        }
        else{
            max_x = other.x;
        }
        if(this.y > other.y){
            max_y = this.y;
        }
        else{
            max_y = other.y;
        }
        return new Vector2d(max_x, max_y);
    }
    public Vector2d lowerLeft(Vector2d other){
        int min_x;
        int min_y;
        if(this.x < other.x){
            min_x = this.x;
        }
        else{
            min_x = other.x;
        }
        if(this.y < other.y){
            min_y = this.y;
        }
        else{
            min_y = other.y;
        }
        return new Vector2d(min_x, min_y);
    }
    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vector2d)) {
            return false;
        }
        Vector2d that = (Vector2d) other;
        // tutaj przeprowadzane jest faktyczne porównanie
        if (this.x == that.x && this.y == that.y) {
            return true;
        }
        else{
            return false;
        }


    }
    public int hashCode() { return Objects.hash(x, y); }

}