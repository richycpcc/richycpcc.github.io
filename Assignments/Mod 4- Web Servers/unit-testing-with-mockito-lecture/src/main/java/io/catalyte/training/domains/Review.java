package io.catalyte.training.domains;

import static io.catalyte.training.constants.StringConstants.INVALID_POSITIVE;
import static io.catalyte.training.constants.StringConstants.REQUIRED_FIELD;
import static io.catalyte.training.constants.StringConstants.REVIEW_COLLECTION;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represents a review.
 */
@Document(collection = REVIEW_COLLECTION)
public class Review {

  @Id
  private String id;
  @NotBlank(message = "Title" + REQUIRED_FIELD)
  private String title;
  @NotBlank(message = "Description" + REQUIRED_FIELD)
  private String description;
  @Positive(message = "Rating" + INVALID_POSITIVE)
  @NotNull
  private int rating;
  @NotBlank(message = "Date" + REQUIRED_FIELD)
  private String date;
  @NotBlank(message = "Username" + REQUIRED_FIELD)
  private String username;
  @NotNull(message = "VehicleId" + REQUIRED_FIELD)
  private ObjectId vehicleId;

  public Review() {
  }

  public Review(String title, String description, int rating, String date, String username,
      String vehicleId) {
    this.title = title;
    this.description = description;
    this.rating = rating;
    this.date = date;
    this.username = username;
    this.vehicleId = new ObjectId(vehicleId);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getVehicleId() {
    String stringId = vehicleId.toString();
    return stringId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = new ObjectId(vehicleId);
  }

  @Override
  public String toString() {
    return "Review{" +
        "id='" + id + '\'' +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", rating=" + rating +
        ", date='" + date + '\'' +
        ", username='" + username + '\'' +
        ", vehicleId=" + vehicleId +
        '}';
  }
}

