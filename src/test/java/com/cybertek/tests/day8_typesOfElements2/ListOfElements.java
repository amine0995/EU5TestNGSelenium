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

public class ListOfElements {
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

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //save our web elements inside the list
        List<WebElement> buttons = driver.findElements(By.tagName("button"));//By.css: button.btn-btn-primary

        System.out.println("buttons.size() = " + buttons.size());

        //verify button size
        Assert.assertEquals(buttons.size(), 6, "verify buttons size");

        for (WebElement button : buttons) {//iter+enter= you get iteration of for each loop of the elements
            //System.out.println("button.getText() = " + button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
            Assert.assertTrue(button.isDisplayed(), "verify buttons are displayed");
        }
        //click second button
        buttons.get(1).click();
        System.out.println("buttons.get(1).getText() = " + buttons.get(1).getText());//Button 2
    }
        @Test
            public void test2() {
            driver.get("http://practice.cybertekschool.com/dropdown");

            //regular find element method will throw NSE if locator does not exist
            //driver.find element  by tagname "sdfsfds"
            //passing locator which does not exist, it will not throw NoSuchElement
            //alt+enter or option enter then one more enter is the shortcut of array
            List<WebElement> buttons = driver.findElements(By.tagName("dfkldjsd"));
            System.out.println("driver.findElements(By.tagName(\"dfkldjsd\")) = " + driver.findElements(By.tagName("dfkldjsd")));
            //[] not such element
            System.out.println("buttons.size() = " + buttons.size());//0
        }




        }
