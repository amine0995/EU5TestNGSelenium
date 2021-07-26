package com.cybertek.tests.day9_waits;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        //or By.tagName("button")
        WebElement userInput= driver.findElement(By.id("username"));

        //how to wait explicitly?
        //create explicit wait object
        WebDriverWait wait =new WebDriverWait(driver, 100);

        wait.until(ExpectedConditions.visibilityOf(userInput));

        userInput.sendKeys("rena rozi");

        driver.findElement(By.id("pwd")).sendKeys("12345");

        driver.findElement(By.cssSelector("button[type='submit']")).click();



    }
}
