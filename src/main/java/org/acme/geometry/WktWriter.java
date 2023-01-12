package org.acme.geometry;

public class WktWriter {

    public WktWriter(){

    }
    public String write(Geometry geometry){
        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            return point.getType().toUpperCase()+"("+point.getCoordinate().getX()+","+point.getCoordinate().getY()+")";
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString)geometry;
            String coordinates = "";
            for(int i=1;i<=lineString.getNumPoints();i++){
                Point p = lineString.getPointN(i);
                if (i < lineString.getNumPoints()){
                    coordinates = coordinates+p.getCoordinate().getX()+" "+p.getCoordinate().getY()+",";
                }else {
                    coordinates = coordinates+p.getCoordinate().getX()+" "+p.getCoordinate().getY();
                }
            }
            return lineString.getType().toUpperCase()+"("+coordinates+")";
        }else{
            throw new RuntimeException("geometry type not supported");
        }

    }
}
