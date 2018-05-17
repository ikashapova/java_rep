package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDelitionTests extends TestBase {
  @Test
  public void testContactDelition(){
    app.getContactHelper().gotoContacts();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("First Name", null, "Russia", "79999999999999999", "232@kl.ru")); }
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteContact();
    app.getContactHelper().closedDelete();
    }

  }

