package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase{
    
    @Test
    public void testDeleteGroup() {
        app.goToGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnToGroupPage();
    }
}
