package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.xml.ws.WebEndpoint;
import java.util.Set;

public class MultipleWindows {
   WebDriver driver;
   @BeforeMethod
    public void setUp(){
       driver= WebDriverFactory.getDriver("chrome");

   }
   @Test
    public void SwitchWindowsTest(){
       driver.get("http://practice.cybertekschool.com/windows");
       //get title
       System.out.println("title before new window= " + driver.getTitle());
       driver.findElement(By.linkText("Click Here")).click();
       System.out.println("title after new window = " + driver.getTitle());
       String currentWindowHandle= driver.getWindowHandle();
       Set<String> windowHandles= driver.getWindowHandles();
       for(String handle: windowHandles){
           if(!handle.equals(currentWindowHandle)){
               driver.switchTo().window(handle);
           }
       }
       System.out.println("title after switch new window " + driver.getTitle());

   }

   @Test
    public void morethan2Windows(){
       driver.get("http://practice.cybertekschool.com/windows");
       driver.findElement(By.xpath("//a[text()='Click Here']")).click();
       System.out.println("title before switching:  " + driver.getTitle());
       //this line code gives the window value to windowHandle array.
       Set<String> windowHandles= driver.getWindowHandles();

       //loop through each window
       for(String handle: windowHandles){
           //one by one check it
           driver.switchTo().window(handle);
           //whenever yout title equals to your expected window title
           if(driver.getTitle().equals("New Window")){
               //stop on that window
               break;
           }
       }

       System.out.println("after switch: " + driver.getTitle());


   }
}
