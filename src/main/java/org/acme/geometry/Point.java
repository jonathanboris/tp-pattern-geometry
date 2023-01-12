package org.acme.geometry;

public class Point implements Geometry{
    private Coordinate coordinate;
    public Point(){
        this.coordinate = new Coordinate();
    }
    public Point(Coordinate coordinate){
        this.coordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public String getType() {
     return "Point";
    }

    public boolean isEmpty(){
        return coordinate.isEmpty();
    }

    public void translate(double x,double y){
        double actuelX = this.coordinate.getX();
        double actuelY = this.coordinate.getY();

        Coordinate newCoordiante = new Coordinate(actuelX+x,actuelY+y);

        this.coordinate = newCoordiante;
    }

    public Point clone(){
        Point pointClone = new Point(this.coordinate);
        return  pointClone;
    }
}
