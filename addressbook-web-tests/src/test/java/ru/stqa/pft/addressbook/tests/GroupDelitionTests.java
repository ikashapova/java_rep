package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelitionTests extends TestBase {


    @Test
    public void testGroupDelition() {
        app.getNavigationHelper().gotoGroup();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getNavigationHelper().gotoGroup();
    }


}
