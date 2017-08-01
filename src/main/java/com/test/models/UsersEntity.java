package com.test.models;

import javax.persistence.*;

@Entity
@Table(name = "Users", schema = "CoffeeShopDatabase", catalog = "")
public class UsersEntity {
  private String userId;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String password;

  @Id
  @Column(name = "UserID", nullable = false, length = 20)
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "FirstName", nullable = false, length = 45)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "LastName", nullable = false, length = 45)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "Email", nullable = true, length = 45)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "PhoneNumber", nullable = true, length = 45)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Basic
  @Column(name = "Password", nullable = false, length = 45)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UsersEntity that = (UsersEntity) o;

    if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
    if (password != null ? !password.equals(that.password) : that.password != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = userId != null ? userId.hashCode() : 0;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }
}
