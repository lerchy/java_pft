package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class ContactHelper extends HelperBase{

    ContactHelper(WebDriver wd) {
        super(wd);
    }

    private void initUserCreation() {
        click(By.linkText("add new"));
    }

    private void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("mobile"), contactData.getMobilephone());
        type(By.name("home"), contactData.getHomephone());
        type(By.name("work"), contactData.getWorkphone());
        type(By.name("address"), contactData.getAddress());
        type(By.name("email"), contactData.getEmail1());
        attach(By.name("photo"), contactData.getPhoto());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    private void submitUserCreation() {
        click(By.name("submit"));
    }
    
    private void selectUser(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    private void deleteUser() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void showFullInfo(ContactData contact){
        wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s'", contact.getId()))).click();
    }

    private void confirmUpdate() { click(By.name("update")); }

    public void createContact(ContactData user) {
        initUserCreation();
        fillContactForm(user, true);
        submitUserCreation();
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModification(contact);
        fillContactForm(contact, false);
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
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for(WebElement trElement : rows){

            List<WebElement> cells = trElement.findElements(By.xpath("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            ContactData contact = new ContactData().withFirstname(firstname).withLastname(lastname).withId(id)
                    .withAllPhone(allPhones).withAddress(address).withAllEmails(allEmails);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModification(contact);
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withMobilePhone(mobile).withHomePhone(home).withWorkPhone(work).withAddress(address)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3);
    }

    private void initContactModification(ContactData contact) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s'", contact.getId()))).click();
    }

    public String fullContactInfo(){
        return wd.findElement(By.id("content")).getText();
    }
}
