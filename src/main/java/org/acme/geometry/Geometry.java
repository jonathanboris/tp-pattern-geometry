package org.acme.geometry;

public interface Geometry {
    public String getType();
    public boolean isEmpty();
    public void translate(double x,double y);
    public Geometry clone();
    public Envelope getEnvelope();

}
