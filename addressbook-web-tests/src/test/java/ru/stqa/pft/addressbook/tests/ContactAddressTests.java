package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by valeriyagagarina on 12/27/16.
 */
public class ContactAddressTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        if(app.db().contacts().size() == 0){
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname")
                    .withAddress("address").withHomePhone("333").withMobilePhone("333").withWorkPhone("3333")
                    .withEmail1("test@email.com").withEmail2("test@email.com").withEmail3("test@email.com"));
        }
    }

    @Test
    public void testAddress(){
        ContactData contact = app.db().contacts().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
    }

    private static String cleaned(String address){
        return address.replaceAll("\\n", "").replaceAll("\\s", "");
    }
}
