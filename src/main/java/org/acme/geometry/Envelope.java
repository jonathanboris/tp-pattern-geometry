package org.acme.geometry;

public class Envelope {
    private Coordinate bottomleft;
    private Coordinate topright;
    public Envelope(){
        this.bottomleft = new Coordinate();
        this.topright = new Coordinate();
    }
    public Envelope(Coordinate bottomleft,Coordinate topright){
        this.bottomleft = bottomleft;
        this.topright = topright;
    }

    public Boolean isEmpty(){
        return this.topright.isEmpty() && this.bottomleft.isEmpty();
    }
    public double getXMin(){
        return this.bottomleft.getX();
    }
    public double getYMin(){
        return this.bottomleft.getY();
    }
    public double getXMax(){
        return this.topright.getX();
    }
    public double getYMax(){
        return this.topright.getY();
    }
}
