package AreaCalculator;

public class Rectangle implements ForceAreaCalucation {

    private double sideA;
    private double sideB;
    private double area;

    public Rectangle() {}

    public Rectangle(double sideA, double sideB) {

        if(sideA <= 0 || sideB <= 0) {
            throw new IllegalArgumentException("Either of arguments is illegal.");
        }
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public void calculateRectangleArea() {
        this.area = sideA * sideB;
    }

    @Override
    public double getArea() {
        return area;
    }
}
