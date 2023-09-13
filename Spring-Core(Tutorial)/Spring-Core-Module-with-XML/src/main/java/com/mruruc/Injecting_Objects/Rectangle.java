package com.mruruc.Injecting_Objects;

public class Rectangle {
    private Point A;
    private Point B;
    private Point C;
    private Point D;

    public Rectangle() {
    }

    public Rectangle(Point a, Point b, Point c, Point d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point a) {
        A = a;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point b) {
        B = b;
    }

    public Point getC() {
        return C;
    }

    public void setC(Point c) {
        C = c;
    }

    public Point getD() {
        return D;
    }

    public void setD(Point d) {
        D = d;
    }

    @Override
    public String toString() {
        return
                "A, ="  + A +  "\n"+
                ", B=" + B + "\n"+
                ", C=" + C + "\n"+
                ", D=" + D + "\n" + "" ;

    }
}
