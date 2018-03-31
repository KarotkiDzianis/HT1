package com.tat19.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageJenkinsPage extends AbstractPage {


    @FindBy(xpath = "//*[@id='main-panel']/div[16]/a")
    private WebElement manageUserLink;

    @FindBy(xpath = "//*[@id='main-panel']/div[16]/a/dl/dt")
    private WebElement textManageUsers;

    @FindBy(xpath = "//*[@id='main-panel']/div[16]/a/dl/dd[1]")
    private  WebElement textCreateDeleteModifyUsers;

    private WebDriver driver;

    public ManageJenkinsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ManageUsersPage openManageUsersPage() {
        manageUserLink.click();
        return new ManageUsersPage(driver);
    }

    public String getTextLinkManageUsers() {
        return textManageUsers.getText();

    }

    public String getTextCreateDeleteModifyUsers() {
        return textCreateDeleteModifyUsers.getText();
    }
}
