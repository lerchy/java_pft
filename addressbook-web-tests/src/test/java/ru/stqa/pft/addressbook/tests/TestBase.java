package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

import static java.lang.System.getProperty;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;


/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(getProperty("browser"));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
