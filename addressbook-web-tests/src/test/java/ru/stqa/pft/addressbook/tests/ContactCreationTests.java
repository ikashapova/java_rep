package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String line = reader.readLine();
        while (line != null){
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData().withLastname(split[0]).withFirstname(split[1]).withAddress(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }




    @Test(dataProvider = "validContacts")
    public void testsContactCreation() {

        app.contact().contacts();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withLastname("First Name").withFirstname("Last Name").withAddress("Russia");
        app.contact().createContact(contact);
        app.contact().contacts();
        Set<ContactData> after = app.contact().all();
        assertThat(after.size(), equalTo(before.size()+1));
      //  assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }
}
