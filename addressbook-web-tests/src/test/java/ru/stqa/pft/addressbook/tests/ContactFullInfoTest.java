package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by valeriyagagarina on 1/4/17.
 */
public class ContactFullInfoTest extends TestBase {

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

    @Test
    public void testFullContactInfo(){
        ContactData contact = app.contact().all().iterator().next();
        String contactInfoFromHomePage = cleaned(contact.getFullName() + contact.getAddress()
                + contact.getAllPhones() + contact.getAllEmails());
        app.contact().showFullInfo(contact);
        String fullContactInfo = cleaned(app.contact().fullContactInfo());
        assertThat(contactInfoFromHomePage, equalTo(fullContactInfo));
    }

    private static String cleaned(String info){
        return info.replaceAll("H: ", "").replaceAll("M: ", "").replaceAll("W: ", "")
                .replaceAll("\\s", "").replaceAll("[-()]","");
    }
}
