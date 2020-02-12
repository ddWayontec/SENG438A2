package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesCreateNumberArrayTest 
{
    double[] doubleArrayWithOnlyIntegers;  
    double[] doubleArrayWithNonIntegerValues;  
    double[] doubleArrayWithNegativeValues;  
    double[] doubleArrayWithMixedValues; 
    double[] invalidDoubleArray;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception 
    {
        
    }

    @Before
    public void setUp() throws Exception 
    {
        doubleArrayWithOnlyIntegers = new double[3];
        doubleArrayWithOnlyIntegers[0] = 1;
        doubleArrayWithOnlyIntegers[1] = 3;
        doubleArrayWithOnlyIntegers[2] = 2;
        
        doubleArrayWithNonIntegerValues = new double[3];
        doubleArrayWithNonIntegerValues[0] = 1.1;
        doubleArrayWithNonIntegerValues[1] = 0.1;
        doubleArrayWithNonIntegerValues[2] = 3.14;
        
        doubleArrayWithNegativeValues = new double[3];
        doubleArrayWithNegativeValues[0] = -1;
        doubleArrayWithNegativeValues[1] = -2;
        doubleArrayWithNegativeValues[2] = -0.7;
        
        doubleArrayWithMixedValues = new double[10];
        doubleArrayWithMixedValues[0] = 1;
        doubleArrayWithMixedValues[1] = 1.1;
        doubleArrayWithMixedValues[2] = 7;
        doubleArrayWithMixedValues[3] = 110;
        doubleArrayWithMixedValues[4] = 0.165;
        doubleArrayWithMixedValues[5] = -0.1;
        doubleArrayWithMixedValues[6] = 0.3;
        doubleArrayWithMixedValues[7] = -300;
        doubleArrayWithMixedValues[8] = 0;
        doubleArrayWithMixedValues[9] = 0;
        
        invalidDoubleArray = null;
    }
    
    @Test
    public void testWithIntegersOnly() 
    {
        Number[] numberArray = DataUtilities.createNumberArray(doubleArrayWithOnlyIntegers);
        if(doubleArrayWithOnlyIntegers.length != numberArray.length)
        {
            fail("The arrays were not of matching size...");
        }
        boolean areArraysMatching = true;
        for(int i = 0; i < doubleArrayWithOnlyIntegers.length; i++)
        {
            if(doubleArrayWithOnlyIntegers[i] != numberArray[i].doubleValue())
            {
                areArraysMatching = false;
            }
        }
        assertTrue(areArraysMatching);
    }
    
    @Test
    public void testWithNonIntegersOnly() 
    {
        Number[] numberArray = DataUtilities.createNumberArray(doubleArrayWithNonIntegerValues);
        if(doubleArrayWithNonIntegerValues.length != numberArray.length)
        {
            fail("The arrays were not of matching size...");
        }
        boolean areArraysMatching = true;
        for(int i = 0; i < doubleArrayWithNonIntegerValues.length; i++)
        {
            if(doubleArrayWithNonIntegerValues[i] != numberArray[i].doubleValue())
            {
                areArraysMatching = false;
            }
        }
        assertTrue(areArraysMatching);
    }
    
    @Test
    public void testWithNegativeValuesOnly() 
    {
        Number[] numberArray = DataUtilities.createNumberArray(doubleArrayWithNegativeValues);
        if(doubleArrayWithNegativeValues.length != numberArray.length)
        {
            fail("The arrays were not of matching size...");
        }
        boolean areArraysMatching = true;
        for(int i = 0; i < doubleArrayWithNegativeValues.length; i++)
        {
            if(doubleArrayWithNegativeValues[i] != numberArray[i].doubleValue())
            {
                areArraysMatching = false;
            }
        }
        assertTrue(areArraysMatching);
    }
    
    @Test
    public void testWithIntegersAndNonIntegersAndNegativeValues() 
    {
        Number[] numberArray = DataUtilities.createNumberArray(doubleArrayWithMixedValues);
        if(doubleArrayWithMixedValues.length != numberArray.length)
        {
            fail("The arrays were not of matching size...");
        }
        boolean areArraysMatching = true;
        for(int i = 0; i < doubleArrayWithMixedValues.length; i++)
        {
            if(doubleArrayWithMixedValues[i] != numberArray[i].doubleValue())
            {
                areArraysMatching = false;
            }
        }
        assertTrue(areArraysMatching);
    }
    
    @Test (expected = InvalidParameterException.class)
    public void testForANullArray() 
    {
        Number[] numberArray = DataUtilities.createNumberArray(invalidDoubleArray);
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
