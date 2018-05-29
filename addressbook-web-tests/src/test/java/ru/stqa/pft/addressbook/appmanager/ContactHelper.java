package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getPhon());
    type(By.name("email"), contactData.getEmail());
  }


  public void gotoAddContact() {
    click(By.linkText("add new"));
  }

  public void contacts() {click(By.linkText("home"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  //public void initContactModificationById(int id) {
    //wd.findElement(By.cssSelector("input[value='"+ id + "']")).click(); }

  public void deleteSelectedContatcs() {
    click(By.name("delete"));
  }

  public void contactModification() {click(By.xpath("//div[@id='content']/form[1]/input[22]")); }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closedDelete() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contactData) {
    gotoAddContact();
    fillContactForm(new ContactData().withFirstname("First Name"). withLastname("Last Name").withAddress("Russia").withPhon("79999999999999999").withEmail("232@kl.ru"));
    submitContactCreation();
    contacts();
  }

  public void modifyContact(ContactData contact) {
    initContactModification();
    fillContactForm(contact);
    contactModification();
    contacts();
  }
  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id + "']")).click(); }


  public boolean isThereAContact() {return isElementPresent(By.name("selected[]"));  }

  public int getContactCount() {return wd.findElements (By.name("selected[]")).size(); }
  public void deleteContact(int index) {
    selectContact(index);
    deleteContact();
    closedDelete();
    contacts();
  }

  public void deleteContact(ContactData contact) {
    selectContactById(contact.getId());
    deleteContact();
    closedDelete();
    contacts();
  }



  public List<ContactData> listContact() {List<ContactData> contacts = new ArrayList<ContactData>();
    List <WebElement> rows = wd.findElements(By.name("entry")); //найти строки с информацией о контактах
    for (WebElement element : rows){
      List<WebElement> cells = element.findElements(By.tagName("td"));
      cells.get(2);
      cells.get(1);
      String First_name = cells.get(2).getText();
      String Last_name = cells.get(1).getText();
      ContactData contact = new ContactData().withFirstname("First name").withLastname("Last name");
      contacts.add(contact); }
    return contacts;

  }


  public Set<ContactData> all() {
    Set<ContactData> contacts = new HashSet<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry")); //найти строки с информацией о контактах
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      String First_name = cells.get(2).getText();
      String Last_name = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFirstname(First_name).withLastname(Last_name).withAllPhones(allPhones));
    }

     return contacts;

  }

  public ContactData infoFormEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withFirstname(firstname)
            .withLastname(lastname)
            .withHomePhone(home)
            .withMobilePhone(mobile)
            .withWorkPhone(work)
            .withAddress(address)
            .withEmail(email);

    }

    public void initContactModificationById(int id){

    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../.../td[8]/a",id))).click();

    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

    }

  public ContactData infoFormEditFormEmail(ContactData contact) {
    initContactModificationByEmail(contact.getId());
    String email = wd.findElement(By.name("email")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withEmail(email);

  }

  public void initContactModificationByEmail (int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

 }


  public ContactData infoFormEditFormAddress(ContactData contact) {
    initContactModificationByEmail(contact.getId());
    String email = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withEmail(email);

  }

  public void initContactModificationByAddress (int id){
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();

  }

  }

