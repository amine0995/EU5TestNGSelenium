package com.cybertek.tests.homeWork;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestCase1 {
    /*
    Go to Ebay
enter search term
click on search button
print number of results
     */
    public static void main(String[] args) {
        //1.open chrome browser
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        //2. go to ebay.com
        driver.get("https://www.ebay.com");
        //3.search input box
        WebElement searchInput=driver.findElement(By.cssSelector("input.gh-tb.ui-autocomplete-input"));
        //4.send keyboard action to the inputbox
        searchInput.sendKeys("lamp");
        //5.click search button
        driver.findElement(By.cssSelector("input#gh-btn")).click();
        //6.print number of results
        WebElement element = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']/span"));
        String result = element.getText();

        System.out.println(result);
        //end browser
        driver.quit();






    }





}
