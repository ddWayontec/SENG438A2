/**
 * 
 */
package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author muzhd
 *
 */
public class RangeCombineTest {

	private Range negRange1;
	private Range negRange2;
	private Range negToPosRange;
	private Range posRange1;
	private Range posRange2;
	private Range zeroToPosRange;
	private Range negToZeroRange;
	

	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		negRange1 = new Range(-5.0, -1.0);
		negRange2 = new Range(-10.0, -2.0);
		negToPosRange = new Range(-3.0, 3.0);;
		posRange1 = new Range(1.0, 5.0);
		posRange2 = new Range(2.0, 10.0);
		zeroToPosRange = new Range(0.0, 6.0);
		negToZeroRange = new Range(-6.0, 0.0);
	}
	
	@Test
	public void combinedRangeNegatives() {
		Range expected = new Range(-10.0, -1.0);
		assertEquals("Expected range is (-10.0, -1.0)", expected, Range.combine(negRange1, negRange2));
		//fail("Not yet implemented");
	}
	
	@Test
	public void combinedRangePositives() {
		Range expected = new Range(1.0, 10.0);
		assertEquals("Expected range is (1.0, 10.0)", expected, Range.combine(posRange2, posRange1));
	}
	
	@Test
	public void combinedRangePosWNeg() {
		Range expected = new Range(-5.0, 5.0);
		
		assertEquals("These ranges are disjoint", expected, Range.combine(posRange1, negRange1));
	}
	
	@Test
	public void combinedRangeZeroAndPos() {
		Range expected = new Range(0.0, 6.0);
		assertEquals("Expected range is (0.0, 6.0)", expected, Range.combine(posRange1, zeroToPosRange));
	}

	@Test
	public void combinedRangeZeroAndNeg() {
		Range expected = new Range(-5.0, 0.0);
		assertEquals("Expected range is (-5.0, 0.0)", expected, Range.combine(negRange1, negToZeroRange));
	}
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}



}
