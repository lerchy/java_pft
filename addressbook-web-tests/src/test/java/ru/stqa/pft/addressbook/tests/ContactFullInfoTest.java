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
        app.goTo().homePage();
        if(app.contact().all().size() == 0){
            app.contact().createContact(new ContactData().withLastname("Smith").withFirstname("John"));
            app.goTo().homePage();
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
