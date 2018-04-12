package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {

        app.gotoAddContact();
        app.fillContactForm(new ContactData("First Name", "Last Name", "Russia", "79999999999999999", "232@kl.ru"));
        app.submitContactCreation();
        app.gotoContacts();
    }


}
