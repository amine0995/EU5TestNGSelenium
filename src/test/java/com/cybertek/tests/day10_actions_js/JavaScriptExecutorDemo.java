package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

public class JavaScriptExecutorDemo {
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
    public void clickWithJS(){
        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink= driver.findElement(By.linkText("Dropdown"));
        //
        JavascriptExecutor jse=(JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",dropdownLink);



    }

    @Test
    public  void  typeWithJS(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputBox= driver.findElement(By.cssSelector("#input-example>input"));
        //actually this input box is available when we first clicking the enable button
        //but with the javascriptexecutor we can input content even withour clicking the enable button

        JavascriptExecutor jse= (JavascriptExecutor)driver;

        String text="Hello disabled input box";
        //remember here
        jse.executeScript("arguments[0].setAttribute('value','"+text+"')",inputBox);



    }
    @Test
    public void ScrollDownAndUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        Thread.sleep(1000);
//this is the code fragment of scroll down the web page. we should remember it
        jse.executeScript("window.scrollBy(0,250");

        //let's scroll down 10 times
        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250");

        }

        for(int i=0;i<10;i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,-250");//scroll up

        }




    }


    @Test
    public void ScrollToElement() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        //locate web element English button
        WebElement english= driver.findElement(By.id("icp-touch-link-language"));
        Thread.sleep(2000);
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //directly scroll to english button at the bottom
        jse.executeScript("arguments[0].scrollIntoView(true);",english);

        jse.executeScript("arguments[0].click();",english);
       // driver.findElement(By.cssSelector("a-button-input")).click();


    }



}
