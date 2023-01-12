package org.acme.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineString implements Geometry{
    private List<Point> points;
    public LineString(){
        Point p1 = new Point();
        Point p2 = new Point();
        points = Arrays.asList(p1,p2);
    }
    public LineString(List<Point> _points){
        points = _points;
    }
    public int getNumPoints(){
        return points.size();
    }
    public Point getPointN(int n){
        return points.get(n-1);
    }
    @Override
    public String getType() {
        return "Line";
    }

    public boolean isEmpty(){
        return points.isEmpty();
    }
    public void translate(double x,double y){
      for(Point p: points){
         p.translate(x,y);
      }
    }
    public LineString clone(){
        List<Point> pointsClone = new ArrayList<>();
        for(Point p: points){
            pointsClone.add(p.clone());
        }
        return new LineString(pointsClone);
    }
}
