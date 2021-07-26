package com.cybertek.tests.day10_actions_js;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTests {
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
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        //locate first photo
        WebElement img1 = driver.findElement(By.tagName("img"));
        //Actions---> class that contains all the user interactions
        //how to create actions object--->passing driver as a constructor
        Actions actions = new Actions(driver);

        //perform()--> perform the action,complete the action
        //moveToElement--->move your mouse to web element(hover over)
        Thread.sleep(3000);
        actions.moveToElement(img1).perform();

        WebElement viewLink = driver.findElement(By.linkText("View profile"));
        //view profile can be located also: //*[.='View profile']

        Assert.assertTrue(viewLink.isDisplayed(), "verify view link is displayed");

    }

    @Test
    public void  dragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();

        Actions actions=new Actions(driver);

        //locate drag circle
        WebElement source= driver.findElement(By.id("draggable"));
        //locate big drop circle
        WebElement target= driver.findElement(By.id("droptarget"));

        //accept cookie pop ups handeling
        Thread.sleep(3000);
      driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler")).click();
        Thread.sleep(2000);
        //drag small circle and drop it to big circle//this is one solution
       // actions.dragAndDrop(source,target).perform();


        // this is second solution
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

        //verify that it draged successfully
       // Assert.







    }
}
