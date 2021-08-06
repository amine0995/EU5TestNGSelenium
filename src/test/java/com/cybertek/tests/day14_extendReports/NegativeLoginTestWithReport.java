package com.cybertek.tests.day14_extendReports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void WrongPassword(){
         //name of the test
        extentLogger= report.createTest("Wrong password test ");
        //create an object
        LoginPage loginPage=new LoginPage();

        extentLogger.info("Enter Username: user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("enter password: somepassword");
        loginPage.passwordInput.sendKeys("somepasssword");

        extentLogger.info("click login button");
        loginPage.loginBtn.click();

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");

        extentLogger.pass("wrong password test is passed");

    }
    @Test
    public void wrongUsernameTest(){
        //name of the test
        extentLogger= report.createTest("Wrong username test ");

        LoginPage loginPage=new LoginPage();

        extentLogger.info("enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("enter password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");

        extentLogger.info("click login button");
        loginPage.loginBtn.click();

        extentLogger.info("varify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/loginWEr");

        extentLogger.pass("passed");
    }

}
