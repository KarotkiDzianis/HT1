package com.tat19.autotest.tests;

import com.tat19.autotest.DAO.Users;
import com.tat19.autotest.pages.*;
import com.tat19.autotest.steps.Steps;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.*;


public class JenkinsTest {


    private Steps steps;

    private Users testUser = new Users("someuser", "Some Full Name", "some@addr.dom", "somepassword");
    private Users emptyNameUser = new Users("", "FIO", "some@addr.dom", "pass");

    private final String userName = "admin";
    private final String userPass = "root";


    @BeforeClass(description = "Init browser")
    public void setUp() throws Exception {
        steps = new Steps();
        steps.initBrowser();

    }

    @BeforeMethod(description = "LogInJenkins")
    public void logIn() throws Exception {
        steps.loginJenkins(userName, userPass);
    }


    @Test(description = "HT1 test 1")
    public void testLinkManageJenkins111() throws Exception {
        ManageJenkinsPage manageJenkinsPage = steps.openManageJenkinsPage();
        String str = manageJenkinsPage.getTextLinkManageUsers();
        String txt = manageJenkinsPage.getTextCreateDeleteModifyUsers();
        Assert.assertEquals(str, "Manage Users", "Element is not find");
        Assert.assertEquals(txt, "Create/delete/modify users that can log in to this Jenkins", "Element is not find");

    }

    @Test(description = "HT1 test 2")
    public void testLinkManageUsers() throws Exception {
        ManageUsersPage manageUsersPage = steps.openManageUsersPage();
        String str = manageUsersPage.getTextLinkCreateUser();
        Assert.assertEquals(str, "Create User", "Element is not find");

    }

    @Test(description = "HT1 test 3")
    public void testFieldsInCreateUserForm() {
        CreateUsersPage createUsersPage = steps.openCreateUsersPage();
        Assert.assertTrue(createUsersPage.getUserNameText().isEmpty(), "'Username' field is not empty");
        Assert.assertTrue(createUsersPage.getPassword1Text().isEmpty(), "'Password' field is not empty");
        Assert.assertTrue(createUsersPage.getPassword2Text().isEmpty(), "'Confirm' password field is not empty");
        Assert.assertTrue(createUsersPage.getFIOText().isEmpty(), "'Full name' field is not empty");
        Assert.assertTrue(createUsersPage.getEmailText().isEmpty(), "'E-mail address' field is not empty");

    }


    @Test(description = "HT1 test 4")
    public void testAddSomeuser() {
        CreateUsersPage createUsersPage = steps.openCreateUsersPage();
        createUsersPage.setUserName(testUser.getName());
        createUsersPage.setPassword1(testUser.getPassword());
        createUsersPage.setPassword2(testUser.getPassword());
        createUsersPage.setFio(testUser.getFullName());
        createUsersPage.setEmail(testUser.getEmail());
        createUsersPage.clickButtonCreateUser();
        Assert.assertTrue(steps.testNameNewUser(testUser.getName()));

    }

    @Test(description = "HT1 test 5", dependsOnMethods = "testAddSomeuser")
    public void testWarningTextDuringDeleteSomeuser() {
        DeletePage deletePage = steps.openDeletePage();
        Assert.assertTrue(deletePage.getWarningText().contains("Are you sure about deleting the user from Jenkins?"));

    }

    @Test(description = "HT1 test 6", dependsOnMethods = "testWarningTextDuringDeleteSomeuser", expectedExceptions = NoSuchElementException.class)
    public void testAfterPushDeleteSomeuser() {
        DeletePage deletePage = steps.openDeletePage();
        deletePage.ClickButtonYes();
        ManageUsersPage manageUsersPage = steps.openManageUsersPage();
        Assert.assertFalse(manageUsersPage.newUserIsDisplayed());
        Assert.assertFalse(manageUsersPage.linkDeleteIsDisplayed());

    }

    @Test(description = "HT1 test 7", expectedExceptions = NoSuchElementException.class)
    public void testLinkAdminDelete() {
        ManageUsersPage manageUsersPage = steps.openManageUsersPage();
        Assert.assertEquals(manageUsersPage.getNameAdmin(), "admin");
        Assert.assertTrue(manageUsersPage.linkAdminDelete());

    }


    @Test(description = "HT1 test LinkEnableAutoRefresh")
    public void testLinkEnableAutoRefresh() {
        HomePage homePage = steps.openHomePage();
        String str = homePage.getTextLinkEnableAutoRefresh();
        homePage.clickLinkEnableAutoRefresh();
        String strAfter = homePage.getTextLinkEnableAutoRefresh();
        Assert.assertEquals(str, "ENABLE AUTO REFRESH");
        Assert.assertEquals(strAfter, "DISABLE AUTO REFRESH");
        Assert.assertFalse(str.equals(strAfter));
    }


    @Test(description = "HT1 test EmptyUser")
    public void testEmptyUser() {
        CreateUsersPage createUsersPage = steps.openCreateUsersPage();
        createUsersPage.setUserName(emptyNameUser.getName());
        createUsersPage.setPassword1(emptyNameUser.getPassword());
        createUsersPage.setPassword2(emptyNameUser.getPassword());
        createUsersPage.setFio(emptyNameUser.getFullName());
        createUsersPage.setEmail(emptyNameUser.getEmail());
        createUsersPage.clickButtonCreateUser();
        Assert.assertEquals(createUsersPage.getErrorTextInCreateNewUser(), "\"\" is prohibited as a username for security reasons.");
    }

    @Test(description = "New Test")
    public void test(){
 // Here can be your method
    }



    @AfterMethod(description = "logOutJenkins")
    public void logOut() throws Exception {
        steps.logOut();
    }


    @AfterClass(description = "Stop Browser")
    public void stopBrowser() throws Exception {
        steps.closeDriver();
    }
}











