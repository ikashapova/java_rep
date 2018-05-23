package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactDelitionTests extends TestBase {
  @Test
  public void testContactDelition(){
    app.getContactHelper().gotoContacts();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("First Name", null, "Russia", "79999999999999999", "232@kl.ru")); }
    List<ContactData> before = app.getContactHelper().getContactList();
    ContactData contact = new ContactData("First Name", "Last Name", "Franch", "79999999999999999", "232@kl.ru");
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteContact();
    app.getContactHelper().closedDelete();
    app.getContactHelper().gotoContacts();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(before.size()-1);
    for(int i=0; i<after.size();i++){
      Assert.assertEquals(before.get(i), after.get(i));
      before.add(contact);
      Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
      before.sort(byId);
      after.sort(byId);
      Assert.assertEquals(before, after);

    }

  }

  }

