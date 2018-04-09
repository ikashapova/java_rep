package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testsContactCreation() {

        gotoAddContact();
        fillContactForm(new ContactData("First Name", "Last Name", "Russia", "79999999999999999", "232@kl.ru"));
        submitContactCreation();
        gotoContacts();
    }


}
