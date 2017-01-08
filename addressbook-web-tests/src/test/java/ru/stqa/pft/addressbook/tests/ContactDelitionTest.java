package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by valeriyagagarina on 12/2/16.
 */
public class ContactDelitionTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().contacts().size() == 0){
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname")
                    .withAddress("address").withHomePhone("333").withMobilePhone("333").withWorkPhone("3333")
                    .withEmail1("test@email.com").withEmail2("test@email.com").withEmail3("test@email.com"));
//                    .inGroup("test1"));
        }
    }

    @Test(enabled = true)
    public void testContactDeletion(){
        Contacts before =  app.db().contacts();
        app.goTo().homePage();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Contacts  after =  app.db().contacts();
        assertThat(after.size(), equalTo(before.size() - 1));
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
