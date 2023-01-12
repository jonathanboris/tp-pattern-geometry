package org.acme.geometry;

public class WktWriter {

    public WktWriter(){

    }
    public String write(Geometry geometry){
        if ( geometry instanceof Point ){
            Point point = (Point)geometry;
            WktVisitor wktvisitor = new WktVisitor();
            wktvisitor.visit(point);
            return wktvisitor.getResult();
        }else if ( geometry instanceof LineString ){
            LineString lineString = (LineString)geometry;
            WktVisitor wktvisitor = new WktVisitor();
            wktvisitor.visit(lineString);
            return wktvisitor.getResult();

        }else{
            throw new RuntimeException("geometry type not supported");
        }

    }
}
