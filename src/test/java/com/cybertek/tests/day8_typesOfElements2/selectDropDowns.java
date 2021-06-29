package com.cybertek.tests.day8_typesOfElements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class selectDropDowns {
    WebDriver driver ;
    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
      Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void test1() {

        driver.get("http://practice.cybertekschool.com/dropdown");
        //1.locate your dropdown just like any other web element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //2. create Select object by passing that element as a constructor
        Select stateDropDown = new Select(dropdownElement);

        //3.get all dropdown options in an array list
        //getOptions()-->returns all the available options from the dropdown
        List<WebElement> options = stateDropDown.getOptions();

        //print the size of dropdown options
        System.out.println("options.size() = " + options.size());

        //4.print options one by one
        for (WebElement option : options) {//shortcut for creating loop :iter+enter
            System.out.println(option.getText());
        }

    }
        @Test
        public void test2() throws InterruptedException {

            driver.get("http://practice.cybertekschool.com/dropdown");
            //1.locate your dropdown just like any other web element with unique locator
            WebElement dropdownElement= driver.findElement(By.id("state"));

            //2. create Select object by passing that element as a constructor
            Select stateDropDown =new Select(dropdownElement);

            //verify that first selection is Select a state
            String expectedOption="Select a State";
            String actualOption = stateDropDown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify first selection");

            //how to select something from dropdown
            //1.select using visible text

            Thread.sleep(2000);
            stateDropDown.selectByVisibleText("Virginia");

            expectedOption="Virginia";
            actualOption=stateDropDown.getFirstSelectedOption().getText();

            //.verify first selection is virginia
            Assert.assertEquals(actualOption,expectedOption,"verify first selection");

            //2.select using index
            Thread.sleep(2000);
            stateDropDown.selectByIndex(51);

            expectedOption="Wyoming";
            actualOption=stateDropDown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify first selection");

            //3.Select by value
            Thread.sleep(2000);
            stateDropDown.selectByValue("WY");
            expectedOption=stateDropDown.getFirstSelectedOption().getText();
            Assert.assertEquals(actualOption,expectedOption,"verify first selection");


        }
}
