package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesCalculateRowTotalTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
	public void invalidNullDataArg() { 
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("method should throw exception");
		}
		catch(Exception err) {
			assertEquals("Exception thrown is of type invalidParameterException", InvalidParameterException.class, err.getClass());
		}
	} 
	
	@Test
	public void invalidDataRowOutOfBounds() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(2));
				
				one(values).getValue(2, 0);
				will(returnValue(null));
				
				one(values).getValue(2, 1); 
				will(returnValue(null));						
			} 
		});
		
		double result = DataUtilities.calculateRowTotal(values, 2);
		assertEquals("invalid data will return value of 0", 0, result, .00001d);
	}
	
	@Test
	public void emptyChart() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(0));
			} 
		});
		
		assertEquals(0, DataUtilities.calculateRowTotal(values, 0), .000000001d);
	}

	@Test
	public void notEmptyPositiveRow() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(3));
				
				one(values).getValue(1, 0);
				will(returnValue(1.0));
				
				one(values).getValue(1, 1); 
				will(returnValue(2.0));
				
				one(values).getValue(1, 2); 
				will(returnValue(3.0));
			} 
		});
		
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals("row total will add up to 6", 6, result, .00001d);
		
	}
	

	
	@Test
	public void notEmptyNegativeRow() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getColumnCount(); 
				will(returnValue(3));
				
				one(values).getValue(-1, 0);
				will(returnValue(null));
				
				one(values).getValue(-1, 1); 
				will(returnValue(null));
				
				one(values).getValue(-1, 2); 
				will(returnValue(null));

			} 
		});
		
		double result = DataUtilities.calculateRowTotal(values, -1);
		assertEquals("row total will add up to 0", 0, result, .00001d);
	}

}
