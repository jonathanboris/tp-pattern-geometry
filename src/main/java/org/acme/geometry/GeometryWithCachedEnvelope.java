package org.acme.geometry;

public class GeometryWithCachedEnvelope implements Geometry,GeometryListener{

    private Geometry original;
    private Envelope cachedEnvelop;


    public GeometryWithCachedEnvelope(Geometry original){
        this.original = original;
        this.cachedEnvelop = this.original.getEnvelope();
    }

    @Override
    public void onChange(Geometry geometry) {
        this.original = geometry;
        this.cachedEnvelop = geometry.getEnvelope();
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
       this.onChange(this);
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
