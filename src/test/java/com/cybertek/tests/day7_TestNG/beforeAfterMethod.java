package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class beforeAfterMethod {
    @BeforeClass
    public void  setUpClass(){
        System.out.println("---before class---");
        System.out.println("executed one time before everything in the code");
    }

    @Test
    public void test1(){
        //System.out.println("WebDriver,Opening browser");
        System.out.println("First test case");
       // System.out.println("closing browser, quit");

    }
    @Ignore //below test is ignored
    @Test
    public void test2(){
        System.out.println("second test case");
    }

    @Test
    public void test3(){
        System.out.println("this is test 3");
    }
    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
        System.out.println("WebDriver,Opening browser");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
        System.out.println("closing browser,quit");

    }
    @AfterClass //runs only once after everything in the class
    public void tearDownClass(){
        System.out.println("---after class---");
        System.out.println("stop reporting code here");
    }
}
