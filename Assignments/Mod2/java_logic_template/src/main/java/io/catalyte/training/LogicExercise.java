package io.catalyte.training;
import java.math.*;
//import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


/**
 * Contains multiple common logic exercises.
 */
public class LogicExercise {

  /**
   * Takes a BigDecimal for the unit price and an int for number of units sold and returns a
   * discounted sales total based on the quantity sold: if more than 99 units are sold, apply a 15%
   * discount to the total price; if more than 49 units are sold, apply a 10% discount 10% to the
   * total price; if less than 50 units are sold, do not apply a discount to the price. For example,
   * if the unit price was 1.00 and the quantity sold was 100, the method should return 85.00 for
   * the total sales amount.
   */
  public BigDecimal getDiscount(BigDecimal unitPrice, int unitAmount)
  {
  BigDecimal discount15 = new BigDecimal(0.85);
  BigDecimal discount10 = new BigDecimal(0.90);
  BigDecimal bigUnitAmount = BigDecimal.valueOf(unitAmount);
  BigDecimal subTotal = bigUnitAmount.multiply(unitPrice);
  MathContext m = new MathContext(5);

    if (unitAmount > 99 )
    {
      BigDecimal grandTotal15 = subTotal.multiply(discount15);
      return grandTotal15.round(m);
    }
    else if (unitAmount >49)
    {
      BigDecimal grandTotal10 = subTotal.multiply(discount10);
      return grandTotal10.round(m);
    }
    else
    {
      return subTotal.round(m);
    }

    //return new BigDecimal("-999");
  }

  /**
   * This method takes an int representing a percentile score and should return the appropriate
   * letter grade. If the score is above 90, return 'A'; if the score is between 80 and 89, return
   * 'B'; if the score is between 70 and 79, return 'C'; if the score is between 60 and 69, return
   * 'D'; if the score is below 60, return 'F'.
   */
  public char getGrade(int score) {
    if (score >= 90) {
      return 'A';
    } else if (score >= 80 && score <= 89) {
      return 'B';
    } else if (score >= 70 && score <= 79) {
      return 'C';
    } else if (score >= 60 && score <= 69) {
      return 'D';
    } else {
      return 'F';
    } //end if
    //return ' ';
  }// end method

  /**
   * This method should take an ArrayList of strings, remove all the elements in the array
   * containing an even number of letters, and then return the result. For example, if given an
   * array of "Cat", "Dog", "Bird", the method should return an array containing only "Cat" and
   * "Dog".
   */
  public ArrayList<String> removeEvenLength(ArrayList<String> a) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i).length() % 2 == 0) {
        a.remove(i);
        i--;
      } // end if
    } // end for
    return a;
  }// end method


  /**
   * This method should take an double array, a, and return a new array containing the square of
   * each element in a.
   */
  public double[] powerArray(double[] a) {
    for (double item : a) {
      item = Math.pow(item, 2);
    } // end for
    return a;
  } // end method


  /**
   * This method should take an int array, a, and return the index of the element with the greatest
   * value.
   */
  public int indexOfMax(int[] a)
  {
  int greatestValue = a[0];
  int index = 0;

  if(a.length == 0)
  {
    return -1;
  }
  for(int i = 0; i < a.length; i++)
  {
    if (greatestValue < a[i])
    {
      greatestValue = a[i];
      index = i;
    } // end if
  } // end for
    return index;
  }
  /**
   * This method should take an ArrayList of Integers, a, and returns true if all elements in the
   * array are divisible by the given int, i.
   */
  public boolean isDivisibleBy(ArrayList<Integer> a, int i) {
    for (int item : a)
    {
      if( item % i != 0 )
      {
        return false;
      } // end if
    } //end for
    return true;

  }

  /**
   * A word is "abecedarian" if its letters appear in alphabetical order--the word 'biopsy' for
   * example. This method should take String s and return true if it is abecedarian.
   */
  public boolean isAbecedarian(String s) {
    for (int i = 0; i < s.length(); i++)
    {
      if (s.charAt(i) <= s.charAt(i+1))
      {
        return true;
      }
      else
      {
        return false;
      }
    } //end for
    return false;
  }

  /**
   * This method should take 2 strings and return true if they are anagrams of each other. For
   * example, "stop" is an anagram for "pots".
   */
  public boolean areAnagrams(String s1, String s2)
  {
    if (s1.length() != s2.length())
    {
      return false;
    } //end if

      s1 = s1.toLowerCase();
      s2 = s2.toLowerCase();
      char[] cArray1 = s1.toCharArray();
      char[] cArray2 = s2.toCharArray();
      Arrays.sort(cArray1);
      Arrays.sort(cArray2);

      return Arrays.equals(cArray1,cArray2);
  }
  /**
   * This method should take a String and return the number of unique characters. For example, if
   * the method is given "noon", it should return a value of 2.
   */
  public int countUniqueCharacters(String s)
  {
    ArrayList<Character> unique = new ArrayList<Character>();

    for(int i =0; i< s.length(); i++)
    {
      if (!unique.contains (s.charAt(i)))
      {
        unique.add(s.charAt(i));
      } //end if
    } // end for
    return unique.size();
    //return 0;

  }

  /**
   * This method should take a string and return true if it is a palindrome, i.e. it is spelled the
   * same forwards and backwards. For example, the words "racecar" and "madam" are palindromes.
   */
  public boolean isPalindrome(String s) {
    String reverse = "";
    boolean answer = false;
    s = s.toLowerCase();

    for (int i =s.length() - 1; i >= 0; i--)
    {
      reverse = reverse + s.charAt(i);
    }

    if (s.equals(reverse))
    {
      answer = true;
    }
    return answer;
    //return false;

  }

  /**
   * This method should take a string and return a HashMap which is a map of characters to a list of
   * their indices in a string (i.e., which characters occur where in a string). For example for the
   * string "Hello World", the map would look something like: d=[9], o=[4, 6], r=[7], W=[5], H=[0],
   * l=[2, 3, 8], e=[1].
   */
  public HashMap<String, ArrayList<Integer>> concordanceForString(String s) {

    HashMap <String, ArrayList<Integer>> characterMap = new HashMap <>();

    //loop through string for char
    for (int i = 0; i<s.length();i++)
    {
      //create list to store index of character
      ArrayList<Integer> intIndex = new ArrayList<>();

      //gets the character of the string
      Character storedChar = s.charAt(i);

      //check if character is already in HashMap
      if(characterMap.containsKey(storedChar.toString()))
      {
        //if character is duplicate, add to list index
        intIndex.addAll(characterMap.get(storedChar.toString()));
      }//end if

      //add character to map and list index
        intIndex.add(i);
        characterMap.put(storedChar.toString(), intIndex);

    }//end for

    //take out spaces
    //loop through string for char of String
    //add index to Hashmap
    //if repeat char, update index in Hashmap

    return characterMap;
  }

}