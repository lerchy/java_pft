package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initUserCreation() {
        click(By.linkText("add new"));
    }

    public void fillUserForm(ContactData userData, boolean creation) {
        type(By.name("firstname"),userData.getFirstname());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("mobile"), userData.getMobilephone());
        type(By.name("address"), userData.getAddress());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(userData.getGroup());
        } else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void submitUserCreation() {
        click(By.name("submit"));
    }
    
    public void selectUser(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void deleteUser() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }


    public void initEditUser() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); }

    public void confirmUpdate() { click(By.name("update")); }

    public void createContact(ContactData user) {
        initUserCreation();
        fillUserForm(user, true);
        submitUserCreation();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        selectUser(contact.getId());
        initEditUser();
        fillUserForm(contact, false);
        confirmUpdate();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectUser(contact.getId());
        deleteUser();
        closeAlert();
        returnToHomePage();
    }

    private void returnToHomePage() {
        click(By.linkText("home"));
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> trElements = wd.findElements(By.name("entry"));
        for(WebElement trElement : trElements){

            List<WebElement> tdElements = trElement.findElements(By.xpath("td"));
            String firstname = tdElements.get(2).getText();
            String lastname = tdElements.get(1).getText();
            int id = Integer.parseInt(tdElements.get(0).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withFirstname(firstname).withLastname(lastname).withId(id);
            contacts.add(contact);
        }
        return contacts;
    }

}
