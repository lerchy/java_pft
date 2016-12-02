package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class ApplicationManager {

    FirefoxDriver wd;
    private  SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelher contactHelher;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/index.php");
        groupHelper = new GroupHelper(wd);
        contactHelher = new ContactHelher(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactHelher getContactHelher() {
        return contactHelher;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }


}
