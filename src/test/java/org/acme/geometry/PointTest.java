package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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

    @Test
    public void testTranslate(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        point.translate(1.0,1.0);
        Assert.assertEquals(5.0,point.getCoordinate().getX(),EPSILON);
        Assert.assertEquals(2.2,point.getCoordinate().getY(),EPSILON);
    }

    @Test
    public void testClone(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        Point pointCopy = point.clone();
        pointCopy.translate(2.0,2.0);
        Assert.assertEquals(4.0,point.getCoordinate().getX(),EPSILON);
        Assert.assertEquals(6.0,pointCopy.getCoordinate().getX(),EPSILON);
        Assert.assertEquals(1.2,point.getCoordinate().getY(),EPSILON);
        Assert.assertEquals(3.2,pointCopy.getCoordinate().getY(),EPSILON);
    }

    @Test
    public void testEnvelope(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        Assert.assertEquals(4.0,point.getEnvelope().getXMax(),EPSILON);
        Assert.assertEquals(1.2,point.getEnvelope().getYMax(),EPSILON);
        Assert.assertEquals(4.0,point.getEnvelope().getXMin(),EPSILON);
        Assert.assertEquals(1.2,point.getEnvelope().getYMin(),EPSILON);
    }

    @Test
    public void testWtk(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT(4.0 1.2)",writer.write(point));
    }

    @Test
    public void testVisitor() throws UnsupportedEncodingException {
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        point.accept(visitor);
        String result = os.toString("UTF8");

        Assert.assertEquals("je suis un point avec x=4.0 et y=1.2",result.trim());
    }

    @Test
    public void testWktVisitor(){
        WktVisitor visitor = new WktVisitor();
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        point.accept(visitor);
        Assert.assertEquals( "POINT(4.0 1.2)", visitor.getResult() );
    }

    @Test
    public void testAsText(){
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);
        Assert.assertEquals( "POINT(4.0 1.2)", point.asText());
    }
    @Test
    public void testEnvelopeVisite() throws UnsupportedEncodingException {
        Coordinate c = new Coordinate(4.0,1.2);
        Point point = new Point(c);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        EnvelopeBuilder envelopeVisite = new EnvelopeBuilder(out);
        point.accept(envelopeVisite);
        String result = os.toString("UTF8");
        Assert.assertEquals("Extent(XMin:4.0 YMin:1.2 XMax:4.0 YMax:1.2)",result.trim());
    }

    @Test
    public void testCachedEnvelop(){
        Geometry g = new Point(new Coordinate(3.0,3.0));
        g = new GeometryWithCachedEnvelope(g);
        Envelope a = g.getEnvelope() ;
        Envelope b = g.getEnvelope() ;
        Assert.assertSame(a,b);
    }

    @Test
    public void TestGeometryListener(){
        Geometry point = new Point(new Coordinate(3.0,3.0));
        GeometryWithCachedEnvelope pointCache = new GeometryWithCachedEnvelope(point);
        point.translate(1.0,1.0);
        pointCache.onChange(point);
        Envelope envelope = point.getEnvelope();

       Assert.assertEquals(pointCache.getEnvelope().getXMax(),envelope.getXMax(),EPSILON);

    }
}
