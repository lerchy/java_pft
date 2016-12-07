package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class HelperBase {
    private WebDriver wd;

    HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    void click(By locator) {
        wd.findElement(locator).click();
    }

    void type(By locator, String text) {
        WebElement element = findElement(locator);
        if (text != null) {
            String existingText = element.getAttribute("value");
            if(!text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    private WebElement findElement(By locator) {
        return wd.findElement(locator);
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void closeAlert(){ wd.switchTo().alert().accept(); }
}
