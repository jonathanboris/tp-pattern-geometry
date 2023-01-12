package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;
    @Test
    public void testDefaultConstructor(){
        Point point = new Point();
        Coordinate coordonateTest = point.getCoordinate();
        Assert.assertNotEquals(null, coordonateTest.getX(), EPSILON);
        Assert.assertNotEquals(null, coordonateTest.getY(), EPSILON);
    }
    @Test
    public void testConstructor(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        Coordinate coordonate = point.getCoordinate();
        Assert.assertEquals(4.0, coordonate.getX(), EPSILON);
        Assert.assertEquals(1.2, coordonate.getY(), EPSILON);
    }
    @Test
    public  void getGeomTypeTest(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        Assert.assertEquals("Point",point.getType());
    }

}
