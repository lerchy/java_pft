package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class GroupModificationTest extends TestBase {
    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupPage();
        if(!app.getGroupHelper().isThereGroup()){
            app.getGroupHelper().createGroup(new GroupData("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("newTest1", "newTest2", "newTest3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}
