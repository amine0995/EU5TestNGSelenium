package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {
    //task: write a static method that takes a string parameter name: browser type. based on the value of parameter it
    //will setup the browser and the method will return chromedriver of firefox object. name of the object is -
    //getDriver

    public static WebDriver getDriver( String browserType) {
        WebDriver driver=null;
       switch(browserType.toLowerCase()) {
           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
           case " firefox":
               WebDriverManager.firefoxdriver().setup();
               driver = new FirefoxDriver();
               break;

       }
       return driver;


    }
}
