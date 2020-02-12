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
    
    @Test
    public void testingANullRange()
    {
        try
        {
            Range shouldThrowAnException = Range.expand(null, 0, 0);   
        }
        catch(InvalidParameterException ipe)
        {
          //This is here so that the test automatically passes if it threw the correct exception!
            assertTrue("This message should not be printed", true);
        }
        catch(Exception e)
        {
            fail("Expanding a null range produced the wrong exception...");
        } 
    }

    @Test
    public void testingAnExpansionOfZero() 
    {
        try
        {
            Range shouldBeACopyOfExampleRange = Range.expand(exampleRange, 0, 0);
            assertEquals("The range produced after an expansion of zero was different than the original!", exampleRange, shouldBeACopyOfExampleRange);
        }
        catch(Exception e)
        {
            fail("An expansion of zero produced an exception!");
        }
    }  
    
    @Test
    public void testingAnExpansionOfUnderOneHundred()
    {
        try
        {
            Range shouldBeARangeFromZeroToNine = Range.expand(exampleRange, 0.5, 0.75);
            assertEquals("The range produced after an expansion of under one hundred was incorrect!", new Range(0,9), shouldBeARangeFromZeroToNine);
        }
        catch(Exception e)
        {
            fail("An expansion of under one hundred produced an exception!");
        }
    }
    
    @Test
    public void testingAnExpansionOfOverOneHundred()
    {
        try
        {
            Range shouldBeARangeFromNegativeThreeToEleven = Range.expand(exampleRange, 1.25, 1.25);
            assertEquals("The range produced after an expansion of over one hundred was incorrect!", new Range(-3,11), shouldBeARangeFromNegativeThreeToEleven);
        }
        catch(Exception e)
        {
            fail("An expansion of over one hundred produced an exception!");
        }
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
