package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandTest 
{
    Range exampleRange;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception 
    {
        
    }
    
    @Before
    public void setUp() throws Exception 
    {
        exampleRange = new Range(2,6);
    }
    
    @Test (expected = InvalidParameterException.class)
    public void testingANullRange()
    {
        Range shouldThrowAnException = Range.expand(null, 0, 0);      
    }

    @Test
    public void testingAnExpansionOfZero() 
    {
        Range shouldBeACopyOfExampleRange = Range.expand(exampleRange, 0, 0);
        assertEquals(exampleRange, shouldBeACopyOfExampleRange);
    }  
    
    @Test
    public void testingAnExpansionOfUnderOneHundred()
    {
        Range shouldBeARangeFromZeroToNine = Range.expand(exampleRange, 0.5, 0.75);
        assertEquals(new Range(0,9), shouldBeARangeFromZeroToNine);
    }
    
    @Test
    public void testingAnExpansionOfOverOneHundred()
    {
        Range shouldBeARangeFromNegativeThreeToEleven = Range.expand(exampleRange, 1.25, 1.25);
        assertEquals(new Range(-3,11), shouldBeARangeFromNegativeThreeToEleven);
    }

    @After
    public void tearDown() throws Exception 
    {
        
    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception 
    {
        
    }
}
