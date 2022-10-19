//package org.example;
package agh.ics.oop;

//public class Main {
//public static void main(String[] args) {
//System.out.println("Hello world!");
//}
//}

public class World2{

    public static void main(String[] args){
        System.out.println("System wystartował - START");

        int m = args.length;

        int cnt = 0;
        for(int i=0; i<m; i++){

            if(args[i].equals("f")){
                cnt++;
            }
            if(args[i].equals("b")){
                cnt++;
            }
            if(args[i].equals("r")){
                cnt++;
            }
            if(args[i].equals("l")){
                cnt++;
            }
        }

        Direction[] pom = new Direction[cnt];
        int j = 0;
        for (String arg : args) {

            switch (arg) {
                case "f":
                    pom[j] = Direction.valueOf("FORWARD");
                    j++;
                    break;
                case "b":
                    pom[j] = Direction.valueOf("BACKWARD");
                    j++;
                    break;
                case "r":
                    pom[j] = Direction.valueOf("RIGHT");
                    j++;
                    break;
                case "l":
                    pom[j] = Direction.valueOf("LEFT");
                    j++;
                    break;
            }


        }
        World2.run(pom);

        System.out.println();
        System.out.println("System zakończył działanie - STOP");
    }
    public static void run(Direction[] arguments) {

        int n = arguments.length;

        for (int i = 0; i < n; i++) {
            Direction tmp = arguments[i];
            String message = switch (tmp) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
                default -> "Nieznana komenda";
            };

            System.out.print(message);
            if (i < n - 1) {
                System.out.print(", \n");
            }
        }
    }
}