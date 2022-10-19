//package org.example;
package agh.ics.oop;

//public class Main {
    //public static void main(String[] args) {
        //System.out.println("Hello world!");
    //}
//}

public class World1{
    public static void run(String[] args){
        //System.out.println("Zwierzak idzie do przodu");
        int n = args.length;
        //System.out.println(n);
        /*
        for(int i=0; i<n; i++){
            System.out.print(args[i]);
            if (i<n - 1){
                System.out.print(",");
            }
        }
        System.out.println();
        */
        for(int i=0; i<n; i++){
            String tmp = args[i];
            String message = switch (tmp) {
                case "f" -> "Zwierzak idzie do przodu";
                case "b" -> "Zwierzak idzie do tyłu";
                case "r" -> "Zwierzak skręca w prawo";
                case "l" -> "Zwierzak skręca w lewo";
                default -> "Nieznana komenda";
            };

            System.out.print(message);
            if (i<n - 1){
                System.out.print(", \n");
            }
            }
        }

    public static void main(String[] args){
        System.out.println("System wystartował - START");
        World1.run(args);
        System.out.println();
        System.out.println("System zakończył działanie - STOP");
    }
}