package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

/**
 * Created by valeriyagagarina on 1/8/17.
 */
public class AddContactToGroupTest extends TestBase{

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
                    .withEmail1("test@email.com").withEmail2("test@email.com").withEmail3("test@email.com"));
        }
    }

    @Test
    public void testContactToGroupAddition(){
        ContactData contact = app.db().contacts().iterator().next();
        GroupData group;
        Groups groups = app.db().groups();
        if (groups.equals(contact.getGroups())){
            app.group().create(new GroupData().withName("new_group"));
            groups = app.db().groups();
        }
        groups.removeAll(contact.getGroups());
        group = groups.iterator().next();

        app.goTo().homePage();
        app.contact().addContactToGroup(contact, group);
        app.db().refresh(contact);
        assertThat(contact.getGroups(), hasItem(group));
    }


}
