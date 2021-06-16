package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLchanged {
    public static void main(String[] args) throws InterruptedException {


         /*  verify url  changed
        -open chrome browser
        -go to http://practice.cybertekschool.com/forgot_password Links to an external site
        -enter any email
        -verify that url  changed to http://practice.cybertekschool.com/email_sent
         */
       //OPEN CHROME BROWSER
        WebDriver driver =WebDriverFactory.getDriver("chrome");

        //go to url
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //enter any email
        WebElement emailInputBox=driver.findElement(By.name("email"));

        //sendKeys()-->send keyboard action to the webElement
        emailInputBox.sendKeys("mike@cybertek.com");

        WebElement retrievePasswordButton= driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();

        Thread.sleep(4000);

        //TASK
        //verify that url changed to http://practice.cybertekschool.com/email_sent
        //create expectedUrl
        String expectedUrl=" http://practice.cybertekschool.com/email_sent";
        String actualUrl=driver.getCurrentUrl();

        if(expectedUrl.equals(actualUrl)){
            System.out.println("pass");
        }else{
            System.out.println("fail");
            System.out.println(" expectedUrl= "+expectedUrl);
            System.out.println(" actualUrl=   "+  actualUrl);
        }
        //close browser
        driver.quit();

    }



}
