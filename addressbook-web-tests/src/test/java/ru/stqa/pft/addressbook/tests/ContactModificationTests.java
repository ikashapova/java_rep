package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
@Test
  public void testContactModification () {
  app.getContactHelper().gotoContacts();
  if (! app.getContactHelper().isThereAContact()){
    app.getContactHelper().createContact(new ContactData("First Name", null, "Russia", "79999999999999999", "232@kl.ru")); }
  app.getContactHelper().initContactModification();
  app.getContactHelper().fillContactForm(new ContactData("First Name", "Last Name", "Franch", "79999999999999999", "232@kl.ru"));
  app.getContactHelper().contactModification();
  app.getNavigationHelper().gotoContacts();

}
}
