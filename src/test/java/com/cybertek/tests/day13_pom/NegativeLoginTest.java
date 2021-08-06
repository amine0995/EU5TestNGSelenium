package com.cybertek.tests.day13_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {

    @Test
    public void WrongPassword(){

        //create an object
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("somepasssword");
        loginPage.loginBtn.click();


//        driver.findElement(By.id("prependedInput")).sendKeys("User1");
//        driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
//        driver.findElement(By.id("_submit")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
//        System.out.println("driver.getTitle() = " + driver.getTitle());
//        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());


    }
    @Test
    public void wrongUsernameTest(){
        LoginPage loginPage=new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }




}
