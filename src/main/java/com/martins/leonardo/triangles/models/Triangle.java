package com.martins.leonardo.triangles.models;

import java.awt.*;
import java.util.ArrayList;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Triangle {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    public Triangle(Point sideA, Point sideB, Point sideC) {
        this.pointA = sideA;
        this.pointB = sideB;
        this.pointC = sideC;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    protected static int lengthSquare(Point point1, Point point2)
    {
        int xDiff = point1.x- point2.x;
        int yDiff = point1.y- point2.y;
        return xDiff*xDiff + yDiff*yDiff;
    }

    public ArrayList<Double> getSidesLength() {
        ArrayList<Double> lengthArray = new ArrayList();
        // Square of lengths be a2, b2, c2
        int a2 = lengthSquare(this.pointB, this.pointC);
        int b2 = lengthSquare(this.pointA, this.pointC);
        int c2 = lengthSquare(this.pointA, this.pointB);

        // length of sides be a, b, c
        Double a = sqrt(a2);
        Double b = sqrt(b2);
        Double c = sqrt(c2);

        lengthArray.add(a);
        lengthArray.add(b);
        lengthArray.add(c);

        return lengthArray;
    }

    public String getTriangleType(Double x, Double y,  Double z){ //sideAB, AC, BC

        //check for a not a triangle
        if ((x + y) < z || (x + z) < y || (y + z) < x) {
            return "not a triangle X";
        }

        /**
         * comparing by == leads to wrong result
         * as it doesnt compares the value but the object
         * alt = Double.compare(double1, double2)
         */

        // Check for equilateral triangle
        if (x.equals(z) && z.equals(y)
                || (abs(x - z) <= 0.5 && abs(y - z) <= 0.5) )
            return "Equilateral";

        // Check for isoceles triangle
        else if ( x.equals(z)
                || x.equals(y)
                || z.equals(y))
            return "Isosceles";

            // Otherwise scalene triangle
        else
            return "Scalene";

    }
}
