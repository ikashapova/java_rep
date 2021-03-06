package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private  String firstname;
  private  String lastname;
  private  String address;
  private  String phon;
  private  String email;
  private  String homePhone;
  private  String mobilePhone;
  private  String workPhone;
  private  String allPhones;

  public String getFirstname() {
    return firstname;
  }
  public String getLastname() {
    return lastname;
  }
  public String getAddress() { return address; }
  public String getPhon() {
    return phon;
  }
  public String getEmail() {
    return email;
  }
  public String getHomePhone() {
    return homePhone;
  }
  public String getMobilePhone() {
    return mobilePhone;
  }
  public String getWorkPhone() {
    return workPhone;
  }
  public int  getId() {return id; }
  public String getAllPhones() {
    return allPhones;
  }


  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this; }



  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firstname, lastname);
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this; }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;}

  public ContactData withAddress(String address) {
    this.address = address;
    return this;}

  public ContactData withPhon(String phon) {
    this.phon = phon;
    return this;}

  public ContactData withId(int id) {
    this.id = id;
    return this;}
  public ContactData withEmail(String email) {
    this.email = email;
    return this;}
    public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;}
  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;}
  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;}


  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }


/*  public void setId(int max) {
  }*/
}
