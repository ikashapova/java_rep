package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelitionTests extends TestBase {


    @Test
    public void testGroupDelition() {
        app.gotoGroup();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.gotoGroup();
    }


}
