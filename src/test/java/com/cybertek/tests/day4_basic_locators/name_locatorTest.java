package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class name_locatorTest {
    public static void main(String[] args) {
        //WebDriverManager.firefoxdriver().setup();

        //WebDriver driver=new FirefoxDriver();
       WebDriver driver = WebDriverFactory.getDriver("chrome");
        //make browser full screen
        //driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullNameInput = driver.findElement(By.name("full_name"));
        fullNameInput.sendKeys("mike smith");

        //put some email and click sign up button//proper way
        //WebElement emailInput= driver.findElement(By.name("email"));
        //emailInput.sendKeys("mike@smith.com");
        // WebElement signUpButton= driver.findElement(By.name("wooden_spoon"));
        //signUpButton.click();

        //lazy way
        driver.findElement(By.name("email")).sendKeys("Rena@gmail.com");
        driver.findElement(By.name("wooden_spoon")).click();



    }

}
