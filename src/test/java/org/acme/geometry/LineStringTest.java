package org.acme.geometry;


import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
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
        Assert.assertEquals("LineString",line.getType());
    }

    @Test
    public void testTranslate(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        LineString line = new LineString(Arrays.asList(p1,p2));
        line.translate(1.0,1.0);
        Assert.assertEquals(1.0,line.getPointN(1).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(4.0,line.getPointN(2).getCoordinate().getY(),EPSILON);

    }
    @Test
    public void testClone(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        LineString line = new LineString(Arrays.asList(p1,p2));
        LineString lineClone = line.clone();
        lineClone.translate(2.0,2.0);
        Assert.assertEquals(0.0,line.getPointN(1).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(2.0,lineClone.getPointN(1).getCoordinate().getX(),EPSILON);
        Assert.assertEquals(3.0,line.getPointN(2).getCoordinate().getY(),EPSILON);
        Assert.assertEquals(5.0,lineClone.getPointN(2).getCoordinate().getY(),EPSILON);
    }

    @Test
    public void testEnvelope(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));
        LineString line = new LineString(Arrays.asList(p1,p2,p3,p4));

        Assert.assertEquals(0.0,line.getEnvelope().getXMin(),EPSILON);
        Assert.assertEquals(0.0,line.getEnvelope().getYMin(),EPSILON);
        Assert.assertEquals(3.0,line.getEnvelope().getXMax(),EPSILON);
        Assert.assertEquals(5.0,line.getEnvelope().getYMax(),EPSILON);
    }

    @Test
    public void testWkt(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));
        LineString line = new LineString(Arrays.asList(p1,p2,p3,p4));
        WktWriter writer = new WktWriter();
        Assert.assertEquals("LINESTRING(0.0 0.0,2.0 3.0,2.4 3.5,3.0 5.0)",writer.write(line));
    }

    @Test
    public void testVisitor() throws UnsupportedEncodingException {
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));
        LineString line = new LineString(Arrays.asList(p1,p2,p3,p4));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        line.accept(visitor);
        String result = os.toString("UTF8");
        Assert.assertEquals("Je suis une polyligne définie par 4 point(s)",result.trim());
    }

    @Test
    public void testWktVisitor(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));
        LineString line = new LineString(Arrays.asList(p1,p2,p3,p4));
        WktVisitor visitor = new WktVisitor();
        line.accept(visitor);
        Assert.assertEquals( "LINESTRING(0.0 0.0,2.0 3.0,2.4 3.5,3.0 5.0)", visitor.getResult() );
    }

    @Test
    public void testAsText(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));
        LineString line = new LineString(Arrays.asList(p1,p2,p3,p4));
        Assert.assertEquals( "LINESTRING(0.0 0.0,2.0 3.0,2.4 3.5,3.0 5.0)", line.asText() );
    }

    @Test
    public void testEnvelopeVisite() throws UnsupportedEncodingException {
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));
        LineString line = new LineString(Arrays.asList(p1,p2,p3,p4));

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(os);
        EnvelopeBuilder envelopeVisite = new EnvelopeBuilder(out);
        line.accept(envelopeVisite);
        String result = os.toString("UTF8");
        Assert.assertEquals("Extent(XMin:0.0 YMin:0.0 XMax:3.0 YMax:5.0)",result.trim());
    }

    @Test
    public void testCachedEnvelop(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));

        Geometry g = new LineString(Arrays.asList(p1,p2,p3,p4));
        g = new GeometryWithCachedEnvelope(g);
        Envelope a = g.getEnvelope() ;
        Envelope b = g.getEnvelope() ;
        Assert.assertSame(a,b);
    }

    @Test
    public void TestGeometryListener(){
        Point p1 = new Point(new Coordinate(0.0,0.0));
        Point p2 = new Point(new Coordinate(2.0,3.0));
        Point p3 = new Point(new Coordinate(2.4,3.5));
        Point p4 = new Point(new Coordinate(3.0,5.0));

        Geometry line = new LineString(Arrays.asList(p1,p2,p3,p4));
        GeometryWithCachedEnvelope pointCache = new GeometryWithCachedEnvelope(line);
        line.translate(1.0,1.0);
        pointCache.onChange(line);
        Envelope envelope = line.getEnvelope();

        Assert.assertEquals(pointCache.getEnvelope().getXMax(),envelope.getXMax(),EPSILON);
        Assert.assertEquals(pointCache.getEnvelope().getXMin(),envelope.getXMin(),EPSILON);

    }
}
