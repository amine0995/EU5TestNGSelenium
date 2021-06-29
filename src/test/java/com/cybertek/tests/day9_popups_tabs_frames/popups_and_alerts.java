package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class popups_and_alerts {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3000);
        //driver.quit();
    }
    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        //click confirm button
        driver.findElement(By.xpath("//span[text()='Confirm']")).click();
        //click no button
        driver.findElement(By.xpath("//span[.='No']")).click();




    }
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //click JS alert button
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        // to click the popup with java script we need to use special method called switch to() and alert class
        //switch to JS alert popup
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        //click for JS confirm button
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        alert.dismiss();

//        //click for JS prompt
//        driver.findElement(By.xpath("//button[3]")).click();
//        //send keys to JS Prompt
//        alert.sendKeys("elo");

        //click for JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //send keys to JS Prompt
        alert.sendKeys("MikeSmith");
        Thread.sleep(4000);
        //click ok
        alert.accept();




    }

}
