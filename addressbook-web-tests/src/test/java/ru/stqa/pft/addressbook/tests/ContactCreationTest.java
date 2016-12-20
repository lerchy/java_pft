package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test(enabled = true)
    public void testUserCreation() {
        app.goTo().homePage();
        List<ContactData> before =  app.contact().list();
        ContactData contact = new ContactData("John", "J.", "Smith", "newTest1");
        app.contact().createContact(contact);
        app.goTo().homePage();
        List<ContactData> after =  app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byFullName = (u1, u2) -> u1.getFullName().compareToIgnoreCase(u2.getFullName());
        before.sort(byFullName);
        after.sort(byFullName);
        Assert.assertEquals(before, after);
    }
}
