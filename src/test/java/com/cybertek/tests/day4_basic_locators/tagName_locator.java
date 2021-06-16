package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagName_locator {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();//maximize screen
        driver.get("Http://practice.cybertekschool.com/sign_up");
        //sendkeys to fullname
        WebElement fullNameInput= driver.findElement(By.tagName("input"));
        fullNameInput.sendKeys("Mike Smith with tagName");
        //send keys to email
        WebElement emailInput= driver.findElement(By.name("email"));
        emailInput.sendKeys("Mike@smith.com");
        //lazy way to click button
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(3000);
        driver.quit();





    }

}
