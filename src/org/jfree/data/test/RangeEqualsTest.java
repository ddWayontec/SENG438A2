package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeEqualsTest {
	private Range rangeObject;

	@BeforeClass 
	public static void setUpBeforeClass()
			throws Exception {
	}

	@Before
	public void setUp() throws Exception { 
		rangeObject = new Range(-1, 1);
	}

	@Test
	public void equalsTest() {
		Range equalObject = new Range(-1, 1);
		assertTrue( rangeObject.equals(equalObject) );
	}

	@Test
	public void notEqualsTest() {
		Range notEqualObject = new Range(0, 1);
		assertFalse( rangeObject.equals(notEqualObject) );
	}

}
