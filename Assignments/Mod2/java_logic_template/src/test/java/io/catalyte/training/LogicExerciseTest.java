package io.catalyte.training;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LogicExerciseTest {

  LogicExercise exercise;

  @BeforeEach
  public void init() {

    exercise = new LogicExercise();

  }

  @Test
  public void getDiscountWorksReturns15PercentDiscountForMoreThan99Units() {

    int quantity = 100;

    BigDecimal unitPrice = new BigDecimal("10.00");

    BigDecimal result = exercise.getDiscount(unitPrice, quantity);

    assertEquals(new BigDecimal("850.00"), result,
        () -> "Wrong discount was given. Got: " + result);


  }

  @Test
  public void getDiscountWorksReturns10PercentDiscount() {

    int quantity = 50;

    BigDecimal unitPrice = new BigDecimal("10.00");

    BigDecimal result = exercise.getDiscount(unitPrice, quantity);

    assertEquals(new BigDecimal("450.00"), result,
        () -> "Wrong discount was given. Got: " + result);


  }


  @Test
  public void getDiscountReturnsActualPriceIfNoDiscount() {

    BigDecimal unitPrice = new BigDecimal("1.11");

    int quantity = 49;

    BigDecimal result = exercise.getDiscount(unitPrice, quantity);

    assertEquals(new BigDecimal("54.39"), result, () -> "Wrong discount was given. Got: " + result);


  }

  @Test
  public void getGradeReturnsA() {

    int input = 90;

    char result = exercise.getGrade(input);

    assertEquals('A', result, () -> "Wrong grade was given. Got: " + result);


  }

  @Test
  public void getGradeReturnsB() {

    int input = 89;

    char result = exercise.getGrade(input);

    assertEquals('B', result, () -> "Wrong grade was given. Got: " + result);


  }

  @Test
  public void getGradeReturnsC() {

    int input = 70;

    char result = exercise.getGrade(input);

    assertEquals('C', result, () -> "Wrong grade was given. Got: " + result);


  }

  @Test
  public void getGradeReturnsD() {

    int input = 60;

    char result = exercise.getGrade(input);

    assertEquals('D', result, () -> "Wrong grade was given. Got: " + result);


  }

  @Test
  public void getGradeReturnsF() {

    int input = 59;

    char result = exercise.getGrade(input);

    assertEquals('F', result, () -> "Wrong grade was given. Got: " + result);

  }

  @Test
  public void testPowerArray() {

    double[] input = {2.2, 3.3, 4, 5};

    double[] result = exercise.powerArray(input);

    assertArrayEquals(input, result, () -> "the arrays do not match");

  }

  @Test
  public void indexOfMaxHandlesPositiveArrays() {

    int[] input = {7, 91, 2, 45, 101, 6};

    int result = exercise.indexOfMax(input);

    assertEquals(4, result, () -> "The wrong element was returned. Expected: 4 Got: " + result);

  }

  @Test
  public void indexOfMaxHandlesNegativeArrays() {
    int[] input = {-10, -5, -100};

    int result = exercise.indexOfMax(input);

    assertEquals(1, result, () -> "The wrong element was returned. Expected: 1 Got: " + result);
  }

  @Test
  public void indexOfMaxHandlesEmptyArrays() {
    int[] input = {};

    int result = exercise.indexOfMax(input);

    assertEquals(-1, result, () -> "The wrong element was returned. Expected: -1 Got: " + result);
  }

  @Test
  public void testIsDivisibleBy() {

    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(6, 9, 12, 15));

    int divisor = 3;

    boolean result = exercise.isDivisibleBy(input, divisor);

    assertTrue(result, () -> "Array is not divisible by divisor 3.");

  }

  @Test
  public void testIsNotDivisibleBy() {

    ArrayList<Integer> input = new ArrayList<>(Arrays.asList(4, 7, 6, 97, 153));

    int divisor = 2;

    boolean result = exercise.isDivisibleBy(input, divisor);

    assertFalse(result, () -> "Array is not divisible by divisor 2.");


  }

  @Test
  public void testIsAbecedarian() {

    String input = "biopsy";

    boolean result = exercise.isAbecedarian(input);

    assertTrue(result, () -> "Input is abecedarian: " + input);


  }

  @Test
  public void testIsNotAbecedarian() {

    String input = "baby";

    boolean result = exercise.isAbecedarian(input);

    assertFalse(result, () -> "Input is not abecedarian: " + input);
  }

  @Test
  public void testAreAnagrams() {

    String input1 = "statue";

    String input2 = "astute";

    boolean result = exercise.areAnagrams(input1, input2);

    assertTrue(result, () -> "Inputs are anagrams" + input1 + "," + input2);


  }

  @Test
  public void areAnagramsReturnsFalseWithDifferentLengthStrings() {

    String input1 = "statu";

    String input2 = "astute";

    boolean result = exercise.areAnagrams(input1, input2);

    assertFalse(result, () -> "Inputs are not anagrams" + input1 + "," + input2);

  }

  @Test
  public void areAnagramsReturnsFalseWithDifferentCountsOfLetterOccurences() {

    String input1 = "aaab";

    String input2 = "abbb";

    boolean result = exercise.areAnagrams(input1, input2);

    assertFalse(result, () -> "Inputs are not anagrams" + input1 + "," + input2);
  }

  @Test
  public void testAreAnagramsWithCapitals() {

    String input1 = "Statue";

    String input2 = "Astute";

    boolean result = exercise.areAnagrams(input1, input2);

    assertTrue(result, "Inputs are anagrams" + input1 + "," + input2);

  }

  @Test
  public void testAreNotAnagrams() {

    String input1 = "elephant";

    String input2 = "eggplant";

    boolean result = exercise.areAnagrams(input1, input2);

    assertFalse(result, () -> "Inputs are not anagrams" + input1 + "," + input2);

  }

  @Test
  public void testCountUniqueCharacters() {

    String input1 = "engineering";

    int result = exercise.countUniqueCharacters(input1);

    assertEquals(5, result,
        () -> "Wrong number of unique characters found. Expected: 5. Got: " + result);

  }


  @Test
  public void testRemoveEvenLength() {

    ArrayList<String> input = new ArrayList<>(Arrays
        .asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"));

    ArrayList<String> expected = new ArrayList<>(
        Arrays.asList("one", "two", "three", "six", "seven", "eight", "ten"));

    ArrayList<String> result = exercise.removeEvenLength(input);

    assertIterableEquals(expected, result, () -> "Result does not have expected values");

  }

  @Test
  public void testIsPalindrome() {

    String input = "madam";

    boolean result = exercise.isPalindrome(input);

    assertTrue(result, () -> "Input was not recognized as a palindrome: " + input);

  }

  @Test
  public void isPalindromeReturnsTrueForSingleLetter() {
    String input = "a";

    boolean result = exercise.isPalindrome(input);

    assertTrue(result, () -> "Input was not recognized as a palindrome: " + input);
  }


  @Test
  public void testIsNotAPalindrome() {

    String input = "zoomzoom";

    boolean result = exercise.isPalindrome(input);

    assertFalse(result, () -> "Input was recognized as a palindrome: " + input);

  }

  @Test
  public void testConcordanceForGoodString() {

    HashMap<String, ArrayList<Integer>> expected = new HashMap<>();

    String input1 = "engineering";

    expected.put("e", new ArrayList<>(Arrays.asList(0, 5, 6)));

    expected.put("n", new ArrayList<>(Arrays.asList(1, 4, 9)));

    expected.put("g", new ArrayList<>(Arrays.asList(2, 10)));

    expected.put("i", new ArrayList<>(Arrays.asList(3, 8)));

    expected.put("r", new ArrayList<>(Arrays.asList(7)));

    HashMap<String, ArrayList<Integer>> result = exercise.concordanceForString(input1);

    Assertions.assertAll("The concordance does not match",
        () -> assertEquals(expected.size(), result.size()),
        () -> assertIterableEquals(expected.get("e"), result.get("e")),
        () -> assertIterableEquals(expected.get("n"), result.get("n"))
    );

  }

}

