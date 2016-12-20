package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class ContactDelitionTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        if(app.contact().list().size() == 0){
            app.contact().createContact(new ContactData("test1", null, null, "newTest1"));
            app.goTo().homePage();
        }
    }

    @Test(enabled = true)
    public void testUserCreation(){
        List<ContactData> before =  app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);

        List<ContactData>  after =  app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }
}
