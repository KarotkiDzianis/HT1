package com.tat19.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public static final String PAGE_URL = "http://localhost:8080/login?from=%2F";

    WebDriver driver;


    @FindBy(xpath = "//*[@id='j_username']")
    private WebElement userNameLocator;

    @FindBy(xpath = "//*[@id='main-panel']/div/form/table/tbody/tr[2]/td[2]/input")
    private WebElement passwordLocator;

    @FindBy(xpath = "//*[@id='yui-gen1-button']")
    private WebElement loginButtonLocator;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        driver.get(PAGE_URL);
    }

    public void loginAs(String userName, String password) {
        userNameLocator.clear();
        userNameLocator.sendKeys(userName);
        passwordLocator.clear();
        passwordLocator.sendKeys(password);
        loginButtonLocator.click();
    }

}






