package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static ru.stqa.pft.addressbook.tests.TestBase.app;

public class ContactAddressEmailTests extends TestBase{

  @Test
  public void testAddressEmailContact() {
    app.goTo().gotoContacts();
    ContactData contact = app.contact().all().iterator().next();


  }
}
