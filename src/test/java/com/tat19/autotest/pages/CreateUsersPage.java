package com.tat19.autotest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage extends AbstractPage {


    private WebDriver driver;


    @FindBy(xpath = "//*[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[2]/td[2]/input")
    private  WebElement password1;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[3]/td[2]/input")
    private WebElement password2;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[4]/td[2]/input")
    private  WebElement fio;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[5]/td[2]/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id='yui-gen4']")
    private WebElement buttonCreateUser;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/div")
    private  WebElement errorMessage;

    public CreateUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void setUserName(String name) {
        username.clear();
        username.sendKeys(name);
    }

    public void setPassword1(String password) {
        password1.clear();
        password1.sendKeys(password);
    }

    public void setPassword2(String passwordConf) {
        password2.clear();
        password2.sendKeys(passwordConf);
    }

    public void setFio(String FIO) {
        fio.clear();
        fio.sendKeys(FIO);
    }

    public void setEmail(String eMail) {
        email.clear();
        email.sendKeys(eMail);
    }

    public String getErrorTextInCreateNewUser() {
        return errorMessage.getText();
    }

    public void clickButtonCreateUser() {
        buttonCreateUser.click();
    }

    public String getUserNameText() {
        return username.getText();
    }

    public String getPassword1Text() {
        return password1.getText();
    }

    public String getPassword2Text() {
        return password2.getText();
    }

    public String getFIOText() {
        return fio.getText();
    }

    public String getEmailText() {
        return email.getText();
    }


}


