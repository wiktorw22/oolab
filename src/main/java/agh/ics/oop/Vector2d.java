package agh.ics.oop;

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
        return this.x <= other.x && this.y <= other.y;
    }
    boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
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
        max_x = Math.max(this.x, other.x);
        max_y = Math.max(this.y, other.y);
        return new Vector2d(max_x, max_y);
    }
    public Vector2d lowerLeft(Vector2d other){
        int min_x;
        int min_y;
        min_x = Math.min(this.x, other.x);
        min_y = Math.min(this.y, other.y);
        return new Vector2d(min_x, min_y);
    }
    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        else if (!(other instanceof Vector2d)) return false;
        else return this.x == ((Vector2d) other).x && this.y == ((Vector2d) other).y;
    }
    @Override
    public int hashCode() { return Objects.hash(x, y); }

}