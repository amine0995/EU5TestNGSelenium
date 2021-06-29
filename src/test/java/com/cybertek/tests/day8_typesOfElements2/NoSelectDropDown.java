package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropDown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement dropdownElement= driver.findElement(By.cssSelector("#dropdownMenuLink"));
        //DropdownLink menu, after clicking we need to find common locators of these 5 options
        //common locators are"dropdown-item"

        //click the dropdown to see available options
        dropdownElement.click();
        //get the options with find elements method and finding common locator between them
        List<WebElement> dropdownOptions= driver.findElements(By.cssSelector("a.dropdown-item"));
        //print size of options
        System.out.println("dropdownOptions.size() = " + dropdownOptions.size());
        //verify the size of the options are 5
        Assert.assertEquals(dropdownOptions.size(),5,"verify the size of the options is 5");
        //print them one by one
        for(WebElement option:dropdownOptions){
            System.out.println(option.getText());
        }
        //chose Yahoo
        dropdownOptions.get(2).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        System.out.println("driver.getTitle() = " + driver.getTitle());


        String expectedTitle= driver.getTitle();
        String actualTitle= driver.getTitle();
        //verify if the expected Title is same with the current title
//        if(expectedTitle==actualTitle){
//            System.out.println(true);
//        }else{
//            System.out.println(false);
//        }//false

        Assert.assertFalse(expectedTitle==actualTitle,"verify ");

        Thread.sleep(5000);
        driver.navigate().back();
        driver.navigate().back();


    }
}
