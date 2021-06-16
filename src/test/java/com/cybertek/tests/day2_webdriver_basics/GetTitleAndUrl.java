package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndUrl {
    public static void main(String[] args) {
        //task: open chrome and navigate to http://practice.cybertekchool.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com");

        //getting title with selenium
        String title = driver.getTitle();//alt+enter, show you the title of the page
        System.out.println(title);
        //shortcut for :soutv+enter
        System.out.println("title = " + title);
        //get url from the browser
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        //getPageSource()==>get the source of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);








    }
}
