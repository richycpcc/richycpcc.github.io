package io.catalyte.training;

import java.math.BigDecimal;
import java.util.List;

/*
 ***********************************************************
 ***********************************************************
 ***********************************************************
 **************DO NOT CHANGE THIS INTERFACE!!!**************
 ***********************************************************
 ******** EXCEPTION: TO ADD JAVADOC STYLE COMMENTS *********
 ******************TO THE PUBLIC METHODS********************
 ***********************************************************
 ***********************************************************
 */


public interface LogicProblems {
  //DO NOT CHANGE THE METHOD SIGNATURES BELOW

  public Double average(int[] scores);

  public int lastWordLength(String text);

  public BigDecimal distinctLadderPaths(int rungs);

  public List<List<String>> groupStrings(String[] strs);
}