package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry{

    public AbstractGeometry(){

    }

    public String asText(){
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
       return visitor.getResult();
    }
    public Geometry clone(){
        return null;
    }

}
