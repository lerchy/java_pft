package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.Comparator;
import java.util.List;

public class UserCreationTest extends TestBase{

    @Test
    public void testUserCreation() {
        app.getNavigationHelper().goToHomePage();
        List<UserData> before =  app.getContactHelper().getContactList();
        UserData contact = new UserData("John", "J.", "Smith", "newTest1");
        app.getContactHelper().createContact(contact);
        app.getNavigationHelper().goToHomePage();
        List<UserData> after =  app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super UserData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);
    }
}
