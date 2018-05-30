package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validGroups(){
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
        list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
        list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
        return list.iterator();
    }


    @Test(dataProvider = "validGroups")
    public void testsGroupCreation(GroupData group) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().createGroup(group);
      Groups after = app.group().all();
      assertThat(after.size(), equalTo(before.size() + 1));
      group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
      assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }
}
