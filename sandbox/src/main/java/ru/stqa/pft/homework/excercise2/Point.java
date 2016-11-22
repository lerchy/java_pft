package ru.stqa.pft.homework.excercise2;

/**
 * Created by vgagarin on 22.11.2016.
 */
public class Point {
    double x;
    double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distance(Point otherPoint){
        return Math.sqrt(((otherPoint.x - this.x) * (otherPoint.x - this.x)) + ((otherPoint.y - this.y) * (otherPoint.y - this.y)));
    }
}
