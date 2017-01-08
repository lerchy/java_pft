package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * Created by valeriyagagarina on 1/8/17.
 */
public class DeleteContactFromGroupTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(app.db().groups().size() == 0){
            app.group().create(new GroupData().withName("group1"));
        }
        if(app.db().contacts().size() == 0){
            app.contact().createContact(new ContactData()
                    .withFirstname("firstname").withLastname("lastname")
                    .withAddress("address").withHomePhone("333").withMobilePhone("333").withWorkPhone("3333")
                    .withEmail1("test@email.com").withEmail2("test@email.com").withEmail3("test@email.com")
                    .inGroup(app.db().groups().iterator().next()));
        }
    }

    @Test
    public void testContactFromGroupDeletion(){
        ContactData contact = app.db().contacts().iterator().next();
        Set<GroupData> groups = contact.getGroups();
        GroupData group;
        app.goTo().homePage();
        if (groups.size() == 0){
            app.contact().addContactToGroup(contact, group = app.db().groups().iterator().next());

        } else{
            group = groups.iterator().next();
        }
        app.goTo().homePage();
        app.contact().removeContactFromGroup(contact, group);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.db().refresh(contact);
        assertThat(contact.getGroups(), not(hasItem(group)));
    }

}
