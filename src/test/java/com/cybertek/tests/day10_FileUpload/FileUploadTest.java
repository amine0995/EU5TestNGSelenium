package com.cybertek.tests.day10_FileUpload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/upload");
        //locating choose file button
        WebElement chooseFile= driver.findElement(By.name("file"));
        //sending file path to the choose file
//        chooseFile.sendKeys("C:\\Users\\gebruiker\\Documents\\1.txt");//this is path of 1.txt in my computer
        //or we can change the double backward slash with one forward slash
        String projectPath=System.getProperty("user.dir");
        //
        String filePath="src/test/resources/textfile.txt";

        String fullPath=projectPath+"/"+filePath;//path of filetext.txt in project
        System.out.println(fullPath);

        chooseFile.sendKeys(fullPath);



        //upload  button
        driver.findElement(By.id("file-submit")).click();
        //getting the file name from the browser
        String actualFileName=driver.findElement(By.id("uploaded-files")).getText();
        //print uploaded file name
        System.out.println("actualFileName = " + actualFileName);
        //verify the file name is 1.txt
        Assert.assertEquals(actualFileName,"textfile.txt");




    }


}
