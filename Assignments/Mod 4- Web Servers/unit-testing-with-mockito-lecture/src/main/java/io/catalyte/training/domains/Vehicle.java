package io.catalyte.training.domains;

import static io.catalyte.training.constants.StringConstants.REQUIRED_FIELD;
import static io.catalyte.training.constants.StringConstants.VEHICLE_COLLECTION;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = VEHICLE_COLLECTION)
public class Vehicle {

  @Id
  private String id;
  @NotBlank(message = "Type" + REQUIRED_FIELD)
  private String type;
  @NotBlank(message = "Make" + REQUIRED_FIELD)
  private String make;
  @NotBlank(message = "Model" + REQUIRED_FIELD)
  private String model;
  @NotNull(message = "Year" + REQUIRED_FIELD)
  private int year;

  public Vehicle() {
  }

  public Vehicle(String type, String make, String model, int year) {
    this.type = type;
    this.make = make;
    this.model = model;
    this.year = year;
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", released=" + year +
        '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
}
