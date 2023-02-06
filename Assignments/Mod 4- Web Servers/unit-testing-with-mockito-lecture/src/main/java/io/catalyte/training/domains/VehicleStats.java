package io.catalyte.training.domains;

import org.springframework.data.annotation.Transient;

/**
 * An object that extends Vehicle to add a field for the number of reviews for that vehicle.
 */
public class VehicleStats extends Vehicle {

  @Transient
  private int reviewNum;

  public VehicleStats(String id, String type, String make, String model, int year, int reviewNum) {
    super(type, make, model, year);
    this.setId(id);
    this.reviewNum = reviewNum;
  }

  public int getReviewNum() {
    return reviewNum;
  }

  public void setReviewNum(int reviewNum) {
    this.reviewNum = reviewNum;
  }
}
