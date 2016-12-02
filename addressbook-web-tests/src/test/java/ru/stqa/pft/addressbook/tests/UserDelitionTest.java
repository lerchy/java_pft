package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class UserDelitionTest extends TestBase{

    @Test
    public void testUserCreation(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().selectUser();
        app.getContactHelper().deleteUser();
        app.getSessionHelper().closeAlert();
        app.getNavigationHelper().goToHomePage();
    }
}
