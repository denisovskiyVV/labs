package Denisovskiy;

public class Circle implements Figure {
    private double radius=0;

    public Circle(double radius) {
        this.radius = radius;
    }//конструктор

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return Math.PI*Math.pow(radius, 2);
    }//считает площадь круга


    @Override
    public double getPerimetr() {
        return 2*Math.PI*radius;
    }//считает периметр
}
