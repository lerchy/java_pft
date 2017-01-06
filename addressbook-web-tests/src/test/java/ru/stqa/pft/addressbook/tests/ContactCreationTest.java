package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
        String json = "";
        String line = reader.readLine();
        while(line != null){
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>(){}.getType());
        return contacts.stream().map(g -> new Object[] {g}).collect(Collectors.toList()).iterator();
    }

    @Test(enabled = true, dataProvider = "validContactsFromJson")
    public void testUserCreation(ContactData contact) {
        app.goTo().homePage();
        Contacts before =  app.contact().all();
        System.out.println(before);
//        File photo = new File("src/test/resources/lemur.jpg");
        app.contact().createContact(contact);
        app.goTo().homePage();
        Contacts after =  app.contact().all();
        assertThat(after.size(), equalTo( before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt(c -> c.getId()).max().getAsInt()))));
    }
}
