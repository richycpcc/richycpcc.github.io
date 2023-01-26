package io.catalyte.training;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "department_code")
  private int departmentCode;

  @Column(name = "office_location")
  private String officeLocation;

  protected Employee() {
  }

  public Employee(String firstName, String lastName, int departmentCode, String officeLocation) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentCode = departmentCode;
    this.officeLocation = officeLocation;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getDepartmentCode() {
    return departmentCode;
  }

  public void setDepartmentCode(int departmentCode) {
    this.departmentCode = departmentCode;
  }

  public String getOfficeLocation() {
    return officeLocation;
  }

  public void setOfficeLocation(String officeLocation) {
    this.officeLocation = officeLocation;
  }

  @Override
  public String toString() {
    return "Employee [id="
        + id
        + ", firstName="
        + firstName
        + ", lastName="
        + lastName
        + ", departmentCode="
        + departmentCode
        + ", officeLocation="
        + officeLocation
        + "]";
  }
}
