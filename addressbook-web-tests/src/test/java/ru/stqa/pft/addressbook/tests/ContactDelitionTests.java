package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

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
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().deleteContact(deletedContact);
    Contacts after = app.contact().all();
    Assert.assertEquals(after.size(), before.size()-1);
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before. without(deletedContact)));


  }
  }





