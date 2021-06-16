package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class linkTextandPartialLinktext {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        WebElement example1= driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"));
        //example1.click();
        WebElement example4=driver.findElement(By.partialLinkText("Example4"));
        example4.click();


    }
}
