package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class beforeAfterMethod {

    @Test
    public void test1(){
        //System.out.println("WebDriver,Opening browser");
        System.out.println("First test case");
       // System.out.println("closing browser, quit");

    }
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
    @AfterClass
    public void tearDownClass(){
        System.out.println("---after class---");
        System.out.println("stop reporting code here");
    }
}
