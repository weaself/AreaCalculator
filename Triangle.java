package AreaCalculator;

import java.io.Serializable;

public class Triangle implements ForceAreaCalucation, Serializable {
    private double sideA;
    private double sideB;
    private double sideC;
    private double area;

    public Triangle() {}

    public Triangle(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw new IllegalArgumentException();
        }
        else {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }
    }

    private boolean isTriangleGenuine(double sideA, double sideB, double sideC)  {
        if (((sideA + sideB) > sideC) && ((sideB + sideC) > sideA) && ((sideA + sideC) > sideB)) return true;
        else { return false; }
    }

    public void calculateTriangleArea() throws Exception {
        double s;
        double area;
        if(isTriangleGenuine(sideA, sideB, sideC)) {
        // using Heron's formula here.
        s = (sideA + sideB + sideC) / 2;
        area = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        // rounding the result a little
        this.area = area;
    } else {
        throw new Exception();
    }
    }

    @Override
    public double getArea() {
        return area;
    }
}
