package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.util.Arrays;

public class LineStringTest {
    public static final double EPSILON = 1.0e-15;
    @Test
    public void testDefaultConstructor(){
        LineString line = new LineString();
        int Numpoint = line.getNumPoints();
        Point lastPoint = line.getPointN(Numpoint-1);
        Assert.assertNotEquals(null, lastPoint.getCoordinate().getX(), EPSILON);
        Assert.assertNotEquals(null, lastPoint.getCoordinate().getY(), EPSILON);
    }
    @Test
    public void testConstructor(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        LineString line = new LineString(Arrays.asList(p1,p2));
        Assert.assertSame(line.getPointN(1),p1);
        Assert.assertSame(line.getPointN(2),p2);

    }
    @Test
    public void getNumPointTest(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        LineString line = new LineString(Arrays.asList(p1,p2));
        int Nbrpoint = line.getNumPoints();
        Assert.assertEquals(2, Nbrpoint, EPSILON);
    }

    @Test
    public void getPointN(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        LineString line = new LineString(Arrays.asList(p1,p2));
        Point getLastPoint = line.getPointN(2);
        Assert.assertSame(p2,getLastPoint);
    }

    @Test
    public  void getGeomTypeTest(){
        LineString line = new LineString();
        Assert.assertEquals("Line",line.getType());
    }
}
