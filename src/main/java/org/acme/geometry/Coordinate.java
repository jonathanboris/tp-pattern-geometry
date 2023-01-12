package org.acme.geometry;

public class Coordinate {
    private double x;
    private double y;
    public Coordinate(){
        x = Double.NaN;
        y = Double.NaN;
    }
    public Coordinate(double _x,double _y){
        x = _x;
        y = _y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isEmpty(){
        return Double.isNaN(x) && Double.isNaN(y);
    }

}
