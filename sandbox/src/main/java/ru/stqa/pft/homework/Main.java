package ru.stqa.pft.homework;

/**
 * Created by vgagarin on 22.11.2016.
 */
public class Main {

    public static double distance(Point p1, Point p2){
        return Math.sqrt(((p2.x - p1.x) * (p2.x - p1.x)) + ((p2.y - p1.y) * (p2.y - p1.y)));
    }

    public static void main(String[] args){
        Point p1 = new Point(2.0, 1.0);
        Point p2 = new Point(6.0, 4.0);

        System.out.println( "Distance calculated with the function in Main class: " + distance(p1, p2) );
        System.out.println( "Distance calculated with the method in Point class: " + p1.distance(p2) );
    }
}
