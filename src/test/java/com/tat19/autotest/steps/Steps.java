package com.tat19.autotest.steps;


import com.tat19.autotest.driver.Driver;
import com.tat19.autotest.pages.*;
import org.openqa.selenium.WebDriver;

public class Steps {

    private WebDriver driver;


    public void initBrowser() {
        driver = Driver.getDriver();
    }

    public void closeDriver() {
        Driver.closeDriver();
    }


    public void loginJenkins(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.loginAs(username, password);
    }

    public void logOut() {
        HomePage homePage = new HomePage(driver);
        homePage.logOut();
    }

    public HomePage openHomePage() {

        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    public ManageJenkinsPage openManageJenkinsPage() {

        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        return manageJenkinsPage;
    }


    public ManageUsersPage openManageUsersPage() {

        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        return manageUsersPage;
    }


    public CreateUsersPage openCreateUsersPage() {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        manageUsersPage.openCreateUsersPage();
        CreateUsersPage createUsersPage = new CreateUsersPage(driver);
        return createUsersPage;
    }

    public boolean testNameNewUser(String message) {
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        return manageUsersPage.getNameNewUser().contains(message);
    }


    public DeletePage openDeletePage() {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        manageUsersPage.openDeletePage();
        DeletePage deletePage = new DeletePage(driver);
        return deletePage;
    }


}




