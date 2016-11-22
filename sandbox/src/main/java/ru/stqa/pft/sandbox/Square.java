package ru.stqa.pft.sandbox;

/**
 * Created by vgagarin on 22.11.2016.
 */
public class Square {

    public double l;

    public Square(double l){
        this.l = l;
    }

    public double area(){
        return this.l * this.l;
    }
}
