package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

/**
 * Created by valeriyagagarina on 12/1/16.
 */
public class GroupHelper extends HelperBase{

    GroupHelper(WebDriver wd) {
        super(wd);
    }

    private void initGroupCreation() {
        click(By.xpath("//div[@id='content']/form/input[4]"));
    }

    private void fillGroupForm(GroupData groupData) {

        type(By.name("group_name"), groupData.getName());

        type(By.name("group_header"), groupData.getHeader());

        type(By.name("group_footer"), groupData.getFooter());
    }

    private void submitGroupForm() {
        click(By.name("submit"));
    }
    private void returnToGroupPage() {
        click(By.linkText("group page"));
    }
    private void deleteSelectedGroups() {
        click(By.name("delete"));
    }
    private void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
    private void initGroupModification() {
        click(By.name("edit"));
    }
    private void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupForm();
        groupCache = null;
        returnToGroupPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }

    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCache.add(new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();
    }
}
