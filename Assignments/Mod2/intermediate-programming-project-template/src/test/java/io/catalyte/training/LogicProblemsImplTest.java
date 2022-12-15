package io.catalyte.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

public class LogicProblemsImplTest {
    private LogicProblemsImpl exercise;

    @BeforeEach
    public void init() {

        exercise = new LogicProblemsImpl();

    }
  //TODO: Implement all requirements as specified in the requirements document
    @Test
    public void averageSingleDecimalTest()
    {
        int[] scores = {4, 5, 6, 8, 10, 12};
        Double expected = (7.50);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong average. Expected: " +expected + ". Got: " + result);
    }

    @Test
    public void averageTwoDecimalTest()
    {
        int[] scores = {1,4,2};
        Double expected = (2.33);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong decimal point. Expected: " +expected + ". Got: " + result);
    }
    @Test
    public void averageSingleArrayTest()
    {
        int[] scores = {10};
        Double expected = (10.00);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong decimal point. Expected: " +expected + ". Got: " + result);
    }
    @Test
    public void averageEmptyArrayTest()
    {
        int[] scores = {};
        Double expected = (0.00);
        Double result = exercise.average(scores);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }


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
    @Test
    public void lastWordTestCount()
    {

        String text = ("test this string");
        int expected = 6;
        int result = exercise.lastWordLength(text);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }
    @Test
    public void LastWordTestWhitespace()
    {

        String text = ("     ");//5 spaces
        int expected = 0;
        int result = exercise.lastWordLength(text);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }

    @Test
    public void LastWordTestEmptySpring() {
        //https://junit.org/junit5/docs/current/user-guide/#writing-tests-assertions
        assertThrows(IllegalArgumentException.class, () ->
        {
            String text = ("");//empty string
            int result = exercise.lastWordLength(text);

        });
    }
    @Test
    public void LadderPathsTestCount()
    {
        int rungs  = 3;
        BigDecimal expected = BigDecimal.valueOf(3);
        BigDecimal result = exercise.distinctLadderPaths(rungs);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }
        @Test
        public void LadderPathsTestZero()
        {
            int rungs  = 0;
            BigDecimal expected = BigDecimal.valueOf(0);
            BigDecimal result = exercise.distinctLadderPaths(rungs);
            assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
        }

        @Test
    public void LadderPathsTest100()
    {
        int rungs  = 100;
        BigDecimal expected = new BigDecimal("573147844013817084101");
        BigDecimal result = exercise.distinctLadderPaths(rungs);
        assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
    }


    @Test
    public void LadderPathsTestNegative()
    {
        assertThrows(IllegalArgumentException.class, () ->
        {
            int rungs = -1;
            BigDecimal result = exercise.distinctLadderPaths(rungs);

        });
    }

       @Test
       public void groupStringsTestSort()
       {
           String [] strs = {"arrange", "act", "assert", "ace"};
           List<List<String>> expected = { {"arrange", "ace"}, {"act", "assert"}};
           List<List<String>> result = exercise.groupStrings(strs);
          // assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
        }

        /*@Test
        public void groupStringsEmptyArray()
        {
            String [] strs = {};
            List<List<String>> expected = ("");
            List<List<String>> result = exercise.groupStrings(strs);
            assertEquals(expected, result, "Wrong result. Expected: " +expected + ". Got: " + result);
        }

        public void groupStringsTestEmptyString()
        {
            assertThrows(IllegalArgumentException.class, () ->
            {
                String [] strs = {" "};//1 empty space
                BigDecimal result = exercise.groupStrings(strs);

            });
        }
        /*
    public BigDecimal distinctLadderPaths(int rungs);

    public List<List<String>> groupStrings(String[] strs);
    */
}