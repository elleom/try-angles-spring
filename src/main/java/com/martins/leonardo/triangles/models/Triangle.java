package com.martins.leonardo.triangles.models;

import java.awt.*;
import java.util.ArrayList;
import static java.lang.Math.sqrt;

/***
 * @author LM
 */
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

    /***
     * @param point1
     * @param point2
     * retrieves sideLength**2
     */
    protected static int lengthSquare(Point point1, Point point2)
    {
        int xDiff = point1.x- point2.x;
        int yDiff = point1.y- point2.y;
        return xDiff*xDiff + yDiff*yDiff;
    }

    /**
     * retrieves side length
     * */

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

    /***
     * @param x
     * @param y
     * @param z
     * retrieves type of triangle or !triangle
     * @return answer
     */

    public String getTriangleType(Double x, Double y,  Double z){ //sideAB, AC, BC

        /**
         * Triangular Inequality.
         * In a triangle the length of each side, is less than the sum of the lengths of the other two
         */
        String answer;

        //check for a not a triangle
        //check 1st , there's no need to do the other checks if it is not a triangle
        if (!isTriangle(x, y, z)){
            answer = "not a triangle and you can't draw";
            return answer;
        }

        // Check for equilateral triangle
        if (isEquilateral(x, y, z)){
            answer = "Equilateral";
            return answer;
        }

        // Check for isosceles triangle
        else if ( isIsosceles(x, y, z)) {
            answer = "Isosceles";
            return answer;
        }
        // Otherwise scalene triangle
        else {
            answer = "Scalene";
            return  answer;
        }
    }

    public boolean isTriangle(Double x, Double y, Double z) {
        if (((x + y) <= z) || ((x + z) <= y) || ((y + z) <= x)) {
            return false;
        }
        return true;
    }

    public boolean isEquilateral(Double x, Double y, Double z){
        /**
         * comparing by == leads to wrong result
         * as it doesnt compares the value but the object
         * alt = Double.compare(double1, double2)
         * */
        if (x.equals(z) && z.equals(y)){
            return true;
        }
        return false;
    }

    public boolean isIsosceles(Double x, Double y, Double z){
        if ( x.equals(z) || x.equals(y) || z.equals(y)) {
            return true;
        }
        return false;
    }
}
