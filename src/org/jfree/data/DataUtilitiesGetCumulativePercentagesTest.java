package org.jfree.data;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class DataUtilitiesGetCumulativePercentagesTest {

	@Before
	public void setUp() throws Exception {
		
	}
	
	
	@Test
	public void positiveCumilativePercentageTest() {
		Mockery mockingContext1 = new Mockery(); 
		final KeyedValues input = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() { 
			{
				atLeast(1).of(input).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(input).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(input).getValue(0);
				will(returnValue(20));
				
				atLeast(1).of(input).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(input).getValue(1);
				will(returnValue(40));
				
				atLeast(1).of(input).getKey(2);
				will(returnValue(3));
				
				atLeast(1).of(input).getValue(2);
				will(returnValue(60));
				
			} 
		});
		
		Mockery mockingContext2 = new Mockery();
		final KeyedValues expected = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				atLeast(1).of(expected).getItemCount(); 
				will(returnValue(3));
			
				atLeast(1).of(expected).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(expected).getValue(0);
				will(returnValue(0.166));
				
				atLeast(1).of(expected).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(expected).getValue(1);
				will(returnValue(0.500));
				
				atLeast(1).of(expected).getKey(2);
				will(returnValue(2));
				
				atLeast(1).of(expected).getValue(2);
				will(returnValue(1.0));
			} 
		});
		
	//	KeyedValues actual = DataUtilities.getCumulativePercentages(input); 
		
		//assertEquals(expected, actual);
		
		assertTrue(DataUtilities.getCumulativePercentages(input).equals(expected));
	}
	
	@Test
	public void negativeCumilativePercentageTest() {
		Mockery mockingContext1 = new Mockery(); 
		final KeyedValues input = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() { 
			{
				atLeast(1).of(input).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(input).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(input).getValue(0);
				will(returnValue(-20));
				
				atLeast(1).of(input).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(input).getValue(1);
				will(returnValue(-40));
				
				atLeast(1).of(input).getKey(2);
				will(returnValue(3));
				
				atLeast(1).of(input).getValue(2);
				will(returnValue(-60));
				
			} 
		});
		
		Mockery mockingContext2 = new Mockery();
		final KeyedValues expected = mockingContext2.mock(KeyedValues.class);
		mockingContext2.checking(new Expectations() {
			{
				atLeast(1).of(expected).getItemCount(); 
				will(returnValue(3));
			
				atLeast(1).of(expected).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(expected).getValue(0);
				will(returnValue(0.166));
				
				atLeast(1).of(expected).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(expected).getValue(1);
				will(returnValue(0.500));
				
				atLeast(1).of(expected).getKey(2);
				will(returnValue(2));
				
				atLeast(1).of(expected).getValue(2);
				will(returnValue(1.0));
			} 
		});
		
		//KeyedValues actual = DataUtilities.getCumulativePercentages(input); 
		
	//	assertEquals(expected, actual);
		
		assertTrue(DataUtilities.getCumulativePercentages(input).equals(expected));
	}
	
	@Test
	public void zeroCumilativePercentageTest() {
		Mockery mockingContext1 = new Mockery(); 
		final KeyedValues input = mockingContext1.mock(KeyedValues.class);
		mockingContext1.checking(new Expectations() { 
			{
				atLeast(1).of(input).getItemCount();
				will(returnValue(3));
				
				atLeast(1).of(input).getKey(0);
				will(returnValue(0));
				
				atLeast(1).of(input).getValue(0);
				will(returnValue(0));
				
				atLeast(1).of(input).getKey(1);
				will(returnValue(1));
				
				atLeast(1).of(input).getValue(1);
				will(returnValue(0));
				
				atLeast(1).of(input).getKey(2);
				will(returnValue(0));
				
				atLeast(1).of(input).getValue(2);
				will(returnValue(0));
				
			} 
		});
		
		
		try {
			DataUtilities.getCumulativePercentages(input);	
			//fail("Exeption by dividing by zero");
		}
		catch(Exception err) {
			assertEquals("Exception thrown should be",  ArithmeticException.class, err.getClass());
		}
		
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}



}
