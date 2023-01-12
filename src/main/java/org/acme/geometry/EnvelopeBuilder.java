package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EnvelopeBuilder {
    private List<Double> Xvals = new ArrayList<>();
    private List<Double> Yvals = new ArrayList<>();

    public EnvelopeBuilder(){

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
}
