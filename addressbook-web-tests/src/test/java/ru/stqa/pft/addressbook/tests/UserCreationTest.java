package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTest extends TestBase{

    @Test
    public void testUserCreation() {

        app.getUserHelper().initUserCreation();
        app.getUserHelper().fillUserCreationForm(new UserData("Thomas", "A.", "Anderson",
                                          "Neo", "Software Engineer", "Matrix",
                                          "222-333-22", "333-222-33", "Lowertown, USA"));
        app.getUserHelper().submitUserCreation();
    }


}
