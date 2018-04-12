package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase  {

  public ContactHelper(FirefoxDriver wd) {
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
      type(By.name("home"),contactData.getEmail());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
        }

  public void gotoAddContact() {
      click(By.linkText("add new"));
  }
}
