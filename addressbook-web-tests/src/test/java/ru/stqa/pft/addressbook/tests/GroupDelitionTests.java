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

public class GroupDelitionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().createGroup(new GroupData().withName("test3"));
        }
    }

    @Test
    public void testGroupDelition() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        GroupData group = new GroupData().withName("test3");
        app.group().deleteGroup(deletedGroup);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(),before.size()-1);
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(((Groups) before).without(deletedGroup)));


        }

    }




