/*
* @Author: Richy Phongsavath
* @Version: 1.0
* @Date: 12/12/22
* @Class: CO-CP-Alpha1
 */

package io.catalyte.training;

import java.math.BigDecimal;
import java.util.List;
import java.util.*;

public class LogicProblemsImpl implements LogicProblems {
  //TODO: Implement all requirements as defined in the project description.


    @Override
    public Double average(int[] scores)
    {
        double sum = 0;
        double average = 0;
        int arrayLength = scores.length;

        if (arrayLength == 0)
        {
            return average;
        }

        for (int score : scores) {
            //if statement checks if score is less than 0
            if (score < 0)
            {
                //throw Arithmetic exception if not positive number. https://www.javatpoint.com/throw-keyword
                throw new ArithmeticException("Scores must be positive");
            }
            else
            {
                //add numbers in array to sum
                sum = sum + score;
            } //end if
        }// end for

        //calculate average
        average = sum / scores.length;

        return average;
    }
    /*
    double average = Arrays.stream(scores).asDoubleStream().average().getAsDouble();
    return average;
    System.out.println(average);
    */
    @Override
    public int lastWordLength(String text) {
        int lastWordCount = 0;
        boolean emptyString =text.trim().isEmpty();

        if ((text.length() == 0) && (emptyString))
        //(x.length() == 0)
        {
            //throw Illegal Argument Exception if trimmed string is 0;
            throw new IllegalArgumentException("Input must not be an empty String");
        }

        for (int i = 0;i < text.length();i++)
        {
            if (text.charAt(i) == ' ')
            {
                lastWordCount = 0;
            }
            else
            {
                lastWordCount++;
            } // end if
        }// end for

        return lastWordCount;
    }

    @Override
    public BigDecimal distinctLadderPaths(int rungs)
    {
        if (rungs == 0 || rungs == 1)
        {
            return BigDecimal.valueOf(rungs);
        }// end if

        if (rungs < 0)
        {
            throw new IllegalArgumentException("Ladders can't have negative rungs");
        }// end if

        return (distinctLadderPaths(rungs-1).add( distinctLadderPaths(rungs-2)));


        /*
        BigDecimal rung = BigDecimal.valueOf(rungs);
        BigDecimal[] fibonacciCashe = new BigDecimal [rungs];
        Arrays.fill(fibonacciCashe,(distinctLadderPaths(rungs +1))); //(rung.add.valueOf(1));
        if (rungs == 1 || rungs ==0)
        {
            return BigDecimal.valueOf(rungs);
        }
        if (rungs < 0)
        {
            throw new IllegalArgumentException("Ladders can't have negative rungs");
        }// end if

        if (fibonacciCashe[rungs].compareTo(rung)>0)
        {
            return fibonacciCashe[rungs];
        }//end if

        //return (distinctLadderPaths(rungs-1).add( distinctLadderPaths(rungs-2)));
        BigDecimal nthFibonacciNumber = (distinctLadderPaths(rungs-1).add( distinctLadderPaths(rungs-2)));
        fibonacciCashe [rungs] = nthFibonacciNumber;
        return nthFibonacciNumber;
       // return null;

         */
    }

    @Override
    public List<List<String>> groupStrings(String[] strs)
    {
        /*
    Map<String,List<String>> wordsbyFirstAndLast = strs
            .stream()
            .collect(
                    Collectors.groupingBy(word::);
            )

         */
    /*
        List<String> parentContainer = new ArrayList<>();
        //Loop through String array
        for (String word : strs)
        {
         //Convert "word" String  to lowercase and char array
         char[] characters = word.toLowerCase().toCharArray();

         //Get the first and last char
         char firstChar = characters[0];
         char lastChar = characters[characters.length - 1];


         //compare first char; if not match => create new list
            for (List<String>subContainerLists : parentContainer)
            {
                for (String index :subContainerLists)
                {
                    List <String> subContainer = new ArrayList<>();
                    if (firstChar != index.charAt(0))
                    {
                        subContainer.add(word);
                    }
                    else if (lastChar != index.charAt(index.length()-1))
                    {
                        subContainer.add(word);
                    }
                    else
                    {
                        index.add(word);
                    }
                }
            }

            //compare last char; if not match => create new list
            //add to list

     }

     */
        /* HashMap
        //create Hashmap to store key and String lists
        Map<String,List<String>> map = new HashMap<>();

        //Loop through String array
        for (String word : strs)
        {

            //Convert "word" String  to lowercase and char array
            char[] characters = word.toLowerCase().toCharArray();

            //Get the first and last char
            char firstChar = characters[0];
            char lastChar = characters[characters.length - 1];

            //Convert char to String
            String firstLetter = Character.toString(firstChar);
            String lastLetter = Character.toString(lastChar);
            //Generate key
            String key = firstLetter + lastLetter;

            //ArrayList to store word for new key
            List<String> container = new ArrayList<>();

            //checks to see duplicate key, if no key => add key to ArrayList
            if (!map.containsKey(key))
            {
                List<String> newContainer = new ArrayList<>();// test to see if this is this needed
                map.put(key, newContainer);
            } // end if

            //targets key, add word to ArrayList
            map.get(key).add(word);
            //ArrayList to store word for new key


        } // end for
        */

        return null;
    }

}
