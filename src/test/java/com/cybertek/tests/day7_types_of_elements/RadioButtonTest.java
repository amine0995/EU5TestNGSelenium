package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    @Test
    public void test1() throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        //locating radio button
        WebElement blueRadioButton= driver.findElement(By.cssSelector("#blue"));
        WebElement redRadioButton= driver.findElement(By.id("red"));
        //we're going to verify blue is selected and red is not selected
        System.out.println("blueRadioButton is selected: "+blueRadioButton.isSelected());
        System.out.println("redRadioButton is selected: "+redRadioButton.isSelected());
        //blue-->true
        Assert.assertTrue(blueRadioButton.isSelected(),"verify that blue button is selected");
        //red-->false
        Assert.assertFalse(redRadioButton.isSelected(),"verify that red button is not selected");
        //how to click red radio button
        //clicking red radio button
        redRadioButton.click();

        //blue-->false(not selected)
        Assert.assertFalse(blueRadioButton.isSelected(),"verify that blue button is not selected");
        //red-->true(selected)
        Assert.assertTrue(redRadioButton.isSelected(),"verify that blue button is selected");




        Thread.sleep(3000);
        driver.quit();


    }
}
