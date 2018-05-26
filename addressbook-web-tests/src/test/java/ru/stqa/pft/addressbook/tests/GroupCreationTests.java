package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class GroupCreationTests extends TestBase {


    @Test
    public void testsGroupCreation() {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test3");
        app.group().createGroup(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));
        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
    }

}
