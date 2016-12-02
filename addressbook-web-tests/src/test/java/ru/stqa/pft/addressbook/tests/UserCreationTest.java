package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import ru.stqa.pft.addressbook.model.UserData;

public class UserCreationTest extends TestBase{

    @Test
    public void testUserCreation() {

        app.getContactHelher().initUserCreation();
        app.getContactHelher().fillUserCreationForm(new UserData("Thomas", "A.", "Anderson",
                                          "Neo", "Software Engineer", "Matrix",
                                          "222-333-22", "333-222-33", "Lowertown, USA"));
        app.getContactHelher().submitUserCreation();
    }
}
