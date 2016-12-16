package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class UserModificationTest extends TestBase{
    @Test
    public void testUserModification(){
        app.getNavigationHelper().goToHomePage();
        // if there is no users in the table, create one and return to the home page
        if(!app.getContactHelper().isThereContact()){
            app.getContactHelper().createContact(new UserData("test1", null, null, "newTest1"));
        }
        app.getNavigationHelper().goToHomePage();

        app.getContactHelper().selectUser();
        app.getContactHelper().initEditUser();
        app.getContactHelper().fillUserForm(new UserData("XXX", "XXX", "XXX",
                "XXX", "XXX", "XXX","XXX-XX-XX", "XX-XXX-XX",
                "XXX, XXX", null, 0), false);
        app.getContactHelper().submitUserModification();
        app.getNavigationHelper().goToHomePage();

    }

}
