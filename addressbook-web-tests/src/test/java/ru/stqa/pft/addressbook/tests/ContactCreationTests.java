package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void testsContactCreation() {

        app.contact().contacts();
        app.contact().initContactModification();
        app.contact().fillContactForm(new ContactData().withFirstname("test_name").withLastname("test_name2").withAddress("address2"));
        app.contact().submitContactCreation();
        app.contact().contacts();







    }


}
