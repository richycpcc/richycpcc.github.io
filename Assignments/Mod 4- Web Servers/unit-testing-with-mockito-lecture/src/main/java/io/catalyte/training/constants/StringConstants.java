package io.catalyte.training.constants;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains all string constants used throughout the application.
 */
public class StringConstants {

  // General
  public static final String NOT_FOUND = "Not Found";
  public static final String BAD_REQUEST = "Bad Request";
  public static final String CONFLICT = "Conflict";
  public static final String SERVER_ERROR = "Server Error";
  public static final String SERVER_ERROR_MESSAGE = "An unexpected error occurred.";
  public static final String REQUIRED_FIELD = " is a required field.";
  public static final String INVALID_POSITIVE = " must be greater than 0.";

  // Review Domain
  public static final String REVIEW_COLLECTION = "reviews";

  // Vehicle Domain
  public static final String VEHICLE_COLLECTION = "vehicles";
  public static final Set<String> VEHICLE_FIELDS = new HashSet<>();

  static {
    VEHICLE_FIELDS.add("type");
    VEHICLE_FIELDS.add("make");
    VEHICLE_FIELDS.add("model");
    VEHICLE_FIELDS.add("year");
  }

}