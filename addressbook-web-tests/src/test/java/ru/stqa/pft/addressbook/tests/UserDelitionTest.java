package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.List;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class UserDelitionTest extends TestBase{

    @Test(enabled = false)
    public void testUserCreation(){
        app.getNavigationHelper().goToHomePage();
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new UserData("test1", null, null, "newTest1"));
            app.getNavigationHelper().goToHomePage();
        }
        List<UserData> before =  app.getContactHelper().getContactList();
        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().deleteUser();
        app.getSessionHelper().closeAlert();
        app.getNavigationHelper().goToHomePage();

        List<UserData>  after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }
}
