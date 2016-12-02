package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class GroupHelper extends HelperBase{

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void initGroupCreation() {
        click(By.xpath("//div[@id='content']/form/input[4]"));
    }

    public void fillGroupForm(GroupData groupData) {

        type(By.name("group_name"), groupData.getGroupname());

        type(By.name("group_header"), groupData.getGroupheader());

        type(By.name("group_footer"), groupData.getGroupfooter());
    }

    public void submitGroupForm() {
        click(By.name("submit"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }
}
