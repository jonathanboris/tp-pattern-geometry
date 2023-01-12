package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

public class CoordinateTest {

	public static final double EPSILON = 1.0e-15;

	@Test
	public void testDefaultConstructor(){
		// TODO
		Coordinate c = new Coordinate();
		Assert.assertNotEquals(null, c.getX(), EPSILON);
		Assert.assertNotEquals(null, c.getY(), EPSILON);
	}

	@Test
	public void testConstructor(){
		Coordinate c = new Coordinate(4.0,1.2);
		Assert.assertEquals(4.0, c.getX(), EPSILON);
		Assert.assertEquals(1.2, c.getY(), EPSILON);
	}

	@Test
	public void testIsEmpty(){
		Coordinate c = new Coordinate();
		Assert.assertEquals(true,c.isEmpty());
	}

}
