package com.tat19.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {


    @FindBy(xpath = "/html/body/div[2]/div[2]/div[2]/div[2]/div[1]/div/div/a")
    private WebElement linkEnableAutoRefresh;

    private WebDriver driver;


    public WebElement getLinkEnableAutoRefresh() {
        return linkEnableAutoRefresh;
    }

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AbstractPage() {

    }
}
