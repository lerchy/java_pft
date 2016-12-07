package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class UserDelitionTest extends TestBase{

    @Test
    public void testUserCreation(){
        app.getNavigationHelper().goToHomePage();
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new UserData("test1", null, null, "newTest1"));
        }
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectUser();
        app.getContactHelper().deleteUser();
        app.getSessionHelper().closeAlert();
        app.getNavigationHelper().goToHomePage();
    }
}
