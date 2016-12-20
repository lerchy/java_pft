package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class ContactModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if(app.contact().list().size() == 0){
            app.contact().createContact(new ContactData("test1", null, null, "newTest1"));
            app.goTo().homePage();
        }
    }

    @Test(enabled = true)
    public void testUserModification(){
        List<ContactData> before =  app.contact().list();
        int index = before.size() - 1;
        ContactData contact = new ContactData("XXX", "XXX", "XXX", null);
        app.contact().modify(index, contact);

        List<ContactData> after =  app.contact().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);

        Comparator<? super ContactData> byFullName = (u1, u2) -> u1.getFullName().compareToIgnoreCase(u2.getFullName());
        before.sort(byFullName);
        after.sort(byFullName);
        Assert.assertEquals(before, after);
    }



}
