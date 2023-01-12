package org.acme.geometry;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class WktVisitor implements GeometryVisitor{
     private StringBuilder buffer = new StringBuilder();

     public WktVisitor(){

     }
    @Override
    public void visit(LineString line) {
        this.buffer.append("LINESTRING(");
        if(!line.isEmpty()){
            for(int i=1;i<=line.getNumPoints();i++){
                Point p = line.getPointN(i);
                if (i < line.getNumPoints()){
                    this.buffer.append(p.getCoordinate().getX()+" "+p.getCoordinate().getY()+",");
                }else {
                    this.buffer.append(p.getCoordinate().getX()+" "+p.getCoordinate().getY()+")");
                }
            }

        }else{
          this.buffer.append(")");
        }
    }

    @Override
    public void visit(Point point) {
        this.buffer.append("POINT");
        if(!point.isEmpty()){
            this.buffer.append("("+point.getCoordinate().getX()+" "+point.getCoordinate().getY()+")");
        }else {
            this.buffer.append("()");
        }

    }

    public String getResult() {
        return this.buffer.toString();
    }
}
