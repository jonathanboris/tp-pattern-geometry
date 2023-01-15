package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{

    public AbstractGeometry(){

    }

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
       return visitor.getResult();
    }

    @Override
    public Envelope getEnvelope() {
        return this.getEnvelope();
    }

    public Geometry clone(){
        return null;
    }

}
