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


    public HomePage openHomePage() {

        HomePage homePage = new HomePage(driver);
        return homePage;
    }

    public ManageJenkinsPage openManageJenkinsPage() {

        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        return  manageJenkinsPage;
    }


   /* public boolean getManageJenkinsLink(String message) {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        return manageJenkinsPage.getLinkText().contains(message);
    }
    public  boolean getManageJenkinsText (String message) {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        return manageJenkinsPage.getText().contains(message);
    }*/

    public ManageUsersPage openManageUsersPage() {

        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        return  manageUsersPage;
    }

   /* public  boolean getCreateUserText (String message) {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        return manageUsersPage.getTextLinkCreateUser().contains(message);
    }*/

    public  CreateUsersPage openCreateUsersPage () {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        manageUsersPage.openCreateUsersPage();
        CreateUsersPage createUsersPage = new CreateUsersPage(driver);
       return createUsersPage;
    }

    public boolean testNameNewUser (String message) {
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
        DeletePage deletePage=new DeletePage(driver);
        return deletePage;
    }


    public  boolean getNewUserPassword1 () {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        manageUsersPage.openCreateUsersPage();
        CreateUsersPage createUsersPage = new CreateUsersPage(driver);
        return createUsersPage.getPassword1Text().isEmpty();
    }




 /*   public  boolean addUser (Users user) {
        HomePage homePage = new HomePage(driver);
        homePage.openManageJenkinsPage();
        ManageJenkinsPage manageJenkinsPage = new ManageJenkinsPage(driver);
        manageJenkinsPage.openManageUsersPage();
        ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
        manageUsersPage.openCreateUsersPage();
        CreateUsersPage createUsersPage = new CreateUsersPage(driver);
        createUsersPage.createNewUser(user);
         return  true;
    }*/





 /*   public String ColorOfLoginButton (String color) {
        LoginPage loginPage =new LoginPage(driver);
        return a;
    }*/



}




   /* public boolean isLoggedIn(String username)
    {
        LoginPage loginPage = new LoginPage(driver);
        String actualUsername = loginPage.getLoggedInUserName().trim().toLowerCase();
        logger.info("Actual username: " + actualUsername);
        return actualUsername.equals(username);
    }

    public boolean createNewRepository(String repositoryName, String repositoryDescription)
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCreateNewRepositoryButton();
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
        return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
    }

    public boolean currentRepositoryIsEmpty()
    {
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        return createNewRepositoryPage.isCurrentRepositoryEmpty();
    }
*/


