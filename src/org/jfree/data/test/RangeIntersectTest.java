package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeIntersectTest {
	public static Range controlRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		controlRange = new Range (1, 10);
	}

	@Test
	public void rangePartiallyIntersect() {
		Boolean intersectsResult = controlRange.intersects(8, 15);
		assertFalse(intersectsResult);
	}
	
	@Test
	public void rangeDoesNotIntersect() {
		Boolean intersectsResult = controlRange.intersects(11, 15);
		assertFalse(intersectsResult);
	}
	
	@Test
	public void rangeIntersects() {
		Boolean intersectsResult = controlRange.intersects(5, 8);
		assertTrue(intersectsResult);
	}
	
	


}
