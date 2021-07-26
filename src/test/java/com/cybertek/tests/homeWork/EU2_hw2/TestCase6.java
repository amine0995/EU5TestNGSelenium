package com.cybertek.tests.homeWork.EU2_hw2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Character.CONTROL;

public class TestCase6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
//        Thread.sleep(2000);
//        driver.quit();
    }

    @Test
    public void test1(){

        // navigate to the link blow
        driver.get( "https://www.fakemail.net");

                // copy fake email
        WebElement element = driver.findElement(By.xpath("(//a[@title='Copy this email address'])[2]"));
        WebElement email= driver.findElement(By.cssSelector( "span#email"));


        element.getText();
        System.out.println("email.getText() = " + email.getText());

//        driver.get("http://practice.cybertekschool.com");
//
//                driver.findElement(By.xpath("//a[@href='/sign_up']")).click();
//
//
//        driver.findElement(By.name("full_name")).sendKeys(chord(CONTROL,"v"));

    }



}
