package io.catalyte.training;

import java.math.BigDecimal;
import java.util.List;

public class LogicProblemsImpl implements LogicProblems {
  //TODO: Implement all requirements as defined in the project description.


    @Override
    public Double average(int[] scores) {
        int sum = 0;
        double average = 0;
        double result;
        for(int i = 0; i < scores.length; i++)
        {
            if (scores.length == 0)
            {
                return average;
            }
            else if (scores[i] < 0)
            {
                System.out.println("Scores must be positive");
            }
            else
            {
                sum += i;
                average = sum / scores.length;
                return average;
            }

        }
        return average;
    }
    /*
    double average = Arrays.stream(scores).asDoubleStream().average().getAsDouble();
    return average;
    System.out.println(average);
    */
    @Override
    public int lastWordLength(String text) {
        int LWL = 0;
        String x = text.trim();

        if (x.length() == 0){
            System.out.println("Input must not be an empty String");
        }

        for (int i = 0;i<x.length();i++)
        {
            if (x.charAt(i) == ' ')
            {
                LWL = 0;
            }
            else
            {
                LWL++;
            } // end if
        }// end for

        return LWL;
    }

    @Override
    public BigDecimal distinctLadderPaths(int rungs) {
        return null;
    }

    @Override
    public List<List<String>> groupStrings(String[] strs) {
        return null;
    }
}
