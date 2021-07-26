package com.cybertek.tests.day10_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/*
hover over each image in the website,verify each name:user text is displayed
 */


public class HoverTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
//        Thread.sleep(5000);
//        driver.quit();
    }

    @Test
    public void test1(){

        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1= driver.findElement(By.tagName("img"));
        //hover over to the image 1
        Actions actions=new Actions(driver);
        //click image1
        actions.moveToElement(img1).perform();

        WebElement text1= driver.findElement(By.xpath("//h5[text()='name: user1']"));

        Assert.assertTrue(text1.isDisplayed(),"verify text1  is displayed");




    }

    /*
hover over each image in the website,verify each name:user text is displayed
 */
    @Test
    public void  test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i=1;i<=3;i++) {
            String xPathImage="(//img)["+i+"]";
            WebElement img= driver.findElement(By.xpath(xPathImage));
            System.out.println(xPathImage);

            //hover over to each image one by one
            Actions actions=new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();

            //verify
            String textXpath="//h5[text()='name: user"+i+"']";
            WebElement text1= driver.findElement(By.xpath(textXpath));
            System.out.println(textXpath);
            Assert.assertTrue(text1.isDisplayed(),"verify user "+i+" is displayed");


        }
    }


}
