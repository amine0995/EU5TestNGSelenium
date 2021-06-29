package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MeetSkyLogIn {
    /*
    TASK TO FINISH
//open the browser
        //go to MEETSKY page
        //automate log in
        //click on your user story menu/tab
        //verify that you successfully see your page

     */

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }
    @Test
    public void testLogin(){
        //1.navigate to the url
        driver.get("http://qa.meetsky.net/index.php/login");
        //maximize the window
        driver.manage().window().maximize();
        // 2.locate username input box and send username
        driver.findElement(By.cssSelector("input#user")).sendKeys("Employee1");
        //3.locate password input box and send password
        driver.findElement(By.cssSelector("input#password")).sendKeys("Employee123");
        //4.click log in
        driver.findElement(By.cssSelector("input#submit-form")).click();
        //5.verify the homepage
        String expectedTitle="Files - Meetsky - QA";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"verify that the homepage is successfully opened");


    }

}
