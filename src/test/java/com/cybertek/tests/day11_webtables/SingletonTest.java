package com.cybertek.tests.day11_webtables;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SingletonTest {
    @Test
    public void test1(){
        String s1=Singleton.getInstance();
        String s2=Singleton.getInstance();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }
}
