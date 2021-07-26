package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iFrameTest {
          WebDriver driver;

          @BeforeMethod
    public void setUp(){
              driver= WebDriverFactory.getDriver("chrome");
          }

          @AfterMethod
    public void tearDown() throws InterruptedException {
//              Thread.sleep(3000);
//              driver.quit();
          }

          @Test
    public void test1() throws InterruptedException {
              driver.get("http://practice.cybertekschool.com/iframe");

              //how to switch frames
              //1.switch using by name or ID attribute of iframe

              driver.switchTo().frame("mce_0_ifr");
              Thread.sleep(2000);
              //clear before sendkeys
              driver.findElement(By.cssSelector("#tinymce")).clear();
              driver.findElement(By.cssSelector("#tinymce")).sendKeys("keeping good work");

              //goes back to first frame(main html)
              //goes back to first frame,useful when we have switched multiple frames
              driver.switchTo().defaultContent();

              //2.switching with index
              driver.switchTo().frame(0);

              //clear before sendkeys
             driver.findElement(By.cssSelector("#tinymce")).clear();
              Thread.sleep(1000);
              driver.findElement(By.cssSelector("#tinymce")).sendKeys("    work 1 ");

              //second way to switch parent
              driver.switchTo().parentFrame();

              //3.using webelement
              WebElement iframeElement=driver.findElement(By.tagName("iframe"));

              driver.switchTo().frame(iframeElement);

              Thread.sleep(1000);
              driver.findElement(By.cssSelector("#tinymce")).sendKeys("work with web element");




          }

          @Test
    public void test2(){
              driver.get("http://practice.cybertekschool.com/nested_frames");
              driver.manage().window().maximize();
              //switching to frame top
              driver.switchTo().frame("frame-top");
              // top has 3 frame under left middle and right
              //switch to middle frame
             driver.switchTo().frame("frame-middle");

              System.out.println(driver.findElement(By.id("content")).getText());

              //goes back to top frame
              driver.switchTo().parentFrame();

              //switching right with index
              driver.switchTo().frame(2);

              System.out.println(driver.findElement(By.tagName("body")).getText());

              //go to main html to switch bottom
              driver.switchTo().defaultContent();
              driver.switchTo().frame(1);
              System.out.println(driver.findElement(By.tagName("body")).getText());




          }


}
