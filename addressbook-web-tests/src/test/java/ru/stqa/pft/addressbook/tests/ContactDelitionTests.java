package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDelitionTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {

    app.contact().contacts();
    if (app.group().all().size()==0)
    { app.contact().createContact(new ContactData().withFirstname("First Name").withLastname("Last Name").withAddress("Russia").withPhon("79999999999999999").withEmail("232@kl.ru")); }app.contact().initContactModification();
  }

  @Test
  public void testContactDelition (){
    app.contact().contacts();
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().deleteContact(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);
    before.remove(deletedContact);
    Assert.assertEquals(before, after);

    }
  }





