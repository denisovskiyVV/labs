package Denisovskiy;

public class Rectangle implements Figure{
    private double a =0;
    private double b =0;

    /**
     *
     * @param a длина
     * @param b ширина
     */
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Rectangle() {
        super();
    }

    /**
     *
     * @return считает площадь прямоуголльника
     */
    @Override
    public double getSquare() {
        return a*b;
    }

    /**
     *
     * @return считает периметр прямоугольника
     */
    @Override
    public double getPerimetr() {
        return 2*(a+b);
    }
}