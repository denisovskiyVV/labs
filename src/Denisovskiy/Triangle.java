package Denisovskiy;

public class Triangle implements Figure{
    private double a=0;
    private double b=0;
    private double c=0;
    private double h=0;

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Triangle(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }//конструктор



    @Override
    public double getSquare() {
        return 0.5*a*h;
    }//считает площадь треуголльника

    @Override
    public double getPerimetr() {
        return a+b+c;
    }//считает периметр треугольника
}
