package org.acme.geometry;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder implements GeometryVisitor{
    private List<Double> Xvals = new ArrayList<>();
    private List<Double> Yvals = new ArrayList<>();

    private PrintStream out;

    public EnvelopeBuilder(){

    }

    public EnvelopeBuilder(PrintStream out){
        this.out = out;
    }
    public void insert(Coordinate coordinate){
      this.Xvals.add(coordinate.getX());
      this.Yvals.add(coordinate.getY());
    }

    public Envelope build(){
        double XMin = Collections.min(this.Xvals);
        double XMax = Collections.max(this.Xvals);
        double YMin = Collections.min(this.Yvals);
        double YMax = Collections.max(this.Yvals);

        Coordinate topright = new Coordinate(XMax,YMax);
        Coordinate bottomleft = new Coordinate(XMin,YMin);
        return new Envelope(bottomleft,topright);

    }

    @Override
    public void visit(LineString line) {
        Envelope envelope = line.getEnvelope();
        String extentVisite = "Extent(XMin:"+envelope.getXMin()+" YMin:"+envelope.getYMin()+" XMax:"+envelope.getXMax()+" YMax:"+envelope.getYMax()+")";
        this.out.println(extentVisite);

    }

    @Override
    public void visit(Point point) {
        Envelope envelope = point.getEnvelope();
        String extentVisite = "Extent(XMin:"+envelope.getXMin()+" YMin:"+envelope.getYMin()+" XMax:"+envelope.getXMax()+" YMax:"+envelope.getYMax()+")";
        this.out.println(extentVisite);
    }
}
