package io.catalyte.training;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

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
  public BigDecimal getDiscount(BigDecimal unitPrice, int unitAmount) {
  /*if (unitTotal > 99 )
  {
    discount = totalPrice * 0.15;
  }
  else if (unitTotal >49)
  {
    discount = totalPrice * 0.10;
  }
  else
  {
    discount =totalPrice *0;
  }
    return new BigDecimal("-999");
  }
*/
  /**
   * This method takes an int representing a percentile score and should return the appropriate
   * letter grade. If the score is above 90, return 'A'; if the score is between 80 and 89, return
   * 'B'; if the score is between 70 and 79, return 'C'; if the score is between 60 and 69, return
   * 'D'; if the score is below 60, return 'F'.
   */
  public char getGrade(int score) {
    if (score >= 90)
    {
      return "A";
    }
    else if (score>=80 && score <= 89)
    {
      return "B";
    }
    else if (score>=70 && score <= 79)
    {
      return "C";
    }
    else if (score>=60 && score <= 69)
    {
      return "D";
    }
    else
    {
      return "F";
    } //end if

    return ' ';
  }

  /**
   * This method should take an ArrayList of strings, remove all the elements in the array
   * containing an even number of letters, and then return the result. For example, if given an
   * array of "Cat", "Dog", "Bird", the method should return an array containing only "Cat" and
   * "Dog".
   */
  public ArrayList<String> removeEvenLength(ArrayList<String> a) {
    for (String item : a)
    {
      if (item.size() % 2 == 0)
      {
        a.remove(item);
      }
    }
    return null;
  }


  /**
   * This method should take an double array, a, and return a new array containing the square of
   * each element in a.
   */
  public double[] powerArray(double[] a) {
    for (double item : a)
    {
      this.item = Math.pow(item,2);
    }

    return a;
  }


  /**
   * This method should take an int array, a, and return the index of the element with the greatest
   * value.
   */
  public int indexOfMax(int[] a) {
    int greatestValue = 0;
    for (int item : a)
    {
      if (item > greatestValue)
      {
        greatestValue = item;
      } // end if
    } // end for

    return greatestValue;
  } //end method


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
  } //end method


  /**
   * A word is "abecedarian" if its letters appear in alphabetical order--the word 'biopsy' for
   * example. This method should take String s and return true if it is abecedarian.
   */
  public boolean isAbecedarian(String s) {
    for (int i = 0; i < s.length(); i++)
    {
      if (s.charAt(i) <= input.charAt(i+1))
      {
        return true;
      } // end if
    } //end for

    return false;
  }//end method

  /**
   * This method should take 2 strings and return true if they are anagrams of each other. For
   * example, "stop" is an anagram for "pots".
   */
  public boolean areAnagrams(String s1, String s2) {
    if (s1.length() != s2.length())
    {
      return false;
    } //end if

    char[] cArray1 = s1.toCharArray();
    char[] cArray2 = s2.toCharArray();
    Arrays.sort(cArray1);
    Arrays.sort(cArray2);

    for (int i = 0; i < s1.length; i++)
    {
      if (cArray[i] != cArray[i])
      {
        return false;
      } //end if
      return true;
    } // end for
  } // end method

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
    return unique.length();
  } //end method

  /**
   * This method should take a string and return true if it is a palindrome, i.e. it is spelled the
   * same forwards and backwards. For example, the words "racecar" and "madam" are palindromes.
   */
  public boolean isPalindrome(String s)
  {
  String reverse = "";
  boolean answer = false;
  input = s.toLowerCase();

  for (int i =input.length() - 1; i >= 0; i--)
  {
    reverse = reverse + input.charAt(i);
  }

  if (input.equals(reverse))
  {
    answer = true;
  }
  return answer;

  }

  /**
   * This method should take a string and return a HashMap which is a map of characters to a list of
   * their indices in a string (i.e., which characters occur where in a string). For example for the
   * string "Hello World", the map would look something like: d=[9], o=[4, 6], r=[7], W=[5], H=[0],
   * l=[2, 3, 8], e=[1].
   */
  public HashMap<String, ArrayList<Integer>> concordanceForString(String s)
  {
    Map<Integer, String> hashMap = new HashMap<Integer, String>();
    hashMap.put(Integer, s);
    return null;

  }

}