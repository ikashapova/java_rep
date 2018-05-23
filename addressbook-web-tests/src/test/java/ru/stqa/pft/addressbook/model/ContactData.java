package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String phon;
  private final String email;

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstname, lastname);
  }

  public ContactData(String firstname, String lastname, String address, String phon, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.phon = phon;
    this.email = email;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhon() {
    return phon;
  }

  public String getEmail() {
    return email;
  }


  public int getId() {return 0; }

  public void setId(int max) {
  }
}
