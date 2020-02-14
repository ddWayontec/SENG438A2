package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeIntersectTest {
	public static Range positiveControlRange;
	public static Range negativeControlRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		positiveControlRange = new Range (2, 10);
		negativeControlRange = new Range (-16, -8);
	}

	@Test
	public void positiveRangeIntersectsAtEnd() {
		Boolean intersectsResult = positiveControlRange.intersects(8, 15);
		assertTrue("positive intersection of range at tail end returns true", intersectsResult);
	}
	
	@Test
	public void positiveRangeIntersectsAtStart() {
		Boolean intersectsResult = positiveControlRange.intersects(0, 4);
		assertTrue("positive intersection of range at start returns true", intersectsResult);
	}
	
	@Test
	public void greaterPositiveRangeDoesNotIntersect() {
		Boolean intersectsResult = positiveControlRange.intersects(11, 15);
		assertFalse("positive range greater than compared range does not intersect", intersectsResult);
	}
	
	@Test
	public void smallerPositiveRangeDoesNotIntersect() {
		Boolean intersectsResult = positiveControlRange.intersects(0, 1);
		assertFalse("positive range smaller than compared range does not intersect", intersectsResult);
	}
	
	@Test
	public void positiveRangeCompleteOverlapIntersects() {
		Boolean intersectsResult = positiveControlRange.intersects(5, 8);
		assertTrue("positive range that is subset of another range intersects", intersectsResult);
	}
	
	//same tests but with negative numbers
	
	@Test
	public void negativeRangeIntersectsAtEnd() {
		Boolean intersectsResult = negativeControlRange.intersects(-10, -5);
		assertTrue("negative intersection of range at tail end returns true", intersectsResult);
	}
	
	@Test
	public void negativeRangeIntersectsAtStart() {
		Boolean intersectsResult = negativeControlRange.intersects(-20, -14);
		assertTrue("negative intersection of range at start returns true", intersectsResult);
	}
	
	@Test
	public void greaterNegativeRangeDoesNotIntersect() {
		Boolean intersectsResult = negativeControlRange.intersects(-7, -3);
		assertFalse("negative range greater than compared range does not intersect", intersectsResult);
	}
	
	@Test
	public void smallerNegativeRangeDoesNotIntersect() {
		Boolean intersectsResult = negativeControlRange.intersects(-30, -20);
		assertFalse("negative range smaller than compared range does not intersect", intersectsResult);
	}
	
	
	@Test
	public void negativeRangeCompleteOverlapIntersects() {
		Boolean intersectsResult = negativeControlRange.intersects(-13, -10);
		assertTrue("range that is subset of another range intersects", intersectsResult);
	}


}
