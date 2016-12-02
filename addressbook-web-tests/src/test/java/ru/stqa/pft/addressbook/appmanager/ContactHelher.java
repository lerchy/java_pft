package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.UserData;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class ContactHelher extends HelperBase{

    public ContactHelher(FirefoxDriver wd) {
        super(wd);
    }

    public void initUserCreation() {
        click(By.linkText("add new"));
    }

    public void fillUserCreationForm(UserData userData) {
        type(By.name("firstname"),userData.getFirstname());
        type(By.name("middlename"), userData.getMiddlename());
        type(By.name("lastname"), userData.getLastname());
        type(By.name("nickname"), userData.getNickname());
        type(By.name("title"), userData.getTitle());
        type(By.name("company"), userData.getCompany());
        type(By.name("home"), userData.getHomephone());
        type(By.name("mobile"), userData.getMobilephone());
        type(By.name("address"), userData.getAddress());
    }

    public void submitUserCreation() {
        click(By.name("submit"));
    }
}
