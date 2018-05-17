package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase  {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
      type(By.name("firstname"),contactData.getFirstname());
      type(By.name("lastname"),contactData.getLastname());
      type(By.name("address"),contactData.getAddress());
      type(By.name("home"),contactData.getPhon());
      type(By.name("email"),contactData.getEmail());
        }



  public void gotoAddContact() {
      click(By.linkText("add new"));
  }
  public void gotoContacts() {
    click(By.linkText("home"));
  }
  public void selectContact() {
    click(By.name("selected[]"));
  }
  public void initContactModification() {click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));  }
  public void deleteSelectedContatcs() {
    click(By.name("delete"));
  }
  public void contactModification() {click(By.xpath("//div[@id='content']/form[1]/input[22]"));}
  public void deleteContact() {click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));}
  public void closedDelete() {wd.switchTo().alert().accept();}

  public void createContact(ContactData contactData) {
    gotoAddContact();
    fillContactForm(new ContactData("First Name", "Last Name", "Russia", "79999999999999999", "232@kl.ru"));
    submitContactCreation();
    gotoContacts();
  }

  public boolean isThereAContact() {return isElementPresent (By.name("selected[]"));}
}

