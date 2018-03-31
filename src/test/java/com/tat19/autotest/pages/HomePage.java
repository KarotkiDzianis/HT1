package com.tat19.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='tasks']/div[4]/a[2]")
    private WebElement manageJenkinsLink;


    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/a")
    private WebElement linkEnableAutoRefresh;


    private WebDriver driver;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public ManageJenkinsPage openManageJenkinsPage() {
        manageJenkinsLink.click();
        return new ManageJenkinsPage(driver);
    }

    public void clickLinkEnableAutoRefresh() {
        linkEnableAutoRefresh.click();
    }

    public String getTextLinkEnableAutoRefresh() {
        return linkEnableAutoRefresh.getText();
    }


}
