package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.cssSelector("#box1"));
        WebElement checkbox2 = driver.findElement(By.cssSelector("#box2"));
        //how to verify checkbox is selected?
        System.out.println("checkbox1.isSelected()= " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected()= " + checkbox2.isSelected());

        //verify check box1 is not selected, 2 is selected
        Assert.assertFalse(checkbox1.isSelected(),"verify checkbox1 is not selected");
        Assert.assertFalse(checkbox2.isSelected(),"verify checkbox2 is not selected");

        //hoe to check checkboxes?
        //just like radio button we need to click it
        checkbox1.click();

        //verify after click
        Assert.assertTrue(checkbox1.isSelected(),"verify checkbox 1 is selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify checkbox 2 is selected");

        Thread.sleep(2000);
        driver.quit();

    }

    }
