package com.tat19.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletePage {

    @FindBy(name = "delete")

    private WebElement delText;

    @FindBy(id = "yui-gen4-button")
    private WebElement buttonDelete;

    private WebDriver driver;

    public DeletePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getWarningText() {
        return delText.getText();
    }

    public ManageUsersPage ClickButtonYes() {
        buttonDelete.click();
        return new ManageUsersPage(driver);
    }


}
