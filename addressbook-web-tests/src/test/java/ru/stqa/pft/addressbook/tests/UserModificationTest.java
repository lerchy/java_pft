package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

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
            app.getNavigationHelper().goToHomePage();
        }
        List<UserData> before =  app.getContactHelper().getContactList();

        app.getContactHelper().selectUser(before.size() - 1);
        app.getContactHelper().initEditUser();
        UserData contact = new UserData("XXX", "XXX", "XXX", null);
        app.getContactHelper().fillUserForm(contact, false);
        app.getContactHelper().submitUserModification();
        app.getNavigationHelper().goToHomePage();

        List<UserData> after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);

        Comparator<? super UserData> byFullName = (u1, u2) -> u1.getFullName().compareToIgnoreCase(u2.getFullName());
        before.sort(byFullName);
        after.sort(byFullName);
        Assert.assertEquals(before, after);
    }

}
