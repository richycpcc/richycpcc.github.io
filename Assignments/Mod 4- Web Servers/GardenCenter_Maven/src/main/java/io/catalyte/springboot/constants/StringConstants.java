package io.catalyte.springboot.constants;

public class StringConstants {
    public static final String CONTEXT_USERS = "/users";
    public static final String CONTEXT_CUSTOMERS = "/customers";
    public static final String CONTEXT_PRODUCTS = "/products";
    public static final String CONTEXT_ORDERS = "/orders";
    public static final String SERVICE_UNAVAILABLE = "The database is not running, service is unavailable at the moment";
    public static final String UNEXPECTED_SERVER_ERROR = "An unexpected server error has occurred";
    public static final String NOT_FOUND = "Not Found";
    public static final String BAD_DATA = "Bad Data";
    public static final String SERVER_ERROR = "Server Error";
    public static final String MESSAGE_OK = "OK";
    public static final String UNEXPECTED_ERROR = "Unexpected Server Error";
    public static final String VALIDATION_ERROR = "Validation Error";
    public static final String CONTEXT_PETS = "/pets";
    public static final String CONTEXT_VACCINATIONS = "/Vaccinations";

    public static final String REQUIRED_FIELD = " is a required field";
    public static final String ID_NOT_FOUND = "You attempted an operation on an id that does not exist in the database";
    public static final String LOGGER_REQUEST_RECEIVED = " Get request received for: ";
    public static final String LOGGER_REQUEST_BY_BREED_RECEIVED = " Get request received for breed: ";
    public static final String LOGGER_POST_REQUEST_RECEIVED = " POST request received";
    public static final String LOGGER_PUT_REQUEST_RECEIVED = " PUT request received for id: ";
    public static final String LOGGER_DELETE_REQUEST_RECEIVED = " Delete request received for id: ";
    public static final String EMAIL_CONFLICT = "The email address is already in use";
    public static final String BAD_REQUEST_EMAIL = "Email has already been used: ";
    public static final String BAD_REQUEST = "Request is bad: ";
    public static final String BAD_REQUEST_PASSWORD = "The password must have at least 8 characters";
    public static final String BAD_REQUEST_ID = "The id must match id of path parameter";
    public static final String BAD_REQUEST_STATE = "The state must be valid 2 letter US state abbreviation";
    public static final String BAD_REQUEST_ZIPCODE = "The zip code format is XXXXX or XXXXX-XXXX";
    public static final String SKU_CONFLICT = "The sku is already in use";
    public static final String BAD_REQUEST_PRICE = "The price must have exactly 2 decimal places";
    public static final String BAD_REQUEST_ORDER_TOTAL = "The order total must have 2 decimal places";
    public static final String BAD_REQUEST_CUSTOMER_NOT_FOUND = "The customer does not exist in the database";

}
