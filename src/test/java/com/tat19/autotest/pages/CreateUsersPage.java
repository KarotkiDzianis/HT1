package com.tat19.autotest.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage extends  AbstractPage{



    WebDriver driver;


    @FindBy(xpath = "//*[@id='username']")
    WebElement username;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[2]/td[2]/input")
    WebElement password1;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[3]/td[2]/input")
    WebElement password2;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[4]/td[2]/input")
    WebElement fio;

    @FindBy(xpath = "//*[@id='main-panel']/form/div[1]/table/tbody/tr[5]/td[2]/input")
    WebElement email;

    @FindBy(xpath = "//*[@id='yui-gen4']")
    WebElement buttonCreateUser;

    @FindBy(xpath =  "//*[@id='main-panel']/form/div[1]/div")
    WebElement errorMessage;

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



    /*public ManageUsersPage open() {
        if (username.getSize() != null && password1!=null &&
                password2 != null && password1==password2 && fio != null && email !=null) {

            buttonCreate.click();
        } else {
            System.out.println("You must write all fields");

        }
        return  new ManageUsersPage(driver);
    }*/

}


