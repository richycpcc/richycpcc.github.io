/**
* @Author: Richy Phongsavath
* @Version: 1.0
* @Date: 12/12/22
* @Class: CO-CP-Alpha1
 */

package io.catalyte.training;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Class for set of Logic Problem Methods
 */
public class LogicProblemsImpl implements LogicProblems {
  //TODO: Implement all requirements as defined in the project description.


    /**
     * Method calculates the average of a given average to the 2nd decimal place.
     * @param scores list of integers
     * @return average of list of scores to the 2nd decimal place.
     */
    @Override
    public Double average(int[] scores)
    {
        double sum = 0;
        double average = 0.00;
        int arrayLength = scores.length;
        double roundedAverage;

        //if array length of given array equals 0, then return the current average value (0).
        if (arrayLength == 0)
        {
            return average;
        }
        else
        {
            // loops through the scores of the given array
            for (int score : scores) {

                //if statement checks if score is less than 0
                if (score < 0) {
                    //throw Arithmetic exception if not positive number. https://www.javatpoint.com/throw-keyword
                    throw new ArithmeticException("scores must be positive");
                } else {
                    //add numbers in array to sum
                    sum = sum + score;
                } //end if
            }// end for

            //calculate average
            average = sum / scores.length;

            //convert average to 2 decimal spaces
            roundedAverage = Math.round(average * 100) / 100.0;
        }
        return roundedAverage;
    }

    /**
     * Method gets the count of the last word of a string
     * @param text String
     * @return count of last word.
     */
    @Override
    public int lastWordLength(String text) {
        int lastWordCount = 0;

        boolean emptyString =text.trim().isEmpty();
        //
        //checks to see if String is empty
        if (text.length() == 0 && emptyString)
        {
            //throw Illegal Argument Exception if trimmed string is 0;
            throw new IllegalArgumentException("input must not be an empty string");
        } // end if
        text = text.trim();
        //loops through text.
        for (int i = 0;i < text.length();i++)
        {
            //when loop reaches an empty space => counter resets to 0.
            if (text.charAt(i) == ' ')
            {
                lastWordCount = 0;
            }
            //after last empty space is reached => count begins.
            else
            {
                lastWordCount++;
            } // end if
        }// end for

        return lastWordCount;
    }

    /**
     * Method finds number of combination for climbing 1 to 2 rungs of a given ladder.
     * @param rungs number of rungs in latter
     * @return number of combination of length of ladder.
     */
    @Override
    public BigDecimal distinctLadderPaths(int rungs)
    {
        // 0's and 1's only have a single value and return same value
        if (rungs == 0 || rungs == 1)
        {
           return BigDecimal.valueOf(rungs);
        }
        else if (rungs < 0) // checks for negative integer and throw exception if true.
        {
            throw new IllegalArgumentException("ladders can't have negative rungs");
        }
        else
        {
            //array to store results of each iteration.
            BigInteger[] f = new BigInteger[(rungs + 1)];

            //since 0 and 1 rungs return own value, loop is counted as 1
            f[0] = BigInteger.valueOf(1);
            f[1] = BigInteger.valueOf(1);

            //loops through number of rungs starting at 2
            for (int i = 2; i <= rungs; i++)
            {
                f[i] = f[i - 1].add(f[i - 2]);
            } // end for

            //converts Big Integer of the result sequence to Big Decimal based on the number of rungs given.
            BigDecimal fBigDecimal = new BigDecimal(f[rungs]);

            return fBigDecimal;
        } // end if
    }

    /**
     * method groups a list of string by the first and last characters
     * @param strs array of strings
     * @return a list containing a list of strings
     */
    @Override
    public List<List<String>> groupStrings(String[] strs)
    {

        //create Hashmap to store key and String lists
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        //Loop through String array
        for (String word : strs)
        {
            //takes out white space and lowercase letters of string
            String x = word.trim().toLowerCase();

            //Convert "word" String to char array
            char[] characters = x.toCharArray();

            //throw exception if Char Array of String is blank;
            if(x.length() == 0)
            {
                throw new IllegalArgumentException("strings must not be empty");
            }

            //Get the first and last char
            char firstChar = characters[0];
            char lastChar = characters[characters.length - 1];

            //Convert char to String
            String firstLetter = Character.toString(firstChar);
            String lastLetter = Character.toString(lastChar);

            //Generate key
            String key = firstLetter + lastLetter;

            //checks to see duplicate key, if no key => create new ArrayList and add key to ArrayList
            if (!map.containsKey(key))
            {
                ArrayList<String> newContainer = new ArrayList<>();
                map.put(key, newContainer);
            } // end if

            //targets key, add word to ArrayList
            map.get(key).add(x);

        }//end for
        //Converts the values of the hashmap to a collection
        Collection<ArrayList<String>> newValue = map.values();

        //creates List<List<String from converted value
        List<List<String>> listOfNewValues = new ArrayList<>(newValue);

        new ArrayList<>(map.values());

        return listOfNewValues;
    }

}
