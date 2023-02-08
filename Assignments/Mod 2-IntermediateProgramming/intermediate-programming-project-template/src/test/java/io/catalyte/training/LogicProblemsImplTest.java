/**
 * Test file for Intermediate Programming Project
 * This Java File contains the testing for the Logic Problems for the Intermediate Programming Project
 * @author Richy Phongsavath
 * @version: 1.0
 * @Date: 12/12/22
 * @Class: CO-CP-Alpha1
 */
package io.catalyte.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Tests for all unit testing to return the expected results for tests.
 */
public class LogicProblemsImplTest {
    private LogicProblemsImpl exercise;

    @BeforeEach
    public void init() {

        exercise = new LogicProblemsImpl();

    }

    /**
     * Tests to return expected average for an array of integers.
     */
    @Test
    public void averageSingleDecimalTest()
    {
        int[] scores = {4, 5, 6, 8, 10, 12};
        Double expected = (7.50);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong average. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Test to return expected average set to 2 decimal points.
     */
    @Test
    public void averageTwoDecimalTest()
    {
        int[] scores = {1,4,2};
        Double expected = (2.33);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong decimal point. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Test for expected  results for Integer Array with a single integer.
     */
    @Test
    public void averageSingleArrayTest()
    {
        int[] scores = {10};
        Double expected = (10.00);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong decimal point. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Test for empty array for expected result.
     */
    @Test
    public void averageEmptyArrayTest()
    {
        int[] scores = {};
        Double expected = (0.00);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Test for exception when a negative Integer is passed in an Integer array
     */
    @Test
    public void averageNegativeIntTest()
    {
        //https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
        assertThrows(ArithmeticException.class,()->
        {
            int[] scores = {1,-4,2};
            Double result = exercise.average(scores);
        });

    }

    /**
     * Test for expected count of last word of a string.
     */
    @Test
    public void lastWordTestCount()
    {

        String text = ("test this string");
        int expected = 6;
        int result = exercise.lastWordLength(text);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Test a string with only whitespace, when called the last word returns 0.
     */
    @Test
    public void LastWordTestWhitespace()
    {

        String text = ("     ");//5 spaces
        int expected = 0;
        int result = exercise.lastWordLength(text);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Tests an empty string then an exception is thrown with a message of "input must not be an empty string"
     */
    @Test
    public void LastWordTestEmptySpring() {
        //https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
        assertThrows(IllegalArgumentException.class, () ->
        {
            String text = ("");//empty string
            int result = exercise.lastWordLength(text);

        });
    }

    /**
     * Given a certain number of ladders, functions returns an expected number of paths to climb latter.
     */
    @Test
    public void LadderPathsTestCount()
    {
        int rungs  = 3;
        BigDecimal expected = BigDecimal.valueOf(3);
        BigDecimal result = exercise.distinctLadderPaths(rungs);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Tests the function with 0 rung and return  0.
     */
    @Test
        public void LadderPathsTestZero()
        {
            int rungs  = 0;
            BigDecimal expected = BigDecimal.valueOf(0);
            BigDecimal result = exercise.distinctLadderPaths(rungs);
            assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
        }

    /**
     * Tests the function with 100 rung and return expected results
      */
    @Test
    public void LadderPathsTest100()
    {
        int rungs  = 100;
        BigDecimal expected = new BigDecimal("573147844013817084101");
        BigDecimal result = exercise.distinctLadderPaths(rungs);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }

    /**
     * Tests a negative integers then an exception is thrown with a message of "ladders can't have negative rungs"
     */
    @Test
    public void LadderPathsTestNegative()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            int rungs = -1;
            BigDecimal result = exercise.distinctLadderPaths(rungs);

        });
    }

    /**
     * Tests a strings within a grouping that have the same first letters and the same last letters.
     */
       @Test
       public void groupStringsTestSort()
       {
           String [] strs = {"arrange", "act", "assert", "ace"};

           List<String> ExpectedList1 = new ArrayList<>();
           List<String> ExpectedList2 = new ArrayList<>();

           ExpectedList1.add("act");
           ExpectedList1.add("assert");
           ExpectedList2.add ("arrange");
           ExpectedList2.add("ace");

           List<List<String>> expected = new ArrayList<>();
           expected.add(ExpectedList1);
           expected.add(ExpectedList2);

           List<List<String>> result = exercise.groupStrings(strs);
           assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
        }

    /**
     * Tests a strings within a grouping that have the same first letters and the same last letters with Capital Letters
     */
    @Test
    public void groupStringsTestCapitalSort()
    {
        String [] strs = {"Bunt", "BUT", "CRoss", "crocs"};

        List<String> ExpectedList1 = new ArrayList<>();
        List<String> ExpectedList2 = new ArrayList<>();



        ExpectedList1.add ("cross");
        ExpectedList1.add("crocs");
        ExpectedList2.add("bunt");
        ExpectedList2.add("but");

        List<List<String>> expected = new ArrayList<>();
        expected.add(ExpectedList1);
        expected.add(ExpectedList2);

        List<List<String>> result = exercise.groupStrings(strs);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }
    /**
     * Given an empty array, then receive an empty Lis
     */
    @Test
        public void groupStringsEmptyArray()
        {
            String [] strs = {};
            List<List<String>> expected = new ArrayList<>();
            List<List<String>> result = exercise.groupStrings(strs);
           assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
        }

    /**
     * Tests an array with an empty string, then an exception is thrown with a message of "strings must not be empty".
     */
        @Test
        public void groupStringsTestEmptyString()
        {
            assertThrows(IllegalArgumentException.class, () ->
            {
                String [] strs = {" "};//1 empty space
                List<List<String>> result = exercise.groupStrings(strs);

            });
        }
        /*
    public BigDecimal distinctLadderPaths(int rungs);

    public List<List<String>> groupStrings(String[] strs);
    */
}