package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

    @Test(enabled = true)
    public void testUserCreation() {
        app.goTo().homePage();
        Contacts before =  app.contact().all();
        ContactData contact = new ContactData().withFirstname("John").withLastname("Smith").inGroup("test2");
        app.contact().createContact(contact);
        app.goTo().homePage();
        Contacts after =  app.contact().all();
        assertThat(after.size(), equalTo( before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
    }
}
