package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry{

    private Geometry original;
    private Envelope cachedEnvelop;


    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        cachedEnvelop = this.original.getEnvelope();
    }


    @Override
    public Envelope getEnvelope() {
        return this.cachedEnvelop;
    }

    @Override
    public Geometry clone() {
        return this.clone();
    }

    @Override
    public void translate(double x, double y) {
       this.translate(x,y);
    }

    @Override
    public void accept(GeometryVisitor visitor) {
     this.accept(visitor);
    }

    @Override
    public boolean isEmpty() {
        return this.isEmpty();
    }

    @Override
    public String getType() {
        return this.getType();
    }
}
