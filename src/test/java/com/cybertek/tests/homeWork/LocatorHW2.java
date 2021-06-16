package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatorHW2 {
    public static void main(String[] args) {
        /*
        XPATH PRACTICES

DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.

1. Open Chrome browser

2. Go to http://practice.cybertekschool.com/forgot_passwordKoppelingen naar een externe site.

3. Locate all the WebElements on the page using XPATH locator only (total of 6)

   a. “Home” link

   b. “Forgot password” header

   c. “E-mail” text

   d. E-mail input box

   e. “Retrieve password” button



4.Print text of a,b,c,e and put some email to d
         */


    //1.open chrome browser
    WebDriver driver= WebDriverFactory.getDriver("chrome");
    //2.go to http://practice.cybertekschool.com/forget_password
    driver.get("http://practice.cybertekschool.com/forgot_password");
    //3.locate all elements
        //a-->home
        WebElement home= driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println("text of a is : "+ home.getText());
        //b-->forget password header
        WebElement ForgetPassword= driver.findElement(By.xpath("//h2"));
        System.out.println("text of b is: "+ ForgetPassword.getText());
        //c-->
        WebElement email= driver.findElement(By.xpath("//label"));
        System.out.println("text of c is :"+email.getText());
        //d-->email input box
        WebElement emailInput= driver.findElement(By.xpath("//input[@name='email']"));
        System.out.println("text of d is: "+emailInput.getText());
        //e-->retrieve password button
        WebElement RetrievePassword= driver.findElement(By.xpath("//button"));
        System.out.println("text of e is:"+ driver.findElement(By.xpath("//i[text()='Retrieve password']")).getText());
       //4. put email content to d
        emailInput.sendKeys("mike@smith.com");






}
}