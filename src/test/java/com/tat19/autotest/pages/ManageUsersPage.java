package com.tat19.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUsersPage extends AbstractPage {


    @FindBy(xpath = "//*[@id='tasks']/div[3]/a[2]")
    private WebElement linkCreateUser;

    @FindBy(xpath = "//*[@id='people']/tbody/tr[3]/td[4]/a[2]")
    private WebElement linkDelete;


    @FindBy(linkText = "user/admin/delete")
    private WebElement linkAdminDelete;


    @FindBy(xpath = "//*[@id='people']/tbody/tr[2]/td[2]/a")
    private  WebElement adminName;

    @FindBy(xpath = "//*[@id='people']/tbody/tr[3]/td[2]/a")
    private WebElement newUserIsCreate;

    private WebDriver driver;

    public ManageUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateUsersPage openCreateUsersPage() {
        linkCreateUser.click();
        return new CreateUsersPage(driver);
    }

    public DeletePage openDeletePage() {
        linkDelete.click();
        return new DeletePage(driver);
    }

    public String getTextLinkCreateUser() {
        return linkCreateUser.getText();
    }

    public String getNameNewUser() {
        return newUserIsCreate.getText();
    }

    public boolean newUserIsDisplayed() {
        return newUserIsCreate.isDisplayed();
    }

    public boolean linkDeleteIsDisplayed() {
        return newUserIsCreate.isDisplayed();
    }

    public boolean linkAdminDelete() {
        return linkAdminDelete.isDisplayed();
    }

    public String getNameAdmin() {
        return adminName.getText();
    }
}


