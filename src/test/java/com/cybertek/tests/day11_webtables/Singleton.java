package com.cybertek.tests.day11_webtables;

public class Singleton {
    //singleton class will have private constructor
    //it means other classes cannot create object create of this class
    private Singleton(){}

    private static String str;
    public static String getInstance(){
        //if str has no value,initialize it and return it
        if(str==null){
            System.out.println("str is null. Assign value to it.");
            str="somevalue";

        }else{
            // if it has value just return it
            System.out.println("it has value,just returning it");
        }

        return str;

    }




}
