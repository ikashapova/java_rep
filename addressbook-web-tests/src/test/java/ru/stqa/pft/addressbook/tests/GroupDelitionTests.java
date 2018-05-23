package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupDelitionTests extends TestBase {


    @Test
    public void testGroupDelition() {
        app.getNavigationHelper().gotoGroup();
        if (! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupData("test2", null, "test4"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test3", null, "test4");
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().gotoGroup();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1);
        before.remove(before.size()-1);
        for(int i=0; i<after.size();i++){
           // Assert.assertEquals(before.get(i), after.get(i)); //сравнение списков
            before.add(group);
            Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);


        }

    }


}
