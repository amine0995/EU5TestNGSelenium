package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase3 {
    /*
    Go to wikipedia.org (Links to an external site.)
enter search term `selenium webdriver`
click on search button
click on search result `Selenium (software)`
verify url ends with `Selenium_(software)'
     */
    public static void main(String[] args) throws InterruptedException {
        //1.open the chrome
        WebDriver driver= WebDriverFactory.getDriver("CHROME");
        //2.go to the url
        driver.get("https://www.wikipedia.org");
        //maximize the window
        driver.manage().window().maximize();
        //3. search input search box
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        //4.enter Selenium (software) into the search box
        searchInput.sendKeys("Selenium (software)");
        //5.click search button
        driver.findElement(By.cssSelector("i.sprite.svg-search-icon")).click();
        //6.verify the url ends with "Selenium_(software)"
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        if(currentUrl.endsWith("Selenium_(software)")){
            System.out.println("pass");
        }else{
            System.out.println("fail");

        }


    }

}
