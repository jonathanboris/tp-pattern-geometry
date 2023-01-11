package org.acme.geometry;

public class Coordinate {
    private double x;
    private double y;
    public Coordinate(){
        x = 0.0;
        y = 0.0;
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
}
