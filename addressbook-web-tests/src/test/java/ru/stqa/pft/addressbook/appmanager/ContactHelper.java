package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.UserData;

import java.util.NoSuchElementException;

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

    public void fillUserForm(UserData userData, boolean creation) {
        type(By.name("firstname"),userData.getFirstname());
        type(By.name("middlename"), userData.getMiddlename());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("nickname"), userData.getNickname());
        type(By.name("title"), userData.getTitle());
        type(By.name("company"), userData.getCompany());
        type(By.name("home"), userData.getHomephone());
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
    
    public void selectUser() { click(By.name("selected[]"));}

    public void deleteUser() { click(By.xpath("//div[@id='content']/form[2]/div[2]/input")); }


    public void initEditUser() { click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")); }

    public void submitUserModification() { click(By.name("update")); }

    public void createContact(UserData user) {
        initUserCreation();
        fillUserForm(user, true);
        submitUserCreation();
    }

    public boolean isThereContact() {
        return isElementPresent(By.name("selected"));
    }
}
