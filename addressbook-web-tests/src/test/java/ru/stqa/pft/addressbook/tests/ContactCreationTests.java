package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {


    @Test
    public void testsContactCreation() {

        app.contact().contacts();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("First Name").withLastname("Last Name").withAddress("Russia").withPhon("79999999999999999").withEmail("232@kl.ru");
        app.contact().createContact(contact);
        app.contact().contacts();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size()+1);
        contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);



    }


}
