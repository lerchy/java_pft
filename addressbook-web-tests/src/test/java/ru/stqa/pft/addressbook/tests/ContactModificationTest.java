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
public class ContactModificationTest extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().contacts().size() == 0){
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname")
                    .withAddress("address").withHomePhone("333").withMobilePhone("333").withWorkPhone("3333")
                    .withEmail1("test@email.com").withEmail2("test@email.com").withEmail3("test@email.com")
                    .inGroup("test1"));
        }
    }

    @Test(enabled = true)
    public void testUserModification(){
        Contacts before =  app.db().contacts();
        app.goTo().homePage();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId())
                .withFirstname("new firstname").withLastname("new lastname")
                .withAddress("new address").withHomePhone("777").withMobilePhone("777").withWorkPhone("7777")
                .withEmail1("new@email.com").withEmail2("new@email.com").withEmail3("new@email.com");
        app.contact().modify(contact);
        Contacts after =  app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }



}
