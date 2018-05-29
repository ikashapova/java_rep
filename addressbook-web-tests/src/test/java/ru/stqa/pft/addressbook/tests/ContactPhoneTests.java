package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    app.contact().contacts();
    if (app.group().all().size() == 0) {
      app.contact().createContact(new ContactData().withFirstname("First Name").withLastname("Last Name").withAddress("Russia").withPhon("79999999999999999").withEmail("232@kl.ru"));
    }
    app.contact().initContactModification();
  }

  @Test
  public void testContactPhones() {
    app.goTo().gotoContacts();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFormEditForm(contact);
    ContactData infoFormEditFormAddress = app.contact().infoFormEditFormAddress(contact);
    ContactData infoFormEditFormEmail = app.contact().infoFormEditFormEmail(contact);
    MatcherAssert.assertThat(contact.getAllPhones(), CoreMatchers.equalTo(mergePhones(contactInfoFormEditForm)));
    MatcherAssert.assertThat(contact.getAddress(),CoreMatchers.equalTo(infoFormEditFormAddress.getAddress()));
    MatcherAssert.assertThat(contact.getEmail(),CoreMatchers.equalTo(infoFormEditFormEmail.getAddress()));


  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
