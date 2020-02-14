package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesCalculateColumnTotalTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Test
	public void invalidNullDataArg() { 
		try {
			DataUtilities.calculateColumnTotal(null, 0);
		}
		catch(Exception err) {
			assertEquals("Exception thrown is of type invalidParameterException", InvalidParameterException.class, err.getClass());
		}
	} 
	
	@Test
	public void invalidDataColumnOutOfBounds() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(2));
				
				one(values).getValue(0, 1);
				will(returnValue(null));
				
				one(values).getValue(1, 1); 
				will(returnValue(null));
				
			} 
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals("invalid data will return value of 0", 0, result, .00001d);
	}

	@Test
	public void validPositiveColumn() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(2));
				
				one(values).getValue(0, 0);
				will(returnValue(3));
				
				one(values).getValue(1, 0); 
				will(returnValue(5));
				
			} 
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("column total will add up to 8", 8, result, .00001d);
		
	}
	
	@Test
	public void validNegativeColumn() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(2));
				
				one(values).getValue(0, 0);
				will(returnValue(-3));
				
				one(values).getValue(1, 0); 
				will(returnValue(-5));
				
			} 
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("column total will add up to -8", -8, result, .00001d);
	}
	
	@Test
	public void validPositiveNegativeColumn() {
		Mockery mockingContext = new Mockery(); 
		final Values2D values = mockingContext.mock(Values2D.class);
		
		mockingContext.checking(new Expectations() { 
			{
				one(values).getRowCount(); 
				will(returnValue(2));
				
				one(values).getValue(0, 0);
				will(returnValue(-24));
				
				one(values).getValue(1, 0); 
				will(returnValue(23));
				
			} 
		});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals("column total will add up to -1", -1, result, .00001d);
	}

}
