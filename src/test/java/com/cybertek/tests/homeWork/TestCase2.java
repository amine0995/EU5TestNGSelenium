package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase2 {
    /*
    Go to Ebay
search Selenium
click on search button
verify title contains Selenium
     */
    public static void main(String[] args) throws InterruptedException {
        //1.open chrome driver
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        //2.go to the url
        driver.get("https://www.ebay.com");
       //maximize the window
        driver.manage().window().maximize();
        //3.search the input search box
        WebElement searchInput= driver.findElement(By.cssSelector("input.gh-tb.ui-autocomplete-input"));
        //4.send keyboard action to input search box
        searchInput.sendKeys("selenium");
        //5.click search button
        driver.findElement(By.cssSelector("input#gh-btn")).click();
        //6.verify title contains Selenium
        String title= driver.getTitle();
        System.out.println(title);
        if(title.contains("selenium")){
            System.out.println("pass");
        }else{
            System.out.println("fail");
        }

        //7.make the end of browser after sleeping 5s
        Thread.sleep(5000);
        driver.quit();






    }




}
