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

    public String getTriangleType(Double sideAB, Double sideAC,  Double sideBC){

        //check for a line and not a form
        if (sideAB < 1 || sideAC < 1 || sideBC < 1) {
            return "Not a triangle";
        }

        /**
         * comparing by == leads to wrong result
         * as it doesnt compares the value but the object
         * alt = Double.compare(double1, double2)
         */

        // Check for equilateral triangle
        if (sideAB.equals(sideBC) && sideBC.equals(sideAC)
                || (abs(sideAB - sideBC) <= 0.5 && abs(sideAC - sideBC) <= 0.5) )
            return "Equilateral";

        // Check for isoceles triangle
        else if ( sideAB.equals(sideBC)
                || sideAB.equals(sideAC)
                || sideBC.equals(sideAC))
            return "Isosceles";

            // Otherwise scalene triangle
        else
            return "Scalene";

    }
}
