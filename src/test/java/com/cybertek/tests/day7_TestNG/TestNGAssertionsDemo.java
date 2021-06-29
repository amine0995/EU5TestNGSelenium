package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1() {
        System.out.println("first assertion");
        Assert.assertEquals("title", "titlE");

        System.out.println("second assertion");  //this code and under are not executed as the above ling is failed
        Assert.assertEquals("url", "url"); //if one assertion step is failed  in testing, the rest of the
        // code doesn't run or ignored or skipped

    }  //close
    @Test
    public void test2(){
        Assert.assertEquals("test2","test22","verify test2");




    }
    @Test
    public void test3(){
        String expectedTitle="Cyb";
        String actualTitle="Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle)," verify title starts with Cyb");
    }

    @Test
    public void test4(){
        //verify email contains @sign
        String email="mike@smith.com";
        Assert.assertTrue(email.contains("@"),"verify email contains @");
    }

    @Test
    public void test5(){
        Assert.assertFalse(0>1,"verify that 0 is not greater than 1");
    }

    @Test
    public void test6(){
        Assert.assertNotEquals("one","two");
    }

}
