package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class self_review {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get(" WebDriver driver = WebDriverFactory.getDriver(\"chrome\");");
        driver.manage().window().maximize();//maximaize the screen
        WebElement fullNameInput= driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys(" rena rozi");
        WebElement signUpButton= driver.findElement(By.name("wooden_spoon"));
        signUpButton.click();

    }


    //driver.get("http://practice.cybertekschool.com/sign_up");
}
