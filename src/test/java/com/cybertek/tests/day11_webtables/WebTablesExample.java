package com.cybertek.tests.day11_webtables;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTablesExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/tables");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void printTable1(){
        WebElement table= driver.findElement(By.xpath("//table[@id='table1']"));

        System.out.println(table.getText());//print all table1

        Assert.assertTrue(table.getText().contains("jdoe@hotmail"));


    }
    @Test
    public void getAllHeaders(){
        //how many columns we have?
        List<WebElement> headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("headers.size() = " + headers.size());//6

        for (WebElement header : headers) {
            System.out.println( header.getText());//Last Name, First Name,  Email, Due,  Web Site, Action
        }



    }
    @Test
    public void printTableSize(){
        //how many columns we have?
        List<WebElement> headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("number of  columns "+headers.size());//6

        //number of rows
        List<WebElement> allRowsWithHeader = driver.findElements(By.xpath("//table[@id='table1']//tr"));//tr indicates table row
        System.out.println("number of rows "+allRowsWithHeader.size());//5


        //number of rows without header(this is preferred)
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        //tbody indicates actual data's of the table (without header or title)
        System.out.println("number of rows without header "+allRowsWithoutHeader.size());//4
        //System.out.println("allRowsWithoutHeader = " + allRowsWithoutHeader);
        //allRowsWithoutHeader is a Arraylist so can't directly be printed


    }
    @Test
    public void getRow(){
        //print the second row information
        WebElement row2= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());

        //get all rows dynamically
        List<WebElement> numRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        for (int i = 1; i <= numRows.size(); i++) {

            WebElement row= driver.findElement(By.xpath("//table[@id='table1']/tbody/tr["+i+"]"));
            System.out.println(i+"-" +row.getText());

        }

    }
    @Test
    public void getAllCellInOneRow(){
        List<WebElement> allCellsInRow3 = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[3]"));
        // to print out elements in  ArrayList of a row (here row 3)
        for (WebElement element : allCellsInRow3) {
            System.out.println(element.getText());

        }

    }
    @Test
    public void getAsingleCellByIndex(){
        WebElement singelCell = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[5]"));
        System.out.println("singelCell.getText() = " + singelCell.getText());



    }
    @Test
    public void printAllCellsByIndex(){
        int rowNumber=getNumberofRows();
        int columnNumber=getNumberOfColumns();

        //print number of columns:
        System.out.println("columnNumber = " + columnNumber);

        //print number of rows
        System.out.println("rowNumber = " + rowNumber);

        //iterate through each row on the table

        for (int i = 1; i <=rowNumber; i++) {

            //iterate through each cell in the row
            for (int j = 1; j <=columnNumber; j++) {
                //locate each cell
                String cellXpath="//table[@id='table1']/tbody/tr["+i+"]/td["+j+"]";
                System.out.println(cellXpath);

                WebElement cell= driver.findElement(By.xpath(cellXpath));
                System.out.println(cell.getText());



            }

        }


    }
     @Test
     public void getCellInRelationToAnotherCellInSameRow(){
        String firstName="Jason";

        String xpath="//table[@id='table1']//td[.='"+firstName+"']/../td[3]";


         WebElement  email = driver.findElement(By.xpath(xpath));
         System.out.println("email.getText() = " + email.getText());

     }

    private int getNumberOfColumns() {
        List<WebElement> headers= driver.findElements(By.xpath("//table[@id='table1']//th"));
        return headers.size();
    }

    private int getNumberofRows() {
        List<WebElement> allRowsWithoutHeader = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        return allRowsWithoutHeader.size();
    }
}