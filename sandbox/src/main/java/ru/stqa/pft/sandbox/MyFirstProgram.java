package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args){

        System.out.println("Hello World!");

        Square s = new Square(5);

        Rectangle r = new Rectangle(4, 6);

        System.out.println("Area of the square with a side length " + s.l + " is " + s.area());
        System.out.println("Area of the square with a side lengths " + r.a + " and " + r.b + " is " + r.area());

	}

}