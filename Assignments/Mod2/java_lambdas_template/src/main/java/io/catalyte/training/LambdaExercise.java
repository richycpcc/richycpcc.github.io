package io.catalyte.training;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.IntSummaryStatistics;

public class LambdaExercise {

  /**
   * Takes a List of strings and displays each one to the console.
   *
   * @param words the List of Strings to be displayed.
   */
  public void displayList(List<String> words) {
      words.forEach((n) -> System.out.println(n));
  }

  /**
   * Accepts a List of Integers and displays the number in the console if it is an even number that
   * is below 100.
   *
   * @param numbers the List of Strings to be displayed.
   */
  public void displayIntegers(List<Integer> numbers) {
    numbers.forEach(number->
    {
      if (number % 2 == 0 && number<100)
      {
        System.out.println(number);
      }
    });
  }

  /**
   * Sums the given List of Integers
   *
   * @param numbers the List of Integers to be summed.
   * @return the sum as a primitive integer.
   */
  public int sumIntegers(List<Integer> numbers) {
    int sum = 0;
    sum = numbers.stream()
            .mapToInt(i->i).sum();

    return sum;

  }

  /**
   * Finds the average value for the given array of primitive integers.
   *
   * @param ints the array of primitive integers
   * @return the average given as a Double
   */
  public Double averageInts(int[] ints) {
    //IntSummaryStatistics avg = ints.stream().mapToInt((a) -> a).summaryStatistics();
     //return avg.getAverage();

    double average = Arrays.stream(ints).asDoubleStream().average().getAsDouble();


    return average;
  }

  /**
   * Filters a given list of usernames by removing any that match the given set of customer names.
   *
   * @param users     the List of users to be filtered.
   * @param customers the Set of customer names to be removed from the list of users.
   * @return the filtered list of users.
   */
  public List<String> filterList(Set<String> customers, List<String> users) {
    users.removeAll(customers);
    return users;

  }

  /**
   * Sorts an array of Strings so that words that contain the letter 'e' appear before all the other
   * words.
   *
   * @param words the array of strings to be sorted.
   * @return a sorted array of Strings.
   */
  public String[] sortByLetterE(String[] words) {
    Arrays.sort(words,Comparator.comparingInt(word -> (word.toLowerCase().contains("e")?0 : 1)));

    return words;


  }

  /**
   * Takes an array of Strings and capitalizes the first letter of each word.
   *
   * @param words the array of strings to be capitalized.
   * @return a List of capitalized words.
   */
  public List<String> capitalizeAllWords(ArrayList<String> words) {

    List<String> collect = words.stream()
            .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
            .collect(Collectors.toList());

    return collect;


  }

  /**
   * Takes an array of Strings and filters it with the given Predicate.
   *
   * @param words     the List of words to be filtered.
   * @param predicate the predicate used to evaluate the given list of words
   * @return a filtered List
   */
  public List<String> filterWords(ArrayList<String> words, Predicate<String> predicate) {

    List<String> newList = words.stream()
            .filter(predicate)
            .collect(Collectors.toList());

    return newList;

  }

  /**
   * Takes a list of temperatures as ints and returns the minimum and maximum values.
   *
   * @param t the List of temperatures to be summarized.
   * @return a HashMap containing the minimum and maximum temperatures.
   */
  public HashMap<String, Integer> summarizeWeatherData(List<Integer> t) {
    // create variables for min and max temperature
    int minList = Collections.min(t);
    int maxList = Collections.max(t);

    //create HashMap
    HashMap<String, Integer> temperatureHashMap = new HashMap<>();

    //add values to HashMap
    temperatureHashMap.put("Minimum",minList);
    temperatureHashMap.put("Maximum",maxList);

    return temperatureHashMap;

  }

}
