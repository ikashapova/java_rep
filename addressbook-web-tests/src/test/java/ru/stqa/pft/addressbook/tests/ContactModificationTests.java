package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
@Test
  public void testContactModification () {
  app.getContactHelper().gotoContacts();
  List<ContactData> before = app.getContactHelper().getContactList();
  if (! app.getContactHelper().isThereAContact())
  { app.getContactHelper().createContact(new ContactData("First Name", null, "Russia", "79999999999999999", "232@kl.ru")); }app.getContactHelper().initContactModification();
  ContactData contact = new ContactData("First Name", "Last Name", "Franch", "79999999999999999", "232@kl.ru");
  app.getContactHelper().fillContactForm(contact);
  app.getContactHelper().contactModification();
  app.getNavigationHelper().gotoContacts();
  List<ContactData> after = app.getContactHelper().getContactList();
  Assert.assertEquals(after.size(), before.size());
  before.remove(before.size()-1);
  int max = 0;
  for (ContactData g: after) {
    if (g.getId()>max){
      max = g.getId();
    }
  }
  contact.setId(max);
  before.add(contact);
  Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before, after);


}
}
